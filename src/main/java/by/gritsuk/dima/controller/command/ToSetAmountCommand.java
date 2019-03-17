package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.domain.Bet;
import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.BetService;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ToSetAmountCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent=new ResponseContent();
        BetService betService= ServiceFactory.getInstance().getBetService();
        try {
            Bet bet=betService.getById(Integer.parseInt(request.getParameter("id")));
            HttpSession session=request.getSession();
            session.setAttribute("bet", bet);
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/make_bet_page4.jsp"));
        } catch (ServiceException e) {
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/error_page.jsp"));
        }
        return responseContent;
    }
}
