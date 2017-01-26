package features.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {
	protected static WebDriver driver;
	private static boolean initialized = false;
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void initialize(){
		if (!initialized){
			System.setProperty("webdriver.gecko.driver", ".\\libs\\geckodriver.exe");
        	initialized = true;
        	//local Configuration
        	//driver = new FirefoxDriver();
        	
        	//Remote Configuration
        	DesiredCapabilities capability = DesiredCapabilities.firefox();
        	capability.setBrowserName("chrome");
        	capability.setPlatform(Platform.VISTA);
        	try {
				driver = new RemoteWebDriver(new URL("http://192.168.121.38:5566/wd/hub"),capability);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

        	//Common Driver Configuration
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
	}
		
	public static void cleanUp(){
		driver.manage().deleteAllCookies();
	}
		
	public static void tearDown(){
		driver.close();
	}
}
