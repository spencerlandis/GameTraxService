package Services;

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
public class Login extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User();
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try{
            emf = Persistence.createEntityManagerFactory("GameTrax");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("from User WHERE email = :email AND password = :password");
            query.setParameter("email", email);
            query.setParameter("password", password);
            ArrayList<User> results = (ArrayList<User>) query.getResultList();
            em.close();
            emf.close();
            if(results.size() == 1)
            {
                Gson gson = new Gson();
                response.setContentType("text/json");
                PrintWriter out = response.getWriter();
                out.print(gson.toJson(results.get(0)).toString());
                out.flush();
            }
            else
            {
                response.setContentType("text/plain");
                PrintWriter out = response.getWriter();
                out.print("null");
                out.flush();
            }
        }catch(Exception e){
            PrintWriter out = response.getWriter();
            e.printStackTrace(out);
        }

    }
}
