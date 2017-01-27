package runners;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import features.pages.DriverManager;

/*
 * 1/27/2017 - Walter
 *     - Updated File Name
 *     - Included initialization of Driver on Runner because the Variable is being sent from testng.xml
 */
@CucumberOptions(
		features = "src/features/TestOne.feature",		
		glue = "features.steps",
		dryRun = false
		)
public class TestOneRunner extends AbstractTestNGCucumberTests {
	@Parameters("browser")
	@BeforeClass
	public void startDriver(String browser){
		DriverManager.initialize(browser);
	}
}