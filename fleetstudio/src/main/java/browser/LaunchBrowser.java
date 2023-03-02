package browser;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.ConfigFileReader;

public class LaunchBrowser {
	
	WebDriver driver;
	
	public WebDriver WebBrowser() throws IOException
	{
		if(ConfigFileReader.readconfig("browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(ConfigFileReader.readconfig("browser").equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.get(ConfigFileReader.readconfig("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
}
