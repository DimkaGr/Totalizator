package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.domain.Bet;
import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.BetService;
import by.gritsuk.dima.service.CompetitionService;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.exception.ServiceException;
import by.gritsuk.dima.util.ResultGenerator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GenerateResultCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent=new ResponseContent();
        int competitionId=Integer.parseInt(request.getParameter("id"));
        HttpSession session=request.getSession();
        int sportId=(Integer)session.getAttribute("sportId");
        String result= ResultGenerator.generate(sportId);
        CompetitionService competitionService= ServiceFactory.getInstance().getCompetitionService();
        BetService betService=ServiceFactory.getInstance().getBetService();
        List<Bet> bets;
        try {
            String res=competitionService.updateResult(competitionId,result);
            bets=betService.getAllByCompetition(competitionId);
            session.setAttribute("bets",bets);
            request.setAttribute("result",res);
            responseContent.setRouter(new Router(Router.Type.FORWARD, "/WEB-INF/views/bet_result_page.jsp"));
        } catch (ServiceException e) {
            request.setAttribute("resultError","true");
            responseContent.setRouter(new Router(Router.Type.FORWARD, "/WEB-INF/views/generate_result_page2.jsp"));
        }
        return responseContent;
    }
}
