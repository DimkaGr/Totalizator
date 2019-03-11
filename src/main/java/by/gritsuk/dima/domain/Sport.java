package by.gritsuk.dima.domain;

import by.gritsuk.dima.dao.Identified;

public class Sport implements Identified<Integer> {
    private int id;
    private String name;

    public Sport(){}

    @Override
    public Integer getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    @Override
    public void setId(Integer id) {
        this.id=id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
