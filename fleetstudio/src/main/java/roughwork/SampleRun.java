package roughwork;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import browser.LaunchBrowser;
import pages.Homepage;

public class SampleRun {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		LaunchBrowser driver = new LaunchBrowser();
		
		WebDriver d = driver.WebBrowser();
		
		Homepage hp = new Homepage(d);
		hp.clickSubscribe();

	}

}
