package Services;

import Entities.Game;
import Entities.Image;
import Entities.User;
import com.google.gson.Gson;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by spencerlandis on 4/19/14.
 */
public class AddGame extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = null;
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        Game game = null;
        int game_id = Integer.parseInt(request.getParameter("game_id"));
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try{
            emf = Persistence.createEntityManagerFactory("GameTrax");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            user = (User) em.find(User.class, user_id);
            game = (Game) em.find(Game.class, game_id);
            if(user != null && game != null)
            {
                user.getGames().add(game);
                em.getTransaction().commit();
            }
            else if(user != null)
            {
                game = new Game();
                game.setGame_id(game_id);
                Image i = new Image();
                i.setIconUrl(request.getParameter("icon_url"));
                i.setMediumUrl(request.getParameter("medium_url"));
                i.setScreenUrl((request.getParameter("screen_url")));
                i.setSmallUrl(request.getParameter("small_url"));
                i.setThumbUrl(request.getParameter("thumb_url"));
                i.setTinyUrl(request.getParameter("tiny_url"));
                em.persist(i);
                em.getTransaction().commit();
                em.getTransaction().begin();
                game.setImage(i);
                game.setDeck(request.getParameter("deck"));
                game.setName(request.getParameter("name"));
                game.setSiteDetailUrl(request.getParameter("site_detail_url"));
                em.persist(game);
                System.out.println("hello?");
                em.getTransaction().commit();
                em.getTransaction().begin();
                user.getGames().add(game);
                em.getTransaction().commit();
            }
            else
            {
                response.setContentType("text/plain");
                PrintWriter out = response.getWriter();
                out.print("failure");
                out.flush();
            }
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.print("success");
            out.flush();
        }catch(Exception e){
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.println("failure");
            e.printStackTrace(out);
            out.flush();
        }
        finally
        {
            em.close();
            emf.close();
        }

    }
}
