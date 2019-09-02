package com.nttdata.scs.selenium.salesforce;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseComponent {
	
	private WebElement context;
	private WebDriver webDriver;
	
	public BaseComponent(WebDriver webDriver, WebElement context) {
		this.context = context;
		this.webDriver = webDriver;
	}

	public WebElement getContext() {
		return context;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}
	
	public void waitForPageToBeReady() 
	{
	    JavascriptExecutor js = (JavascriptExecutor)getWebDriver();

	    //This loop will rotate for 100 times to check If page Is ready after every 1 second.
	    //You can replace your if you wants to Increase or decrease wait time.
	    for (int i=0; i<400; i++)
	    { 
	        try 
	        {
	            Thread.sleep(1000);
	        }catch (InterruptedException e) {} 
	        //To check page ready state.

	        if (js.executeScript("return document.readyState").toString().equals("complete"))
	        { 
	            break; 
	        }   
	      }
	 }
}
