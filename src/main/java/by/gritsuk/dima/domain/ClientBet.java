package by.gritsuk.dima.domain;

import by.gritsuk.dima.dao.Identified;

public class ClientBet implements Identified<Integer> {
    private int id;
    private double deposit;
    private String status;
    private double income;
    private int user_id;
    private int bet_id;

    public ClientBet(){}

    @Override
    public void setId(Integer id) {
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

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setBet_id(int bet_id) {
        this.bet_id = bet_id;
    }

    @Override
    public Integer getId(){
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

    public int getUser_id() {
        return user_id;
    }

    public int getBet_id() {
        return bet_id;
    }
}
