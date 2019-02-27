package by.gritsuk.dima.controller.servlet;

import by.gritsuk.dima.domain.Competition;
import by.gritsuk.dima.service.CompetitionService;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = "/comp_list")
public class CompetitionListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/WEB-INF/views/competitions_page.jsp").forward(req,resp);
        List<Competition> competitions=new ArrayList<>();
        CompetitionService competitionService= ServiceFactory.getInstance().getCompetitionService();
        try {
            competitions=competitionService.getAll();
        }catch(ServiceException e){
            throw new ServletException("Failed while getting competitions from database",e);
        }
        req.setAttribute("competitions",competitions);
        req.getRequestDispatcher("/WEB-INF/views/competitions_page.jsp").forward(req,resp);
    }


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }
}
