package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.domain.Competition;
import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.CompetitionService;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CompetitionsListCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent=new ResponseContent();
        List<Competition> competitions=new ArrayList<>();
        CompetitionService competitionService= ServiceFactory.getInstance().getCompetitionService();
        try {
            competitions=competitionService.getAll();
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/competitions_page.jsp"));
        }catch(ServiceException e){
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/error_page.jsp"));

        }
        request.setAttribute("competitions",competitions);
        return responseContent;
    }
}
