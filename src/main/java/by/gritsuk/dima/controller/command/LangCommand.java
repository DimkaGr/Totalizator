package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.dto.ResponseContent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

public class LangCommand implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        ResponseContent responseContent=new ResponseContent();
        String locale=request.getParameter("local");
//        Locale locale=new Locale(language);
        HttpSession session=request.getSession();
//        String locale=(String) session.getAttribute("id");
        session.setAttribute("locale",locale);
        responseContent.setRouter(new Router(Router.Type.FORWARD,"/index.jsp"));
        return responseContent;
    }
}
