package com.nttdata.scs.selenium.salesforce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * a
 */
public class Link extends BaseComponent {

	public Link(WebDriver webDriver, WebElement context) {
		super(webDriver, context);
	}
	
	public void click()
	{
		getContext().click();
	}

}
