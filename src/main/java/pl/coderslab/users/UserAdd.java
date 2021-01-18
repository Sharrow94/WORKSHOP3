package pl.coderslab.users;

import pl.coderslab.ConnectionSQL.User;
import pl.coderslab.ConnectionSQL.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/add")
public class UserAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        UserDao userDao=new UserDao();
        userDao.createUser(new User(username,email,password));
        response.sendRedirect("/list");
        System.out.println("tworze nowego uzytkownika");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/users/createUser.jsp")
                .forward(request, response);
    }
}
