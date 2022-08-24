package stepdefinitions;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class Hooks {
    static int i=0;
    List<String> messages = Arrays.asList("Hello1", "World!2", "How3", "Are4", "You5",
            "World!6", "How7", "Are8", "World9!", "How10", "Are11", "World!12", "How13");

    @Before
    public void setUp() {
        System.out.println("\"hooks\" = " + "hooks");
    }

    /*
       public  void screenShot(Scenario scenario){

       final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
       if (scenario.equals(true)) {
           scenario.attach(screenshot, "image/png","screenshots");
       }*/
    @AfterStep()
    public void afterScenario(Scenario scenario) {

        if (scenario.isFailed()) {
            // More code goes here.
        } else {
            System.out.println("\"hooks\" = " + "hooks else");



            //------------------------- Attaching Screen shot in the Report -------------------------
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", messages.get(i));
i++;
            System.out.println("i = " + i);

        }

        //ExtentManager.getReporter().flush();
    }

}

//   Driver.closeDriver();




