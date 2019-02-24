package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.UserService;
import by.gritsuk.dima.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Example of the command implementation
 */
public class CommandExample implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        // Provide your code here
        try {
            UserService userService = ServiceFactory.getInstance().getUserService();
        }catch (SQLException| ServiceException e){

        }
        // Provide your code here

        throw new UnsupportedOperationException();
    }
}
