package features.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/*
 * 1/27/2017 - Walter
 *      - Cleaning code in order to use Only Selenium Grid Locally or Remotely
 *      TODO: Add support for config File 
 */
public class DriverManager {
	
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	
	public static WebDriver getDriver() {		
		return driver.get();
	}

	public static void initialize(String browser){	
		RemoteWebDriver remote_driver = null; //used with thread
	
		//If possible, paths and stuff like that should be placed in a config file and refer them from there
		System.setProperty("webdriver.gecko.driver", ".\\libs\\geckodriver.exe");
    	
    	//Remote Configuration
    	DesiredCapabilities capability = null;
    	switch(browser){
        case "chrome":
        	capability = DesiredCapabilities.chrome();
        	capability.setBrowserName("chrome");
        	break;
        case "firefox":
        	capability = DesiredCapabilities.firefox();
        	capability.setBrowserName("firefox");
        	break;
        case "ie":
        	capability = DesiredCapabilities.internetExplorer();
        	capability.setBrowserName("ie");
        	break;
        }

    	capability.setPlatform(Platform.ANY);
    	try {
			//The URL of the grid should be in a config file as well
    		remote_driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		//Implicit wait time should be in a config file
    	remote_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	setWebDriver(remote_driver);    	
	}		

	public static void setWebDriver(RemoteWebDriver remote_driver) {
        driver.set(remote_driver);
    }

	public static void goToUrl(String url){		
		getDriver().navigate().to(url);
	}	
	
	public static void cleanUp(){	
		getDriver().manage().deleteAllCookies();
	}
		
	public static void tearDown(){		
		getDriver().quit();			        
	}
}
