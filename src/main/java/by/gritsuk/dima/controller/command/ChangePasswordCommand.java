package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.UserService;
import by.gritsuk.dima.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ChangePasswordCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent=new ResponseContent();
        String password1=request.getParameter("password");
        String password2=request.getParameter("passwordRep");
        if(password1.equals(password2)){
            HttpSession session=request.getSession();
            UserService userService= ServiceFactory.getInstance().getUserService();
            User user=(User)session.getAttribute("user");
            try {
                userService.changePassword(password1,user.getId(),user.getLogin());
                session.setAttribute("role", user.getRole_id());
                responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/main_page.jsp"));
            } catch (ServiceException e) {
                responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/error_page.jsp"));
            }
        } else{
            request.setAttribute("passwordError","true");
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/change_password_page.jsp"));
        }
        return responseContent;
    }
}
