package com.assignmanet.coffee.machine.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class MachineEntity {

    @JsonProperty("outlets")
    private OutletEntity outlets;

    @JsonProperty("total_items_quantity")
    private HashMap<String, Integer> total_items_quantity;

    @JsonProperty("beverages")
    private HashMap<String, HashMap<String, Integer>> beverages;

    public OutletEntity getOutlets() {
        return outlets;
    }

    public void setOutlets(OutletEntity outlets) {
        this.outlets = outlets;
    }

    public HashMap<String, Integer> getTotal_items_quantity() {
        return total_items_quantity;
    }

    public void setTotal_items_quantity(HashMap<String, Integer> total_items_quantity) {
        this.total_items_quantity = total_items_quantity;
    }

    public HashMap<String, HashMap<String, Integer>> getBeverages() {
        return beverages;
    }

    public void setBeverages(HashMap<String, HashMap<String, Integer>> beverages) {
        this.beverages = beverages;
    }
}
