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
		Assert.assertTrue(elementIsDisplayed(usernameField));		
		//We could have use fillInCredentials and clickSubmit Methods to avoid repetition of code
		//Margot: changed to use generic methods instead
		fillValue(this.usernameField, username);
		fillValue(this.passwordField, password);	 	
	 	clickElement(this.submitButton);	 	
	 	return driver.findElement(By.cssSelector(".wysiwyg>h1")).isDisplayed();
	 } 

	public WebElement getElement(String element){ 
		switch (element) {
			case "Username": 				
				return usernameField;				
			case "Password": 				
			 	return passwordField;				
 			case "Forgot Username Email":
 				return usernameField; 			
	 		case "Forgot Username Title":
	 			return forgotUsernameTitle;     			
	 		case "Sign In Title":
	 			return signInTitle;
	 		case "Forgot your username?":
				return forgotUsernameLink;				
			case "Return to sign in":
				return returnSignInLink;
			case "Submit":
				return submitButton;				
			case "Cancel":
				return cancelButton;								
	 		default:
	     		throw new IllegalArgumentException("'"+element+"' is not listed!");
		} 
	}


//	public void fillValue(String field, String value){ 
//		switch (field) {
//			case "Username": 				
// 				this.usernameField.clear(); 
// 			 	this.usernameField.sendKeys(value);
// 				break;
//			case "Password": 				
// 			 	this.passwordField.clear(); 
// 			 	this.passwordField.sendKeys(value);
// 				break;
//	 		case "Forgot Username Email":
//	 			this.usernameField.sendKeys(value);
//	 			break;
//	 		default:
//	     		throw new IllegalArgumentException("'"+field+"' is not listed!");
//		}  
//	} 
			 
//	public void clickButton(String button){ 
//		switch (button) {
//			case "Submit":
//				this.submitButton.click();
//				break;
//			case "Cancel":
//				this.cancelButton.click();
//				break;
//			default:
//	  			throw new IllegalArgumentException("'"+button+"' is not listed!");
//			}   
//	 }
	 
//	public void clickLink(String link){		 
//		switch (link) {			
//			case "Forgot your username?":
//				this.forgotUsernameLink.click();
//				break;
//			case "Return to sign in":
//				this.returnSignInLink.click();
//				break;
//			default:
//	  			throw new IllegalArgumentException("'"+link+"' is not listed!");
//		} 
//	}
	 	 
//	public boolean elementDisplayed(String element){ 
//		switch (element) {
//	 		case "Forgot Username Title":
//	 			return forgotUsernameTitle.isDisplayed();     			
//	 		case "Sign In Title":
//	 			return signInTitle.isDisplayed();
//	 		default:
//	     		throw new IllegalArgumentException("'"+element+"' is not listed!");
//		} 
//	 }	
	 
	public boolean messageIsDisplayed(String message){ 
		String containerText = this.forgotUsernameSuccessContainer.getText();
		return containerText.contains(message);
	}
	
}
