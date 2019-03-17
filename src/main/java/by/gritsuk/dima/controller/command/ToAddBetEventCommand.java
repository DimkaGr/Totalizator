package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.dto.ResponseContent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ToAddBetEventCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent=new ResponseContent();
        responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/add_bet_page3.jsp"));
        HttpSession session=request.getSession();
        session.setAttribute("id",Integer.parseInt(request.getParameter("id")));
        return responseContent;
    }
}
