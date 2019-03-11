package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.UserService;
import by.gritsuk.dima.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ShowUserListCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent=new ResponseContent();
        List<User> users=new ArrayList<>();
        List<String> userNames=new ArrayList<>();
        UserService userService= ServiceFactory.getInstance().getUserService();
        try {
//            users=userService.getAll();
            users=userService.getAllClients();
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/list_page.jsp"));
        }catch(ServiceException e){
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/error_page.jsp"));
        }
        request.setAttribute("users",users);
        return responseContent;
    }
}
