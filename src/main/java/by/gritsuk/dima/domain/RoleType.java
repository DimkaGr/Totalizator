package by.gritsuk.dima.domain;

public enum RoleType {
    ADMIN(1,"admin"),
    USER(2,"user"),
    BOOKMAKER(3,"bookmaker");

    private int roleId;
    private String name;

    RoleType(int roleId,String name){
        this.roleId=roleId;
        this.name =name;
    }

    public String getName(){return name;}

    public int getId(){return roleId;}
}
