package by.gritsuk.dima.controller.servlet;

import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.UserService;
import by.gritsuk.dima.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/list")
public class UserListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User>users=new ArrayList<>();
        List<String> userNames=new ArrayList<>();
        UserService userService=ServiceFactory.getInstance().getUserService();
        try {
            users=userService.getAll();
//            userNames=users.stream()
//                    .map(User::getLogin)
//                    .collect(Collectors.toList());
        }catch(ServiceException e){
            throw new ServletException("Failed while getting users from database",e);
        }
        req.setAttribute("user",users);
        req.getRequestDispatcher("/WEB-INF/views/list_page.jsp").forward(req,resp);
    }

}
