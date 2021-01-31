package com.assignmanet.coffee.machine.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OutletEntity {

    @JsonProperty("count_n")
    private int count_n;

    public int getCount() {
        return count_n;
    }

    public void setCount(int count) {
        this.count_n = count;
    }
}
