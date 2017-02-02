package runners;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.cucumber.listener.ExtentCucumberFormatter;
import com.relevantcodes.extentreports.NetworkMode;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import features.pages.DriverManager;

/*
 * 1/27/2017 - Walter
 *     - Updated File Name
 *     - Included initialization of Driver on Runner because the Variable is being sent from testng.xml
 */
@CucumberOptions(
		features = "src/features/TestTwo.feature",		
		glue = "features.steps",
		dryRun = false
		,plugin = {"com.cucumber.listener.ExtentCucumberFormatter"}
		)
public class TestTwoRunner extends AbstractTestNGCucumberTests {

	@Parameters("browser")
	@BeforeClass
	public void startDriver(String browser){
		DriverManager.initialize(browser);
				         
		//Initiates the extent report and generates the output in the output/Run_<unique timestamp>/report.html file by default.
        //ExtentCucumberFormatter.initiateExtentCucumberFormatter();         
        ExtentCucumberFormatter.initiateExtentCucumberFormatter(new File("./output/Report_"+ System.currentTimeMillis() +"_2/report.html"), NetworkMode.OFFLINE);		        
		ExtentCucumberFormatter.loadConfig(new File("src/extent-config.xml")); 
		Map systemInfo = new HashMap();
		systemInfo.put("Cucumber version", "v1.2.5");
		systemInfo.put("Extent Cucumber Reporter version", "v1.1.1");
		ExtentCucumberFormatter.addSystemInfo(systemInfo);			     
	}
	
	@AfterClass
	public void closeDriver(){
		DriverManager.tearDown();
	}
}