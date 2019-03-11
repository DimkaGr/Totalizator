package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.domain.Bet;
import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.BetService;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ChooseEventCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent = new ResponseContent();
        List<Bet> bets = new ArrayList<>();
        BetService betService = ServiceFactory.getInstance().getBetService();
        try {
            bets = betService.getAllByCompetition(Integer.parseInt(request.getParameter("id")));
            HttpSession session=request.getSession();
            session.setAttribute("competitionName",request.getParameter("competitionName"));
            responseContent.setRouter(new Router(Router.Type.FORWARD, "/WEB-INF/views/make_bet_page3.jsp"));
        } catch (ServiceException e) {
            responseContent.setRouter(new Router(Router.Type.FORWARD, "/WEB-INF/views/error_page.jsp"));

        }
        request.setAttribute("bets", bets);
        return responseContent;
    }
}
