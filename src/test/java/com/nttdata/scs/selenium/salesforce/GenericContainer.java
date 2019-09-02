package com.nttdata.scs.selenium.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericContainer extends BaseComponent {

	public GenericContainer(WebDriver webDriver, WebElement context) {
		super(webDriver, context);
	}

	public InputElement findInputElement(String className, String label) {
		WebElement result = getContext().findElement(By.xpath(".//div[contains(concat(' ',normalize-space(@class),' '),' " + className + " ') and label/span/text()='" + label + "']"));
		return new InputElement(getWebDriver(), result);
	}

	public GenericContainer findContainer(String containerClass) {
		WebElement result = getContext().findElement(By.xpath(".//div[contains(concat(' ',normalize-space(@class),' '),' container ') and contains(concat(' ',normalize-space(@class),' '),' " + containerClass + " ')]"));
		return new GenericContainer(getWebDriver(), result);
	}
	
	public ActionButton findButton(String label) {
		WebElement result = getContext().findElement(By.xpath(".//button[text()='" + label + "']"));
		return new ActionButton(getWebDriver(), result);
	}
}
