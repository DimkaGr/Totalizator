package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.domain.Admin;
import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.UserService;
import by.gritsuk.dima.service.exception.ServiceException;
import by.gritsuk.dima.service.exception.UserRegisterException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class UserRegisterCommand implements Command{
    @Override
    public ResponseContent execute(HttpServletRequest request){
        User user=new Admin();
        user.setFirstName(request.getParameter("first_name"));
        user.setLastName(request.getParameter("last_name"));
        user.setEmail(request.getParameter("email"));
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        user.setRole_id(1);
        UserService userService=null;
        ResponseContent responseContent=new ResponseContent();
        try {
            userService = ServiceFactory.getInstance().getUserService();
            userService.signUp(user);
            request.setAttribute("user",user.getLogin());
//            responseContent.setRouter(new Router(Router.Type.REDIRECT,"?command="+CommandType.ADD_USER));
            responseContent.setRouter(new Router(Router.Type.REDIRECT,"/WEB-INF/views/add_page.jsp"));
            return responseContent;
        }catch(ServiceException|UserRegisterException e){

        }
        return responseContent;
    }
}
