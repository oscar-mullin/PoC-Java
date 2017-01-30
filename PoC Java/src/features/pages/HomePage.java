package features.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends PageObject {
	  
	@FindBy(css=".wysiwyg>h1") 
	private WebElement editableWidgetTitle;
	
	public HomePage(WebDriver driver) { 
		super(driver); 
	}

}
