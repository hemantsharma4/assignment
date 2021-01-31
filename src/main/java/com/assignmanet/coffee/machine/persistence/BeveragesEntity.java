package com.assignmanet.coffee.machine.persistence;


import java.util.Map;


public class BeveragesEntity {
    private String ingredientName;
    private Map<String, Integer> ingredientQuantity;

    public BeveragesEntity(String ingredientName, Map<String, Integer> ingredientQuantity) {
        this.ingredientName = ingredientName;
        this.ingredientQuantity = ingredientQuantity;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Map<String, Integer> getIngredientQuantity() {
        return ingredientQuantity;
    }

    public void setIngredientQuantity(Map<String, Integer> ingredientQuantity) {
        this.ingredientQuantity = ingredientQuantity;
    }
}
