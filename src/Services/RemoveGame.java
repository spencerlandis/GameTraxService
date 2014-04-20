package Services;

import Entities.Game;
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
public class RemoveGame extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        int game_id = Integer.parseInt(request.getParameter("game_id"));
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try{
            emf = Persistence.createEntityManagerFactory("GameTrax");
            em = emf.createEntityManager();
            em.getTransaction().begin();

            User user = em.find(User.class, user_id);
            Game game = em.find(Game.class, game_id);
            for(int i = 0; i < user.getGames().size(); i++)
            {
                if(user.getGames().get(i).getGame_id()==game.getGame_id())
                {
                    user.getGames().remove(i);
                }
            }
            em.getTransaction().commit();

            PrintWriter out = response.getWriter();
            out.print("success");
            out.flush();
            out.close();
        }catch(Exception e){
            PrintWriter out = response.getWriter();
            e.printStackTrace(out);
        }
        finally
        {
            em.close();
            emf.close();
        }

    }
}
