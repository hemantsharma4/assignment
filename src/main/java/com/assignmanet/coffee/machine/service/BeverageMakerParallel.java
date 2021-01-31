package com.assignmanet.coffee.machine.service;

import com.assignmanet.coffee.machine.persistence.BeveragesEntity;
import com.assignmanet.coffee.machine.utility.MachineManager;

public class BeverageMakerParallel implements Runnable{

    private BeveragesEntity beveragesEntity;

    public BeverageMakerParallel(BeveragesEntity beveragesEntity) {
        this.beveragesEntity = beveragesEntity;
    }

    @Override
    public void run() {
        if(MachineManager.getInstance().checkAndPrepare(beveragesEntity)){
            System.out.println(beveragesEntity.getIngredientName() + " is prepared");
        }
    }
}
