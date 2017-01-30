package features.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By; 
import org.testng.Assert;

/*
 * 1/27/2017 - Walter
 *      - Updated assertions to testNG Asserts
 */

public class LoginPage extends PageObject {

	@FindBy(id="username")
	private WebElement usernameField;
	
	@FindBy(css="input[type=password]") 
	private WebElement passwordField; 
		
	@FindBy(css="button[type=submit]") 
	private WebElement submitButton; 
	 
	@FindBy(xpath=".//a[@href='#/login/forgot/username']") 
	private WebElement forgotUsernameLink;
	
	@FindBy(xpath=".//h2[text()='Forgot Username']") 
	private WebElement forgotUsernameTitle;
	
	@FindBy(xpath=".//h2[text()='Sign In']") 
	private WebElement signInTitle;        
			
	@FindBy(xpath=".//button[text()='CANCEL']") 
	private WebElement cancelButton;
	
	@FindBy(xpath=".//a[@ui-sref='app.login.signin']") 
	private WebElement returnSignInLink;	
	
	@FindBy(xpath=".//div[contains(@class,'request-sent-container')]") 
	private WebElement forgotUsernameSuccessContainer;	
		
	@FindBy(css=".alert-danger") 
	private WebElement erroMessageContainer;			
	
	public LoginPage(WebDriver driver) { 
		super(driver); 
	} 
	 
//Margot: removed method
//	public boolean isInitialized() {	
//		//This should not be here. Find a way to use the parent constructor so it is reusable
//		return usernameField.isDisplayed();
//	}
	 
	//In the future this method should return another PageObject. The Home Page or the Error Page for example
	public boolean login(String username, String password){	
		Assert.assertTrue(usernameField.isDisplayed());		
		fillValue("Username", username);
		fillValue("Password", password);	 	
	 	clickElement("Submit");	 	
	 	return driver.findElement(By.cssSelector(".wysiwyg>h1")).isDisplayed();
	 } 

	public void fillValue(String field, String value){ 
		switch (field) {
			case "Username": 				
 				this.usernameField.clear(); 
 			 	this.usernameField.sendKeys(value);
 				break;
			case "Password": 				
 			 	this.passwordField.clear(); 
 			 	this.passwordField.sendKeys(value);
 				break;
	 		case "Forgot Username Email":
	 			this.usernameField.sendKeys(value);
	 			break;
	 		default:
	     		throw new IllegalArgumentException("'"+field+"' is not listed!");
		}  
	} 
			 
	public void clickElement(String element){ 
		switch (element) {
			case "Submit":
				this.submitButton.click();
				break;
			case "Cancel":
				this.cancelButton.click();
				break;
			case "Forgot your username?":
				this.forgotUsernameLink.click();
				break;
			case "Return to sign in":
				this.returnSignInLink.click();
				break;
			default:
	  			throw new IllegalArgumentException("'"+element+"' is not listed!");
			}   
	 }	 
	 	 
	public boolean elementIsDisplayed(String element){ 
		switch (element) {
	 		case "Forgot Username Title":
	 			return this.forgotUsernameTitle.isDisplayed();     			
	 		case "Sign In Title":
	 			return this.signInTitle.isDisplayed();
	 		default:
	     		throw new IllegalArgumentException("'"+element+"' is not listed!");
		} 
	 }	
	 
	public boolean messageIsDisplayed(String section, String message){
		String containerText = "";	
 		switch (section) {
	    	case "Forgot Username":
	    		containerText = this.forgotUsernameSuccessContainer.getText();
	    		return containerText.contains(message);    		        	
	    	case "Login":
	    		containerText = this.erroMessageContainer.getText();
	    		return containerText.contains(message);
	    	default:
	        	throw new IllegalArgumentException("'"+section+"' is not listed!");
		} 
	}

	public void forgotUsernameRequest(String email) {
		this.forgotUsernameLink.click();
		this.usernameField.sendKeys(email);
		this.submitButton.click();		 
	}
	
}
