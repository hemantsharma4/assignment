import com.assignmanet.coffee.machine.service.CoffeeMachine;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.File;

import static org.junit.Assert.assertEquals;


public class CoffeeMachineTest {

    CoffeeMachine coffeeMachine;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
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

}