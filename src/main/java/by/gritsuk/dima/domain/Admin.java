package by.gritsuk.dima.domain;

public class Admin extends User{
    public Admin(){}

    public Admin(String login,String password,String email,String firstName,String lastName){
        super(login,password,email,firstName,lastName);
    }
}
