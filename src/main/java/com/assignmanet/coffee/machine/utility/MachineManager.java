package com.assignmanet.coffee.machine.utility;

import com.assignmanet.coffee.machine.persistence.BeveragesEntity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MachineManager {
    public HashMap<String, Integer> inventory = new HashMap<>();

    public boolean checkAndFillInventory(BeveragesEntity beverage) {
        Map<String, Integer> requiredIngredientMap = beverage.getIngredientQuantity();
        boolean flag = true;

        Iterator<Map.Entry<String,Integer>> iterator = requiredIngredientMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Integer> entry  = iterator.next();
            int count= inventory.getOrDefault(entry.getKey(),0);
            if(count==0){
                System.out.println(beverage.getIngredientName()+" cannot be prepared because "+ entry.getKey() + " is not available");
                    flag= false;
            break;

            }else if(count<requiredIngredientMap.get(entry.getKey())){
                System.out.println(beverage.getIngredientName() + " cannot be prepared because " + entry.getKey() + " is not sufficient");
                flag= false;
                break;
            }
        }
        if (flag) {
            for (String ingredient : requiredIngredientMap.keySet()) {
                int existingInventory = inventory.getOrDefault(ingredient, 0);
                inventory.put(ingredient, existingInventory - requiredIngredientMap.get(ingredient));
            }
        }
        return flag;
    }
    public void addInventory(String ingredient, int quantity) {
        int existingInventory = inventory.getOrDefault(ingredient, 0);
        inventory.put(ingredient, existingInventory + quantity);
    }
}
