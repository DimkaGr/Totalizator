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
    public ResponseContent execute(HttpServletRequest request) throws SQLException, ServiceException {
        // Provide your code here

        UserService userService = ServiceFactory.getInstance().getUserService();

        // Provide your code here

        throw new UnsupportedOperationException();
    }
}
