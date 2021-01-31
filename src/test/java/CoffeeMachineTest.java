import com.assignmanet.coffee.machine.service.CoffeeMachine;
import com.assignmanet.coffee.machine.utility.MachineManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;


import java.io.File;
import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;


public class CoffeeMachineTest {

    CoffeeMachine coffeeMachine;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        coffeeMachine.stop();
        resetSingleton(CoffeeMachine.class,"coffeeMachine");
        resetSingleton(MachineManager.class,"machineManager");
    }

    public static void resetSingleton(Class clazz, String fieldName) {
        Field instance;
        try {
            instance = clazz.getDeclaredField(fieldName);
            instance.setAccessible(true);
            instance.set(null, null);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Test
    public void test() throws Exception {
        final String filePath = "input.json";
        File file = new File(CoffeeMachine.class.getClassLoader().getResource(filePath).getFile());
        String jsonInput = FileUtils.readFileToString(file, "UTF-8");
        coffeeMachine = CoffeeMachine.getInstance(jsonInput);
        coffeeMachine.start();
        assertEquals(4,coffeeMachine.machineRootEntity.getMachine().getBeverages().size());
    }

    @Test
    public void test2() throws Exception {
        System.out.println("Test 2 started ");
        final String filePath = "input2.json";
        File file = new File(CoffeeMachine.class.getClassLoader().getResource(filePath).getFile());
        String jsonInput = FileUtils.readFileToString(file, "UTF-8");
        coffeeMachine = CoffeeMachine.getInstance(jsonInput);
        coffeeMachine.start();
        assertEquals(3,coffeeMachine.machineRootEntity.getMachine().getBeverages().size());
    }
    @Test
    public void test3() throws Exception {
        System.out.println("Test 3 started less inventory");
        final String filePath = "input3.json";
        File file = new File(CoffeeMachine.class.getClassLoader().getResource(filePath).getFile());
        String jsonInput = FileUtils.readFileToString(file, "UTF-8");
        coffeeMachine = CoffeeMachine.getInstance(jsonInput);
        coffeeMachine.start();
        assertEquals(2,coffeeMachine.machineRootEntity.getMachine().getBeverages().size());
    }
}