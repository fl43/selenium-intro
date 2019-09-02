package com.nttdata.scs.selenium.salesforce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nttdata.scs.selenium.salesforce.BaseComponent;

public abstract class CustomComponent extends BaseComponent {

	public CustomComponent(WebDriver webDriver, WebElement context) {
		super(webDriver, context);
	}

}
