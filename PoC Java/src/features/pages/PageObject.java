package features.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
	protected WebDriver driver;
	
	public PageObject(WebDriver driver){ 
		this.driver = driver; 
		PageFactory.initElements(driver, this); 
	}
	
	public boolean elementIsDisplayed(WebElement element) {		
		return element.isDisplayed();
	}
	
	public void clickElement(WebElement element){		
		element.click();		
	}
	
	public void fillValue(WebElement element, String value){		
		element.clear(); 
		element.sendKeys(value);		
	}
}
