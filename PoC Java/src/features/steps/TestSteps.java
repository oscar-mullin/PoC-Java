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
	
   	@Given("^I navigate to (.*) url$")
	public void navigateUrl(String url) {
   		DriverManager.getDriver().navigate().to(url);
   	}
	
  	@Then("^I login to the site using (.*) username and (.*) password credentials$")
	public void login(String username, String password) {
  		LoginPage loginPage = new LoginPage(DriverManager.getDriver());
  		assertTrue(loginPage.isInitialized());
  		loginPage.login(username, password);
   	}   
   
	@After
	public void closeDriver(){
		System.out.println("AFTER!!!");
		DriverManager.cleanUp();
		//DriverManager.tearDown();
	}
}
