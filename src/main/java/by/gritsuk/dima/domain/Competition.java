package by.gritsuk.dima.domain;

import by.gritsuk.dima.dao.Identified;

import java.time.LocalDate;

public class Competition implements Identified<Long> {
    private long id;
    private LocalDate date;
    private String participant1;
    private String participant2;
    private long kind_of_sport_id;
    private String kindOfSport;
    private long competition_result_id;
    private String result;

    public Competition(){}

    @Override
    public void setId(Long id) {
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

    public void setKind_of_sport_id(long kind_of_sport_id) {
        this.kind_of_sport_id = kind_of_sport_id;
    }

    public void setCompetition_result_id(long competition_result_id) {
        this.competition_result_id = competition_result_id;
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

    public long getKind_of_sport_id() {
        return kind_of_sport_id;
    }

    public long getCompetition_result_id() {
        return competition_result_id;
    }
}
