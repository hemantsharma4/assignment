import java.io.File;
import java.io.IOException;

import com.assignmanet.coffee.machine.service.CoffeeMachine;
import org.apache.commons.io.FileUtils;
public class Application {
    public static void main(String[] args) throws IOException {
        File file = new File(CoffeeMachine.class.getClassLoader().getResource(args[0]).getFile());
        String jsonInput = FileUtils.readFileToString(file, "UTF-8");
        CoffeeMachine coffeeMachine = CoffeeMachine.getInstance(jsonInput);
        coffeeMachine.start();
    }
}
