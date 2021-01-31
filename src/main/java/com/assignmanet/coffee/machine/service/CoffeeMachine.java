package com.assignmanet.coffee.machine.service;

import com.assignmanet.coffee.machine.persistence.BeveragesEntity;
import com.assignmanet.coffee.machine.persistence.MachineRootEntity;
import com.assignmanet.coffee.machine.utility.MachineManager;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CoffeeMachine {

//    private ThreadPoolExecutor executor;
    private static CoffeeMachine coffeeMachine;
    public MachineRootEntity machineRootEntity;
    public MachineManager machineManager;


    public static CoffeeMachine getInstance(final String jsonInput) throws IOException {
        if (coffeeMachine == null) {
            synchronized (CoffeeMachine.class){
                if (coffeeMachine == null) {
                    coffeeMachine = new CoffeeMachine(jsonInput);
                }
            }
        }
        return coffeeMachine;
    }

    public CoffeeMachine(String jsonInput) throws IOException {
       Gson g = new Gson();
        this.machineRootEntity =g.fromJson(jsonInput,MachineRootEntity.class);
        int outlet = machineRootEntity.getMachine().getOutlets().getCount();
 //       executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(outlet);
    }

    public void start() {
        this.machineManager = MachineManager.getInstance();
        Map<String, Integer> ingredients = machineRootEntity.getMachine().getTotal_items_quantity();

        //on start load inventory with given items
        for (String key : ingredients.keySet()) {
            machineManager.addInventory(key, ingredients.get(key));
        }
        // processing each order
        HashMap<String, HashMap<String, Integer>> beverages;
        beverages = machineRootEntity.getMachine().getBeverages();
        for (String key : beverages.keySet()) {
            BeveragesEntity beverage = new BeveragesEntity(key, beverages.get(key));
            coffeeMachine.addBeverageRequest(beverage);
        }
    }

    public void stop(){

   //     executor.shutdown();;
       // machineManager.cleanMachine();

    }

    public void addBeverageRequest(BeveragesEntity beveragesEntity) {
        if(MachineManager.getInstance().checkAndPrepare(beveragesEntity)){
            System.out.println(beveragesEntity.getIngredientName() + " is prepared");
        }

        //BeverageMakerParallel beverageMakerParallel = new BeverageMakerParallel(beveragesEntity);
     //   executor.execute(beverageMakerParallel);
    }


}
