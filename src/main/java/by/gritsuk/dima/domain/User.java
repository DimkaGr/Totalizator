package by.gritsuk.dima.domain;

import by.gritsuk.dima.dao.Identified;
import lombok.Data;


@Data
public abstract class User implements Identified<Integer> {
    private int id;
    private String login;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private int roleId =2;
    private int clientAccountId;

    public User(){ }

    public User(String login,String password,String email,String firstName,String lastName){
        this.login=login;
        this.password=password;
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setClientAccountId(int clientAccountId) {
        this.clientAccountId = clientAccountId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getRoleId() {
        return roleId;
    }

    public int getClientAccountId() {
        return clientAccountId;
    }
}
