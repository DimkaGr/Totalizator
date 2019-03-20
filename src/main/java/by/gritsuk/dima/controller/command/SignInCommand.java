package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.UserService;
import by.gritsuk.dima.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SignInCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent=new ResponseContent();
        String login=request.getParameter("login");
        String password=request.getParameter("password");
        UserService userService= ServiceFactory.getInstance().getUserService();
        HttpSession session=request.getSession();
        try {
            User user=userService.getUserForLogin(login,password);
            if(user!=null){
                session.setAttribute("user",user);
                session.setAttribute("role",user.getRoleId());
                responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/main_page.jsp"));
            }
            else{
                request.setAttribute("loginErrors","true");
                responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/sign_in_page.jsp"));
            }
        }catch(ServiceException e){
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/error_page.jsp"));
        }
        return responseContent;
    }
}
