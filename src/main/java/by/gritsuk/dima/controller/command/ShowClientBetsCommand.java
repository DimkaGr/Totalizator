package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.domain.Client;
import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.dto.ClientBetResponse;
import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.ClientBetService;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowClientBetsCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent=new ResponseContent();
        List<ClientBetResponse> clientBets;
        ClientBetService clientBetService= ServiceFactory.getInstance().getClientBetService();
        HttpSession session=request.getSession();
        if(((Client)session.getAttribute("user")).getStatus().equals("waiting_confirmation")){
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/client_page.jsp"));
            request.setAttribute("notActive","true");
            return responseContent;
        }
        int id=((User)session.getAttribute("user")).getId();
        try {
            clientBets=clientBetService.showClientBets(id);
            request.setAttribute("clientBets",clientBets);
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/client_bets_page.jsp"));
        } catch (ServiceException e) {
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/error_page.jsp"));

        }
        return responseContent;
    }
}
