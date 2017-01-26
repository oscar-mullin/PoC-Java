package features.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import static org.junit.Assert.*;

import features.pages.*;

public class TestSteps {
	
	@Before
	public void initializeDriver(){
		DriverManager.initialize();
	}
	
//Navigate to a URL is not what we would want to do from a functional perspective. We want to get Home or New Idea or x page
//DriverManager.getDriver().navigate().to() should be part of DriverManager and not in the test
   	@Given("^I navigate to (.*) url$")
	public void navigateUrl(String url) {
   		DriverManager.getDriver().navigate().to(url);
   	}
	
//This is correct. However, try to think what would happen if you want to test that it uses a  wrong password. Would this be enough?
  	@Then("^I login to the site using (.*) username and (.*) password credentials$")
	public void login(String username, String password) {
  		LoginPage loginPage = new LoginPage(DriverManager.getDriver());
  		//This assert should not be here. The verification should be done at the Page Object  level
                assertTrue(loginPage.isInitialized());
  		loginPage.login(username, password);
		//What is the final assertion after calling login?
   	}   
   
	@After
	public void closeDriver(){
		System.out.println("AFTER!!!");
		DriverManager.cleanUp();
		//DriverManager.tearDown();
	}
}
