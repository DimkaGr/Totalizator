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
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.HttpJspPage;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/sign_in")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/sign_in_page.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login=req.getParameter("login");
        String password=req.getParameter("password");
        UserService userService=null;
        try {
            userService = ServiceFactory.getInstance().getUserService();
        }catch (SQLException | ServiceException e){
            throw new ServletException("Failed while getting user service",e);
        }
        try {
            if(userService.getUser(login,password)!=null){
                req.setAttribute("entry","true");
            }
            else{
                req.setAttribute("loginErrors","true");
            }
            req.getRequestDispatcher("/WEB-INF/views/sign_in_page.jsp").forward(req,resp);
        }catch(ServiceException e){
            req.setAttribute("errors","true");
            req.getRequestDispatcher("/WEB-INF/views/error_page.jsp").forward(req,resp);
        }
    }
}
