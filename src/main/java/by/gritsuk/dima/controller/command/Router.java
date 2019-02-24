package by.gritsuk.dima.controller.command;

/**
 * Provide route to jsp page
 */
public class Router {
    private String route;
    private Type type = Type.FORWARD;

    public Router(Type type,String route){
        this.type=type;
        this.route=route;
    }

    public enum Type {
        FORWARD, REDIRECT
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
