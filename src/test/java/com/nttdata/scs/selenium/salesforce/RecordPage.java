package com.nttdata.scs.selenium.salesforce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class RecordPage extends BasePage {

	public RecordPage(WebDriver driver, WebElement context) {
		super(driver, context);
	}

	public abstract String getRecordName();
	
}
