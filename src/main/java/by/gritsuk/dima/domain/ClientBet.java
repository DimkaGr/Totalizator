package by.gritsuk.dima.domain;

import by.gritsuk.dima.dao.Identified;

public class ClientBet implements Identified<Long> {
    private long id;
    private double deposit;
    private String status;
    private double income;
    private long user_id;
    private long bet_id;

    public ClientBet(){}

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setBet_id(long bet_id) {
        this.bet_id = bet_id;
    }

    @Override
    public Long getId(){
        return id;
    }

    public double getDeposit() {
        return deposit;
    }

    public String getStatus() {
        return status;
    }

    public double getIncome() {
        return income;
    }

    public long getUser_id() {
        return user_id;
    }

    public long getBet_id() {
        return bet_id;
    }
}
