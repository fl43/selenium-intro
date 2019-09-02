package com.nttdata.scs.selenium.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver, null);
	}

	public GenericPage navigateToRecordsPage(String recordName, String filterName) throws InterruptedException {
		// Anzeigen der Vorhaben
		getWebDriver().navigate().to(getBaseUrl() + "/lightning/o/" + recordName + "/list?filterName=" + filterName);
		
		// TODO Thread.sleep(4000);
		waitForPageToBeReady();
		
		return new GenericPage(getWebDriver());
	}

	public GenericPage impersonateUser(String userName) {
		System.out.println("Impersonate user...");
		
		getWebDriver().navigate().to(getBaseUrl() + "/lightning/setup/ManageUsers/home");
		waitForPageToBeReady();
		System.out.println("Navigated to users page");
		
		GenericPage result = new GenericPage(getWebDriver());
		
		/*
		WebElement result1 = getWebDriver().findElement(By.xpath(".//div[contains(concat(' ',normalize-space(@class),' '),' split-right ')]"));
		WebElement result2 = result1.findElement(By.xpath(""));
		*/
		
		// WebDriver frameWebDriver = getWebDriver().switchTo().frame(iFrame);
		int counter=0;
		while (counter < 20)
		{
			// TODO put timeout into configuration
			System.out.println("Waiting for iframe...");
			WebDriverWait wait1 = new WebDriverWait(getWebDriver(), 20);
			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(".//iframe[starts-with(@title, 'All Users')]")));
			System.out.println("Found iframe");
			
			WebElement result1 = getWebDriver().findElement(By.xpath(".//table[@class='list']"));
			System.out.println("Found table");
			
			try
			{
				WebElement userLink = result1.findElement(By.xpath(".//td[contains(concat(' ',normalize-space(@class),' '),' dataCell ')]/a[text()='" + userName + "']"));
				System.out.println("Found table cell containing user");
				userLink.click();
				waitForPageToBeReady();
				
				// TODO put timeout into configuration
				WebDriverWait wait2 = new WebDriverWait(getWebDriver(), 20);
				wait2.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(".//iframe[starts-with(@title, 'User:')]")));
				System.out.println("Found iframe");
				
				WebElement loginLink = getWebDriver().findElement(By.xpath(".//input[@class='btn' and @type='button' and @name='login']"));
				
				loginLink.click();
				waitForPageToBeReady();
				
				break;
			} catch (NoSuchElementException nse)
			{
				WebElement next = getWebDriver().findElement(By.xpath(".//div[@class='next']/a[starts-with(text(), 'Next Page')]"));
				next.click();
				waitForPageToBeReady();
			}
			
			counter++;
		}
		
		return result;
	}
	
}
