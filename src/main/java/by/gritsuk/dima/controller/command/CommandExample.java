package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * Example of the command implementation
 */
public class CommandExample implements Command {
    @Override
    public ResponseContent execute(HttpServletRequest request) {
        // Provide your code here

        UserService userService = ServiceFactory.getInstance().getUserService();

        // Provide your code here

        throw new UnsupportedOperationException();
    }
}
