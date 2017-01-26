package features.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

	@FindBy(id="username")
	private WebElement usernameField;
	
	@FindBy(css="input[type=password]") 
	private WebElement passwordField; 
		
	@FindBy(css="button[type=submit]") 
	private WebElement submitButton; 
	 
	public LoginPage(WebDriver driver) { 
		super(driver); 
	} 
	 
	public boolean isInitialized() {	
//This should not be here. Find a way to use the parent constructor so it is
//reusable
		return usernameField.isDisplayed();
	}
	 
	public void login(String username, String password){ 
//We could have use fillInCredentials and clickSubmit Methods to avoid repetition of code
	 	this.usernameField.clear(); 
	 	this.usernameField.sendKeys(username); 
	 	this.passwordField.clear(); 
	 	this.passwordField.sendKeys(password);
//Try using WebDriverWaits instead of hardcoded waits. This will wait always
	 	try {
			new Thread().sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//If we use 'this' in other places, let's try to use it consistently
	 	submitButton.click(); 
	 } 
	 
	 public void fillInCredentials(String username, String password){ 
	 	this.usernameField.clear(); 
	 	this.usernameField.sendKeys(username); 
	 	this.passwordField.clear(); 
	 	this.passwordField.sendKeys(password); 
	 } 
	 
	 public void clickSubmitButton(){ 
		submitButton.click(); 
	 }	
	
}
