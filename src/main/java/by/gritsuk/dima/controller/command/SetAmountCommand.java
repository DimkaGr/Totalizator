package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.domain.Bet;
import by.gritsuk.dima.domain.Client;
import by.gritsuk.dima.dto.ResponseContent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SetAmountCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent=new ResponseContent();
        double userRate=Double.parseDouble(request.getParameter("number"));
        HttpSession session=request.getSession();
        double factor=((Bet)session.getAttribute("bet")).getEvent().getFactor();
        Client user=(Client)session.getAttribute("user");
        if(userRate<0.2){
            request.setAttribute("minAmountError","true");
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/make_bet_page4.jsp"));
        }else if(user.getCash()<userRate){
            request.setAttribute("cashError","true");
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/make_bet_page4.jsp"));
        }else{
            responseContent.setRouter(new Router(Router.Type.FORWARD,"/WEB-INF/views/confirm_bet_page.jsp"));
        }
        request.setAttribute("sportName",session.getAttribute("sportName"));
        request.setAttribute("competitionName",session.getAttribute("competitionName"));
        request.setAttribute("value",userRate);
        request.setAttribute("bet",session.getAttribute("bet"));
        request.setAttribute("expected",userRate*factor);

        session.setAttribute("value",userRate);
        session.setAttribute("expected",userRate*factor);

        return responseContent;
    }
}
