package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.dto.ResponseContent;
import by.gritsuk.dima.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Command
 */
public interface Command {

    /**
     * Execute command
     * @param request is used for extracting request parameters
     * @return response content
     */
    ResponseContent execute(HttpServletRequest request)throws SQLException, ServiceException;
}
