package Services;

import Entities.Game;
import Entities.User;
import com.google.gson.Gson;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
public class CreateAccount extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setGames(new ArrayList<Game>());
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try{
            emf = Persistence.createEntityManagerFactory("GameTrax");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            em.close();
            emf.close();
        }catch(Exception e){
            PrintWriter out = response.getWriter();
            e.printStackTrace(out);
        }

        Gson gson = new Gson();
        response.setContentType("text/json");
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(user).toString());
        out.flush();
    }
}
