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
//If possible, paths and stuff like that should be placed in a config file and refer them from there
			System.setProperty("webdriver.gecko.driver", ".\\libs\\geckodriver.exe");
        	initialized = true;
//Local vs Remote configuration is a good idea. The framework should read from config file to know where to run

        	//local Configuration
        	//driver = new FirefoxDriver();
        	
        	//Remote Configuration

//The browser to use should be a parameter and not hardcoded. Anyway for the PoC is good as is
        	DesiredCapabilities capability = DesiredCapabilities.firefox();
        	capability.setBrowserName("chrome");
//No need to specify the platform unless your node has this specific platform
        	capability.setPlatform(Platform.VISTA);
        	try {
//The URL of the grid should be in a config file as well
				driver = new RemoteWebDriver(new URL("http://192.168.121.38:5566/wd/hub"),capability);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

        	//Common Driver Configuration
//Implicit wait time should be in a config file
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
	}
		

	public static void goToUrl(String url){
		driver.navigate().to(url);
	}	
	
	public static void cleanUp(){
		driver.manage().deleteAllCookies();
	}
		
	public static void tearDown(){
//Please use quit instead of close since they have different behaviors
		driver.close();
	}
}
