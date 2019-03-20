package by.gritsuk.dima.domain;

import by.gritsuk.dima.dao.Identified;

public class RegistrationKey implements Identified<Integer> {
    private String key;
    private Integer userId;

    public RegistrationKey(){}

    @Override
    public Integer getId() {
        return userId;
    }

    public String getKey() {
        return key;
    }

    @Override
    public void setId(Integer user_id) {
        this.userId =user_id;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
