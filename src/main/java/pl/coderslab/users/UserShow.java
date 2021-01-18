package pl.coderslab.users;

import pl.coderslab.ConnectionSQL.User;
import pl.coderslab.ConnectionSQL.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/show")
public class UserShow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        UserDao userDao=new UserDao();
        User user= userDao.readUser(id);
        request.setAttribute("user",user);
        getServletContext().getRequestDispatcher("/users/showUser.jsp")
                .forward(request,response);

    }
}
