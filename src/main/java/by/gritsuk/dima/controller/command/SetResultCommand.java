package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.domain.Bet;
import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.ClientBetService;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class SetResultCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent = new ResponseContent();
        HttpSession session = request.getSession();
        List<Bet> bets = (List<Bet>) session.getAttribute("bets");
        ClientBetService clientBetService = ServiceFactory.getInstance().getClientBetService();
        String status;
        try {
            for (Bet bet : bets) {
                status = request.getParameter("bet" + bet.getId());
                clientBetService.updateStatus(bet.getId(), status);
            }
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/bookmaker_page.jsp"));
        } catch (ServiceException e) {

        }
        return responseContent;
    }
}
