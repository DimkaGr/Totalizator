package by.gritsuk.dima.controller;

import by.gritsuk.dima.controller.command.Command;
import by.gritsuk.dima.controller.command.CommandProvider;
import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(/* Provide your code here**/)
public class AjaxController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Command command = CommandProvider.getInstance().takeCommand("CommandExample");
//        try {
//            ResponseContent responseContent = command.execute(request);
//        }catch (SQLException| ServiceException e){
//            throw new ServletException(e);
//        }
        // Provide your code here

    }
}
