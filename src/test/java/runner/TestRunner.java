package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resource/features",
                 glue = {"stepDefinations","hooks"},
                 publish = true,
                 plugin = {"pretty","html:target/cucumberReports/CucumberReports.html"}
                 
          
                 
                 )
                  
                 
public class TestRunner {

}
