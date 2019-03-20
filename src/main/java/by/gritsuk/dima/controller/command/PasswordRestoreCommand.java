package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.domain.RegistrationKey;
import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.RegistrationKeysService;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.UserService;
import by.gritsuk.dima.service.exception.ServiceException;
import by.gritsuk.dima.util.MailSender;
import by.gritsuk.dima.util.StringGenerator;
import by.gritsuk.dima.util.exception.UtilException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PasswordRestoreCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent=new ResponseContent();
        String login=request.getParameter("login");
        String email=request.getParameter("email");
        UserService userService= ServiceFactory.getInstance().getUserService();

        HttpSession session=request.getSession();
        try {
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/confirm_restore_page.jsp"));
            User user=userService.getUserForRestoring(login,email);
            if(user!=null){
                MailSender sender=MailSender.getInstance();
                if(sender!=null){
                    String key= StringGenerator.generate();
                    RegistrationKey registrationKey=new RegistrationKey();
                    registrationKey.setId(user.getId());
                    registrationKey.setKey(key);
                    RegistrationKeysService registrationService=ServiceFactory.getInstance().getRegistrationService();
                    registrationService.add(registrationKey);
                    sender.sendMail("Your code to confirm is "+key,email);
                    session.setAttribute("userLog",user);
                }
            }
            else{
                request.setAttribute("errors","true");
                responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/restoring_password_page.jsp"));

            }
        }catch(ServiceException e){
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/error_page.jsp"));
        } catch (UtilException e){
            //couldn't send mail error page
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/restoring_password_page.jsp"));
            request.setAttribute("sendMailError","true");
        }
//        request.setAttribute("userLogin",login);
        return responseContent;
    }
}
