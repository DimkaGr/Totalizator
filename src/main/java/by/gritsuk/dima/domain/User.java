package by.gritsuk.dima.domain;

import by.gritsuk.dima.dao.Identified;
import lombok.Data;


@Data
public abstract class User implements Identified<Long> {
    private long id;
    private String login;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private long role_id;
    private long client_account_id=0;

    public User(){ }

    public User(String login,String password,String email,String firstName,String lastName){
        this.login=login;
        this.password=password;
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    @Override
    public Long getId() {
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
    public void setId(Long id) {
        this.id = id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public void setClient_account_id(long client_account_id) {
        this.client_account_id = client_account_id;
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

    public long getRole_id() {
        return role_id;
    }

    public long getClient_account_id() {
        return client_account_id;
    }
}
