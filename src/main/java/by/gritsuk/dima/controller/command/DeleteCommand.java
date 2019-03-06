package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.domain.Admin;
import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.UserService;
import by.gritsuk.dima.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class DeleteCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        UserService userService= ServiceFactory.getInstance().getUserService();
        ResponseContent responseContent=new ResponseContent();
        User user=new Admin();
        user.setId(Integer.parseInt(request.getParameter("id")));
        responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/list_page.jsp"));

        try {
            userService.deleteUser(user);
        }catch(ServiceException e){
            request.setAttribute("errorDelete","true");
        }
        return responseContent;
    }
}
