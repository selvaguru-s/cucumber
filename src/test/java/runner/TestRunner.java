package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "D:\\Java projects\\cucumber\\src\\test\\resources\\res\\Loginpage.feature",
    glue = "stepdefinition",
    
    		 plugin = {
    			        "pretty",
    			        "html:target/cucumber-report.html",
    			        "json:target/cucumber-report.json",
    			        "junit:target/cucumber-report.xml"
    			    }
   
)
public class TestRunner {

}