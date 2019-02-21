package by.gritsuk.dima.domain;

import by.gritsuk.dima.dao.Identified;

public class Bet implements Identified<Integer> {
    private int id;
    private double minValue;
    private int competition_id;
    private CompetitionEvent event;

    public Bet(){}

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public void setCompetition_id(int competition_id) {
        this.competition_id = competition_id;
    }

    public void setEvent(CompetitionEvent event) {
        this.event = event;
    }

    @Override
    public Integer getId(){
        return id;
    }

    public double getMinValue() {
        return minValue;
    }

    public int getCompetition_id() {
        return competition_id;
    }

    public CompetitionEvent getEvent() {
        return event;
    }

    public static class CompetitionEvent implements Identified<Integer>{
        private int id;
        private String event;
        private double factor;

        public CompetitionEvent(){}

        @Override
        public void setId(Integer id) {
            this.id = id;
        }

        public void setEvent(String event) {
            this.event = event;
        }

        public void setFactor(double factor) {
            this.factor = factor;
        }

        public String getEvent() {
            return event;
        }

        public double getFactor() {
            return factor;
        }

        @Override
        public Integer getId(){
            return id;
        }
    }
}
