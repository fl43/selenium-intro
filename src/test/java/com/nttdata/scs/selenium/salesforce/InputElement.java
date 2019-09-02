package com.nttdata.scs.selenium.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * Div um Label und Input Element.
 */
public class InputElement extends BaseComponent {

	public enum TypeEnum {
		TEXT("text"), SEARCH("search");
		
		private String type;
		
		TypeEnum(String type)
		{
			this.type = type;
		}
		
		@Override
		public String toString() {
			return type;
		}
	}
	
	private TypeEnum type;
	
	public InputElement(WebDriver webDriver, WebElement context) {
		super(webDriver, context);
		type = TypeEnum.TEXT;
	}
	
	public InputElement(WebDriver webDriver, WebElement context, TypeEnum type) {
		super(webDriver, context);
		this.type = type;
	}

	public void enter(String value) {
		WebElement inputElement = getContext().findElement(By.xpath(".//input[@type='" + type + "']"));
		inputElement.sendKeys(value);
	}

	public void click()
	{
		WebElement inputElement = getContext().findElement(By.xpath(".//input[@type='" + type + "']"));
		inputElement.click();
	}

	public void selectSuggestedValue()
	{
		WebElement inputElement = getContext().findElement(By.xpath(".//input[@type='" + type + "']"));
		inputElement.sendKeys(Keys.ARROW_DOWN);
		inputElement.sendKeys(Keys.ENTER);
	}

	public void clickSuggestedValue(String value) {
		/*
		<div class="tt-suggestion">
		<p style="white-space: normal;">
			<strong class="tt-highlight">De-LAN-BUT-V1-102
		 */

		// heavy custom stuff
		WebElement suggestion = getContext().findElement(By.xpath(".//*[text()='" + value + "']"));
		suggestion.click();
	}

	public void sendKeys(CharSequence... keysToSend) {
		WebElement inputElement = getContext().findElement(By.xpath(".//input[@type='" + type + "']"));
		inputElement.sendKeys(keysToSend);
	}

}
