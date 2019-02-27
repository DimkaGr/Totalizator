package by.gritsuk.dima.domain;

import by.gritsuk.dima.dao.Identified;

public class RegistrationKey implements Identified<Integer> {
    private String key;
    private Integer user_id;

    public RegistrationKey(){}

    @Override
    public Integer getId() {
        return user_id;
    }

    public String getKey() {
        return key;
    }

    @Override
    public void setId(Integer user_id) {
        this.user_id=user_id;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
