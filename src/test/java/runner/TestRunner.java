package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = "src/test/resources/features",
        glue ={"com.web.stepdefinitions"},
        plugin = {"pretty" , "html:target/cucumber-reports.html", "json:target/cucumber.json"},
        monochrome = true,
        publish = true)
// extend AbstractTestNGCucumberTests class to parallel test execution
public class TestRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios(){
                return super.scenarios();

        }




}
