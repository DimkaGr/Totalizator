package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.domain.Competition;
import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.CompetitionService;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ChooseCompetitionForBookmakerCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent = new ResponseContent();
        List<Competition> competitions = new ArrayList<>();
        CompetitionService competitionService = ServiceFactory.getInstance().getCompetitionService();
        try {
            competitions = competitionService.getAllBySport(Integer.parseInt(request.getParameter("id")));
            responseContent.setRouter(new Router(Router.Type.FORWARD, "/WEB-INF/views/add_bet_page2.jsp"));
        } catch (ServiceException e) {
            responseContent.setRouter(new Router(Router.Type.FORWARD, "/WEB-INF/views/error_page.jsp"));

        }
        request.setAttribute("competitions", competitions);
        return responseContent;
    }
}
