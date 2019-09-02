package com.nttdata.scs.selenium.salesforce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionButton extends BaseComponent {

	public ActionButton(WebDriver webDriver, WebElement context) {
		super(webDriver, context);
	}

	public void click() throws InterruptedException {
		getContext().click();
		
		//Thread.sleep(4000);
		waitForPageToBeReady();
	}
	
}
