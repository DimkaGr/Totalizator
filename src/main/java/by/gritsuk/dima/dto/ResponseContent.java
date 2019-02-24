package by.gritsuk.dima.dto;

import by.gritsuk.dima.controller.command.Router;

/**
 * Provide response content to View layer
 */
public class ResponseContent {
    private Router router;

    public void setRouter(Router router){
        this.router=router;
    }

    public Router getRouter(){
        return router;
    }
}
