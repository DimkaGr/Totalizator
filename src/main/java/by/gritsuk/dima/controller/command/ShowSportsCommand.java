package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.domain.Sport;
import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.KindOfSportService;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ShowSportsCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent=new ResponseContent();
        List<Sport> sports=new ArrayList<>();
        KindOfSportService sportService= ServiceFactory.getInstance().getKindOfSportService();
        try {
            sports=sportService.getAll();
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/show_sports_page.jsp"));
        }catch(ServiceException e){
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/error_page.jsp"));

        }
        request.setAttribute("sports",sports);
        return responseContent;
    }
}
