package com.nttdata.scs.selenium.salesforce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButton extends BaseComponent {

	public RadioButton(WebDriver webDriver, WebElement context) {
		super(webDriver, context);
	}

	public void click() throws InterruptedException {
		if (!getContext().isSelected())
		{
			click();
			// TODO Thread.sleep(4000);
			waitForPageToBeReady();
		}
	}

}
