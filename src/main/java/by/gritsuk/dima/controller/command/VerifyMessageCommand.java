package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.domain.RegistrationKey;
import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.RegistrationKeysService;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.UserService;
import by.gritsuk.dima.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class VerifyMessageCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent=new ResponseContent();
        String code=request.getParameter("code");
//        String login=(String)request.getAttribute("userLogin");
        RegistrationKeysService keysService= ServiceFactory.getInstance().getRegistrationService();
        UserService userService=ServiceFactory.getInstance().getUserService();
        try {
            HttpSession session=request.getSession();
//            User user=userService.getByLogin(login);
            User user=(User)session.getAttribute("userLog");
            String key=keysService.getByUserId(user.getId()).getKey();
            if(key.equals(code)){
                session.setAttribute("user",user);
                responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/change_password_page.jsp"));
            }else {
                request.setAttribute("invalidKey","true");
                responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/confirm_restore_page.jsp"));
            }
        } catch (ServiceException e) {
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/error_page.jsp"));
        }
        return responseContent;
    }
}
