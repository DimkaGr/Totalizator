package by.gritsuk.dima.domain;

import by.gritsuk.dima.dao.Identified;

public class ClientBet implements Identified<Integer> {
    private int id;
    private double deposit;
    private String status;
    private double income;
    private int userId;
    private int betId;

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

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBetId(int betId) {
        this.betId = betId;
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

    public int getUserId() {
        return userId;
    }

    public int getBetId() {
        return betId;
    }
}
