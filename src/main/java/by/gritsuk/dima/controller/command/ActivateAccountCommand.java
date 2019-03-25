package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.UserService;
import by.gritsuk.dima.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ActivateAccountCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent=new ResponseContent();
        UserService userService= ServiceFactory.getInstance().getUserService();
        HttpSession session=request.getSession();
        try {
            User user=userService.activateUser(Integer.parseInt(request.getParameter("id")));
            session.setAttribute("user",user);
            session.setAttribute("role",user.getRoleId());
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/main_page.jsp"));
        }catch(ServiceException e){
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/error_page.jsp"));
        }
        return responseContent;
    }
}
