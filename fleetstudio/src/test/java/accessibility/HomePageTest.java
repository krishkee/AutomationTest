package accessibility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import browser.LaunchBrowser;
import pages.HomePage;
import pages.Homepage;

public class HomePageTest {
	
	WebDriver d;
	
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeSuite
	public void reportconfig()
	{
		reports = new ExtentReports(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\Fleetstudio_Automation.html");
		test = reports.startTest("Fleetstudio Result");
	}
	
	@BeforeTest
	public void setUp() throws IOException
	{
		test.log(LogStatus.INFO, "Chrome");
		LaunchBrowser driver = new LaunchBrowser();
		
		 d = driver.WebBrowser();
		
	}

	@Test
	public void HomePage() throws IOException
	{
		test.log(LogStatus.PASS, "TestCase_Pass");
		Homepage acc = new Homepage(d);
		acc.clickSubscribe();
	}
	
	
	
	@AfterMethod
	public void TakesScreenshot(ITestResult res) throws IOException
	{
		test.log(LogStatus.PASS, "Test Case"+res.getName()+"Passed");
		
		File sc =((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		
		String sc_path =System.getProperty("user.dir")+"\\src\\test\\resources\\screenshot\\"+res.getName()+"screenshot.png";
		
		FileUtils.copyFile(sc, new File(sc_path));
	}
	
	@AfterSuite
	public void endReport()
	{
		reports.endTest(test);
		reports.flush();
	}
	
	@AfterSuite
	public void tearDown()
	{
		test.log(LogStatus.INFO,"Test Execution completed");
		d.close();
	}
}
