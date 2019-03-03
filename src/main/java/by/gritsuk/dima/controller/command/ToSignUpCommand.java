package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.dto.ResponseContent;

import javax.servlet.http.HttpServletRequest;

public class ToSignUpCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent=new ResponseContent();
        responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/add_page.jsp"));
        return responseContent;
    }
}
