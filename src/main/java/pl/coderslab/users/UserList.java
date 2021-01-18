package pl.coderslab.users;

import pl.coderslab.ConnectionSQL.User;
import pl.coderslab.ConnectionSQL.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/list")
public class UserList extends HttpServlet {
    private static int counter=0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = new UserDao();
        request.setAttribute("users", userDao.findAllUsers());
        getServletContext().getRequestDispatcher("/users/list.jsp")
                .forward(request, response);
        System.out.println("odpalam"+counter);
        counter++;
    }
}
