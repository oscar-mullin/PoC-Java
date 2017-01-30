package runners;

import java.io.File;
import java.util.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.cucumber.listener.ExtentCucumberFormatter;

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
		dryRun = false,
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter"}		
		)
public class TestOneRunner extends AbstractTestNGCucumberTests {
	@Parameters("browser")
	@BeforeClass
	public void startDriver(String browser){
		DriverManager.initialize(browser);
						
		// Initiates the extent report and generates the output in the output/Run_<unique timestamp>/report.html file by default.
        ExtentCucumberFormatter.initiateExtentCucumberFormatter();         
        ExtentCucumberFormatter.loadConfig(new File("src/extent-config.xml")); 
        Map systemInfo = new HashMap();
        systemInfo.put("Cucumber version", "v1.2.5");
        systemInfo.put("Extent Cucumber Reporter version", "v1.1.1");
        ExtentCucumberFormatter.addSystemInfo(systemInfo);       
        //ExtentCucumberFormatter.initiateExtentCucumberFormatter("D:/Users/Pictures/Reports/Auutomation_report.html", NetworkMode.OFFLINE; new Locale("en-US"));
     
	}
}