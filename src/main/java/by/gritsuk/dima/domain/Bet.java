package by.gritsuk.dima.domain;

import by.gritsuk.dima.dao.Identified;

public class Bet implements Identified<Long> {
    private long id;
    private double minValue;
    private long competition_id;
    private CompetitionEvent event;

    public Bet(){}

    public void setId(long id) {
        this.id = id;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public void setCompetition_id(long competition_id) {
        this.competition_id = competition_id;
    }

    public void setEvent(CompetitionEvent event) {
        this.event = event;
    }

    @Override
    public Long getId(){
        return id;
    }

    public double getMinValue() {
        return minValue;
    }

    public long getCompetition_id() {
        return competition_id;
    }

    public CompetitionEvent getEvent() {
        return event;
    }

    public static class CompetitionEvent implements Identified<Long>{
        public long id;
        private String event;
        private double factor;

        public CompetitionEvent(){}

        public void setId(long id) {
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
        public Long getId(){
            return id;
        }
    }
}
