package by.gritsuk.dima.domain;

public class Client extends User{
    private String status;
    private double cash;

    public Client(){}

    public Client(String login,String password,String email,String firstName,String lastName){
        super(login,password,email,firstName,lastName);
    }

    public Client(String login,String password,String email,String firstName,String lastName,double cash){
        super(login,password,email,firstName,lastName);
        this.cash=cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getCash() {
        return cash;
    }

    public String getStatus() {
        return status;
    }
}
