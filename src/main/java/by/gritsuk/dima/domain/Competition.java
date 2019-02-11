package by.gritsuk.dima.domain;

import by.gritsuk.dima.dao.Identified;

import java.time.LocalDate;

public class Competition implements Identified<Long> {
    private long id;
    private LocalDate date;
    private String participant1;
    private String participant2;
    private String kindOfSport;
    private String result;

    public Competition(){}

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setParticipant1(String participant1) {
        this.participant1 = participant1;
    }

    public void setParticipant2(String participant2) {
        this.participant2 = participant2;
    }

    public void setKindOfSport(String kindOfSport) {
        this.kindOfSport = kindOfSport;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public Long getId(){
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getParticipant1() {
        return participant1;
    }

    public String getParticipant2() {
        return participant2;
    }

    public String getKindOfSport() {
        return kindOfSport;
    }

    public String getResult() {
        return result;
    }
}
