package com.nttdata.scs.selenium.salesforce;

import static org.junit.jupiter.api.Assertions.fail;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage extends BaseComponent {

	public BasePage(WebDriver webDriver, WebElement context)
	{
		super(webDriver, context);
	}
	
	public String getBaseUrl()  {
		String result = null;
		
		try {
			URL url = new URL(getWebDriver().getCurrentUrl());
			
			result = String.format("%s://%s", url.getProtocol(), url.getHost());
		} catch (MalformedURLException e) {
			fail(e.getMessage(), e);
		}
		return result;
	}
	
}
