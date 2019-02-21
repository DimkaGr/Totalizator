package by.gritsuk.dima.controller.servlet;

import by.gritsuk.dima.domain.Admin;
import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.UserService;
import by.gritsuk.dima.service.exception.ServiceException;
import by.gritsuk.dima.service.exception.UserRegisterException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/add_page.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=new Admin();
        user.setFirstName(req.getParameter("first_name"));
        user.setLastName(req.getParameter("last_name"));
        user.setEmail(req.getParameter("email"));
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        user.setRole_id(1);
        UserService userService=null;
        try {
            userService = ServiceFactory.getInstance().getUserService();
        }catch (SQLException|ServiceException e){
            throw new ServletException("Failed while getting user service",e);
        }
        try {
            userService.signUp(user);
        }catch(ServiceException e){
            throw new ServletException("Failed while adding user to database",e);
        }
        catch (UserRegisterException e){
//            req.setAttribute("errors",false);
//            req.getRequestDispatcher("/WEB-INF/views/add_page.jsp").forward(req,resp);
        }
        req.setAttribute("user",user.getLogin());
        req.getRequestDispatcher("/WEB-INF/views/add_page.jsp").forward(req,resp);
    }
}
