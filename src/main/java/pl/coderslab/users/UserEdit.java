package pl.coderslab.users;

import pl.coderslab.ConnectionSQL.User;
import pl.coderslab.ConnectionSQL.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String email=request.getParameter("email");
        String password=request.getParameter("password");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        getServletContext().getRequestDispatcher("/users/editUser.jsp").forward(request,response);
    }
}
