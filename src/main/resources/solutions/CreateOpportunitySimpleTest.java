package com.nttdata.scs.selenium;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateOpportunitySimpleTest {

	private WebDriver driver;
	private SimpleDateFormat sdf;

	@BeforeEach
	public void main() throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver", "c:\\tools\\chromedriver.exe");

		Map<String, Object> prefs = new HashMap<String, Object>();

		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		
		sdf = new SimpleDateFormat("YY-MM-dd HH:mm");
	}

	@Test
	public void createOpportunity() throws InterruptedException {
		driver.get("https://trailhead-iaam-dev-ed.my.salesforce.com");
		
		// login
		driver.findElement(By.id("username")).sendKeys("lazy.beaver@nttdata.com.iaam");
		driver.findElement(By.id("password")).sendKeys("REPLACE_THIS");
		driver.findElement(By.id("Login")).click();
		
		// use Global Search
		driver.findElement(By.xpath(".//input[@type='text' and @title='Search Salesforce']")).sendKeys("Burlington");
		
		// wait for result <-- not best practice
		Thread.sleep(500);
		
		// find result item and click it
		WebElement element1 = driver.findElement(By.xpath(".//ul[contains(@class, 'lookup__list')]/li[contains(@class, 'MRU_GLOBAL')]/a"));
		element1.click();
		
		Thread.sleep(600);
		
		// expand action list on record
		WebElement element21 = driver.findElement(By.xpath(".//a[@title='Show 7 more actions']"));
		element21.click();
		
		Thread.sleep(200);
		
		// find and click button "New Opportunity"
		WebElement element31 = driver.findElement(By.xpath(".//a[@title='New Opportunity']"));
		element31.click();

		Thread.sleep(200);
		
		// fill out opportunity name
		WebElement element41 = driver.findElement(By.xpath(".//span[text()='Opportunity Name']"));
		WebElement element42 = element41.findElement(By.xpath("./ancestor::div[contains(@class, 'uiInput')]"));
		WebElement element43 = element42.findElement(By.xpath("./input"));
		String opptyName = "Selenium Test Opportunity " + sdf.format(new Date());
		element43.sendKeys(opptyName);
		
		// expand stage
		WebElement element7 = driver.findElement(By.xpath(".//span[text()='Stage']"));
		WebElement element8 = element7.findElement(By.xpath("./ancestor::div[contains(@class, 'uiInput')]"));
		WebElement element9 = element8.findElement(By.xpath(".//a[text()='--None--']"));
		element9.click();
		
		Thread.sleep(500);
		
		// select stage Value Proposition
		WebElement element10 = driver.findElement(By.xpath(".//a[@title='Value Proposition']"));
		element10.click();
		
		// amount
		WebElement element11 = driver.findElement(By.xpath(".//span[text()='Amount']"));
		WebElement element12 = element11.findElement(By.xpath("./ancestor::div[contains(@class, 'uiInput')]"));
		WebElement element13 = element12.findElement(By.xpath("./input"));
		element13.sendKeys("1234");
		
		// next step
		WebElement element81 = driver.findElement(By.xpath(".//span[text()='Next Step']"));
		WebElement element82 = element81.findElement(By.xpath("./ancestor::div[contains(@class, 'uiInput')]"));
		WebElement element83 = element82.findElement(By.xpath("./input"));
		element83.sendKeys("Let's see");
		
		// submit opportunity
		WebElement element91 = driver.findElement(By.xpath(".//div[contains(@class, 'modal-footer')]"));
		WebElement element92 = element91.findElement(By.xpath(".//span[text()='Save']"));
		WebElement element93 = element92.findElement(By.xpath("./ancestor::button"));
		element93.click();
		
		// check success messaage
		WebElement element101 = driver.findElement(By.xpath(".//div[text()='" + opptyName + "']"));
		assertNotNull(element101);
	}

	@AfterEach
	public void cleanup() {
		driver.quit();
	}

}
