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
import java.sql.SQLException;

public class ConfirmBetCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent=new ResponseContent();
        ClientBet clientBet=new ClientBet();
        HttpSession session=request.getSession();
        clientBet.setIncome((Double)session.getAttribute("expected"));
        clientBet.setDeposit((Double)session.getAttribute("value"));
        clientBet.setUserId(((Client)session.getAttribute("user")).getId());
        clientBet.setBetId(((Bet)session.getAttribute("bet")).getId());
        clientBet.setStatus("in play");
        ClientBetService clientBetService= ServiceFactory.getInstance().getClientBetService();
        try {
            int id=((Client) session.getAttribute("user")).getClientAccountId();
            double cash=((Client) session.getAttribute("user")).getCash()-(Double)session.getAttribute("value");
            clientBetService.makeBet(clientBet,id,cash);
            Client user=(Client) session.getAttribute("user");
            user.setCash(cash);
            session.setAttribute("user",user);
//            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/main_page.jsp"));
            responseContent.setRouter(new Router(Router.Type.REDIRECT,request.getContextPath()+"/bets?command=to_main"));
        } catch (ServiceException|SQLException e) {
            request.setAttribute("betError","true");
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/confirm_bet_page.jsp"));

        }
        return responseContent;
    }
}
