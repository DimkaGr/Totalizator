package by.gritsuk.dima.controller.servlet;

import by.gritsuk.dima.domain.RegistrationKey;
import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.service.RegistrationKeysService;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.UserService;
import by.gritsuk.dima.service.exception.ServiceException;
import by.gritsuk.dima.util.MailSender;
import by.gritsuk.dima.util.StringGenerator;
import by.gritsuk.dima.util.exception.UtilException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/restore")
public class PasswordRestoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/restoring_password_page.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login=req.getParameter("login");
        String email=req.getParameter("email");
        UserService userService=ServiceFactory.getInstance().getUserService();
        try {
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
                }
            }
            else{
                req.setAttribute("errors","true");
            }
            req.getRequestDispatcher("/WEB-INF/views/restoring_password_page.jsp").forward(req,resp);
        }catch(ServiceException e){
            req.getRequestDispatcher("/WEB-INF/views/error_page.jsp").forward(req,resp);
        } catch (UtilException e){
            //couldn't send mail error page
        }
    }
}
