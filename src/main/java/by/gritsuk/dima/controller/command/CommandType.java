package by.gritsuk.dima.controller.command;

public enum CommandType {
    ADD_USER("add_user"),
    VIEW_USER_LIST("view_user_list"),
    FRONT_PAGE("front_page");

    private String value;

    CommandType(String value){
        this.value=value;
    }
    public String getValue(){
        return value;
    }
}
