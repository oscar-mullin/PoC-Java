package features.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

import org.testng.Assert;

import features.pages.*;

/*
 * 1/27/2017 - Walter
 *     - Updated assertions to testNG Asserts
 *     - Moved Driver Initializer to Runner Classes
 */
public class TestSteps {

	LoginPage loginPage = null;
	public Scenario scenario;
	
	@Before
	public void initializeDriver(Scenario scenario){
		loginPage = new LoginPage(DriverManager.getDriver());		
		this.scenario = scenario;
	}
	
	//Navigate to a URL is not what we would want to do from a functional perspective. We want to get Home or New Idea or x page	
   	@Given("^I access \"([^\"]*)\" site$")
	public void navigateUrl(String url) {
   		DriverManager.goToUrl(url);
   	}
	
	//This is correct. However, try to think what would happen if you want to test that it uses a  wrong password. Would this be enough?
  	@Then("^I login to the site using (.*) username and (.*) password credentials$")
	public void login(String username, String password) {  		
  		//This assert should not be here. The verification should be done at the Page Object  level
  		//Margot: moved assert to method               
  		Assert.assertTrue(loginPage.login(username, password));
		//What is the final assertion after calling login?
		//Margot: login method now returns a boolean to verify the login was successful 
   	}   
      
  	@When("^I click on the \"([^\"]*)\" link in \"([^\"]*)\" page$")
	public void clickLoginLink(String link, String page) {  		
  		switch (page) {
	    	case "Login":
	    	case "Forgot Username":
	    		loginPage.clickElement(link);        		
	    		break;	    	
	    	default:
	        	throw new IllegalArgumentException("'"+page+"' is not listed!");
		}  		      
   	}   
   	
  	@When("^I verify the \"([^\"]*)\" page is displayed$")
	public void verifyPage(String page) {  		     
  		switch (page) {
        	case "Forgot Username":
        		Assert.assertTrue(loginPage.elementIsDisplayed("Forgot Username Title"));        		
        		break;
        	case "Sign In":
        		Assert.assertTrue(loginPage.elementIsDisplayed("Sign In Title"));        		
        		break;
        	default:
            	throw new IllegalArgumentException("'"+page+"' is not listed!");
  		} 
   	}
   	
  	@When("^I fill in \"([^\"]*)\" field with \"([^\"]*)\" value on \"([^\"]*)\" page$")
	public void fillInFieldInPage(String field, String value, String page) {  		     
  		switch (page) {
        	case "Forgot Username":
        	case "Login":
        		loginPage.fillValue(field, value);
        		break;
        	default:
            	throw new IllegalArgumentException("'"+page+"' is not listed!");
  		} 
   	}     
   	
  	@When("^I click on the \"([^\"]*)\" button in \"([^\"]*)\" page$")
	public void clickButtonInPage(String button, String page) {  		     
  		switch (page) {
        	case "Forgot Username":
        	case "Login":
        		loginPage.clickElement(button);
        		break;
        	default:
            	throw new IllegalArgumentException("'"+page+"' is not listed!");
  		} 
   	}
   	
  	@When("^I verify \"([^\"]*)\" message is displayed on the \"([^\"]*)\" page$")
	public void verifyTextInPage(String message, String page) {  		     
  		switch (page) {
        	case "Forgot Username":
        	case "Login":
        		Assert.assertTrue(loginPage.messageIsDisplayed(page, message), "Text not found!");
        		break;        	
        	default:
            	throw new IllegalArgumentException("'"+page+"' is not listed!");
  		} 
   	}
   	
  	@When("^I make a Forgot Username request with \"([^\"]*)\" email$")
	public void forgotUsernameRequest(String email) {
  		loginPage.forgotUsernameRequest(email);        
   	}
   	
	@After
	public void closeDriver(){		
		DriverManager.cleanUp();
		//DriverManager.tearDown();
	}
}
