package by.gritsuk.dima.controller.command;

import by.gritsuk.dima.dto.ResponseContent;

import javax.servlet.http.HttpServletRequest;

/**
 * Command
 */
public interface Command {

    /**
     * Execute command
     * @param request is used for extracting request parameters
     * @return response content
     */
    ResponseContent execute(HttpServletRequest request);
}
