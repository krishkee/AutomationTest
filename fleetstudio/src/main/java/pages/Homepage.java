package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.ReadObjectRepo;

public class Homepage {
	
	WebDriver driver;
	
	public Homepage(WebDriver d)
	{
		this.driver=d;
	}
	
	public void clickSubscribe() throws IOException
	{
		driver.findElement(By.id(ReadObjectRepo.getLocators("sub_id"))).click();
		driver.findElement(By.xpath(ReadObjectRepo.getLocators("sub_xpath"))).click();
		
		String text =driver.findElement(By.xpath(ReadObjectRepo.getLocators("text_xpath"))).getText();
		
		System.out.println(text);
	}

}
