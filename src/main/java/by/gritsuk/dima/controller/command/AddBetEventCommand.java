package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.domain.Bet;
import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.BetService;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AddBetEventCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent=new ResponseContent();
        responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/main_page.jsp"));
        HttpSession session=request.getSession();
        String eventName=request.getParameter("event_name");
        double factor=Double.parseDouble(request.getParameter("factor"));
        double minValue=Double.parseDouble(request.getParameter("minValue"));
        int competition_id=(Integer)session.getAttribute("id");
        Bet bet=new Bet();
        Bet.CompetitionEvent event=new Bet.CompetitionEvent();
        event.setFactor(factor);
        event.setEvent(eventName);
        bet.setEvent(event);
        bet.setMinValue(minValue);
        bet.setCompetitionId(competition_id);
        BetService betService= ServiceFactory.getInstance().getBetService();
        try {
            betService.add(bet);
        } catch (ServiceException e) {
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/error_page.jsp"));
        }
        return responseContent;
    }
}
