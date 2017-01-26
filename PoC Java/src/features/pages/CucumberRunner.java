package features.pages;

import org.junit.runner.*;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/features",		
		glue = "features.steps",
		dryRun = false	
		)
		
public class CucumberRunner {

}