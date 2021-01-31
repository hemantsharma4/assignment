package com.assignmanet.coffee.machine.service;

import com.assignmanet.coffee.machine.persistence.BeveragesEntity;
import com.assignmanet.coffee.machine.persistence.MachineRootEntity;
import com.assignmanet.coffee.machine.utility.MachineManager;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CoffeeMachine {

    private static CoffeeMachine coffeeMachine;
    public MachineRootEntity machineRootEntity;
    public MachineManager machineManager;

    public static CoffeeMachine getInstance(final String jsonInput) throws IOException {
        if (coffeeMachine == null) {
            coffeeMachine = new CoffeeMachine(jsonInput);
        }
        return coffeeMachine;
    }

    public CoffeeMachine(String jsonInput) throws IOException {
       Gson g = new Gson();
        this.machineRootEntity =g.fromJson(jsonInput,MachineRootEntity.class);
    }

    public void start() {
        this.machineManager = new MachineManager();

        Map<String, Integer> ingredients = machineRootEntity.getMachine().getTotal_items_quantity();

        for (String key : ingredients.keySet()) {
            machineManager.addInventory(key, ingredients.get(key));
        }

        HashMap<String, HashMap<String, Integer>> beverages = machineRootEntity.getMachine().getBeverages();
        for (String key : beverages.keySet()) {
            BeveragesEntity beverage = new BeveragesEntity(key, beverages.get(key));
            coffeeMachine.addBeverageRequest(beverage);
        }
    }

    public void addBeverageRequest(BeveragesEntity beverage) {
        if (machineManager.checkAndFillInventory(beverage)) {
            System.out.println(beverage.getIngredientName() + " is prepared");
        }
    }


}
