package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.dto.ResponseContent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogOutCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        HttpSession session=request.getSession();
//        session.setAttribute("user",null);
        session.invalidate();
        ResponseContent responseContent=new ResponseContent();
        responseContent.setRouter(new Router(Router.Type.REDIRECT,request.getContextPath()));
        return responseContent;
    }
}
