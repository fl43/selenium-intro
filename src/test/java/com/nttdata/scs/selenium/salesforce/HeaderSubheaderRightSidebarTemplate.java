package com.nttdata.scs.selenium.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class HeaderSubheaderRightSidebarTemplate extends RecordPage {

	public HeaderSubheaderRightSidebarTemplate(WebDriver driver, WebElement context) {
		super(driver, context);
	}

	public RecordPageSection getHeader()
	{
		// TODO
		return null;
	}
	
	public RecordPageSection getSubheader()
	{
		// TODO
		return null;
	}
	
	public RecordPageSection getMainPage()
	{
		// TODO
		return null;
	}
	
	public RecordPageSection getRightSidebar()
	{
		System.out.println("Finding right side bar...");
		
		WebElement result0 = getWebDriver().findElement(By.xpath(".//div[contains(concat(' ',normalize-space(@class),' '),' desktop ') and contains(concat(' ',normalize-space(@class),' '),' container ') and contains(concat(' ',normalize-space(@class),' '),' oneOne ')]"));
		System.out.println("Found desktop container " + result0.getAttribute("data-aura-rendered-by"));
		
		WebElement result1 = result0.findElement(By.xpath(".//div[contains(concat(' ',normalize-space(@class),' '),' windowViewMode-normal ') and contains(concat(' ',normalize-space(@class),' '),' active ')]"));
		System.out.println("Found active content " + result1.getAttribute("data-aura-rendered-by"));
		
		WebElement result2 = result1.findElement(By.xpath(".//div[contains(concat(' ',normalize-space(@class),' '),' flexipageBaseRecordHomeTemplateDesktop ')]"));
		System.out.println("Found record template " + result2.getAttribute("data-aura-rendered-by"));
		
		WebElement result3 = result2.findElement(By.xpath(".//div[contains(concat(' ',normalize-space(@class),' '),' row-main ')]"));
		System.out.println("Found main row " + result3.getAttribute("data-aura-rendered-by"));
		
		WebElement result4 = result3.findElement(By.xpath(".//div[contains(concat(' ',normalize-space(@class),' '),' region-sidebar-right ')]"));
		System.out.println("Found right side bar " + result4.getAttribute("data-aura-rendered-by"));
		
		return new RecordPageSection(getWebDriver(), result4);
	}
}
