package com.nttdata.scs.selenium.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;

public abstract class HeaderOneRegionTemplate extends RecordPage {

	public HeaderOneRegionTemplate(WebDriver driver, WebElement context) {
		super(driver, context);
	}

	public RecordPageSection getHeader()
	{
		// TODO
		return null;
	}
	
	public RecordPageSection getOneRegion()
	{
		WebElement result = getWebDriver().findElement(new ByChained(By.tagName("div"), By.className("flexipageBaseRecordHomeTemplateDesktop")));
		
		return new RecordPageSection(getWebDriver(), result);
	}
}
