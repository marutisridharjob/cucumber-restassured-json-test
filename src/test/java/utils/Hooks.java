package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public static void start() {
        UtilsMethod utilsMethod = new UtilsMethod();
        utilsMethod.resetAllGlobal();
    }

    @After
    public static void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            LoggingUtil.logInfo("Scenario Failed => " + scenario.getName());
        } else {
            LoggingUtil.logInfo("Scenario Success => " + scenario.getName());
        }
    }
}
