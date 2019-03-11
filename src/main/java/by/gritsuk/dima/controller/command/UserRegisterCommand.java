package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.domain.Admin;
import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.UserService;
import by.gritsuk.dima.service.exception.ServiceException;
import by.gritsuk.dima.service.exception.UserRegisterException;
import by.gritsuk.dima.validation.exception.LoginPersistException;

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
        UserService userService=ServiceFactory.getInstance().getUserService();
        ResponseContent responseContent=new ResponseContent();
        try {
            userService.signUp(user);
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/success_register_page.jsp"));
        }catch(ServiceException|UserRegisterException e){

        }catch (LoginPersistException e){
            request.setAttribute("loginError","true");
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/add_page.jsp"));
        }
        return responseContent;
    }
}
