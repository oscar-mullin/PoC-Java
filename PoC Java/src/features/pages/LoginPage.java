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
		return usernameField.isDisplayed();
	}
	 
	public void login(String username, String password){ 
	 	this.usernameField.clear(); 
	 	this.usernameField.sendKeys(username); 
	 	this.passwordField.clear(); 
	 	this.passwordField.sendKeys(password);
	 	try {
			new Thread().sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
