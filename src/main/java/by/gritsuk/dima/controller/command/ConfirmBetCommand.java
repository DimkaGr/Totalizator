package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.domain.Bet;
import by.gritsuk.dima.domain.Client;
import by.gritsuk.dima.domain.ClientBet;
import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.ClientBetService;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ConfirmBetCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent=new ResponseContent();
        ClientBet clientBet=new ClientBet();
        HttpSession session=request.getSession();
        clientBet.setIncome((Double)session.getAttribute("expected"));
        clientBet.setDeposit((Double)session.getAttribute("value"));
        clientBet.setUser_id(((Client)session.getAttribute("user")).getId());
        clientBet.setBet_id(((Bet)session.getAttribute("bet")).getId());
        clientBet.setStatus("in play");
        ClientBetService clientBetService= ServiceFactory.getInstance().getClientBetService();
        try {
            clientBetService.makeBet(clientBet);
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/main_page.jsp"));
        } catch (ServiceException e) {

        }
        return responseContent;
    }
}
