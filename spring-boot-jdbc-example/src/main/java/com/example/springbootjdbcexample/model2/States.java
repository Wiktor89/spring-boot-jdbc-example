package com.example.springbootjdbcexample.model2;


public enum States {

    FREE(0),
    TAKEN(1),
    WAIT(2);

    private Integer id;

    States(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    public static States fromId(Integer id) {
        for (States at : States.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}