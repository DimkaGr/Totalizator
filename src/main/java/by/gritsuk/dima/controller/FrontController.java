package by.gritsuk.dima.controller;

import by.gritsuk.dima.controller.command.Command;
import by.gritsuk.dima.controller.command.CommandProvider;
import by.gritsuk.dima.controller.command.CommandType;
import by.gritsuk.dima.controller.command.Router;
import by.gritsuk.dima.dto.ResponseContent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/bets")
public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = CommandProvider.getInstance().takeCommand(request.getParameter("command"));
            ResponseContent responseContent = command.execute(request);
            if(responseContent.getRouter().getType()== Router.Type.REDIRECT){
                response.sendRedirect(responseContent.getRouter().getRoute());
            }else{
                request.getRequestDispatcher(responseContent.getRouter().getRoute()).forward(request,response);
            }
    }
}