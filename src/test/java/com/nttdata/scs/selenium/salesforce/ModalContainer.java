package com.nttdata.scs.selenium.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ModalContainer extends BaseComponent {

	public ModalContainer(WebDriver webDriver, WebElement context) {
		super(webDriver, context);
	}

	public RadioButton findRadioButton(String recordTypeId) {
		// div[class=modal-body]
		WebElement modalBody = getContext().findElement(By.xpath(".//div[contains(concat(' ',normalize-space(@class),' '),' modal-body ')]"));
		// input[class=uiInputRadio type="radio" value="01258000000cYIgAAM" 
		WebElement result = modalBody.findElement(By.xpath(".//input[contains(concat(' ',normalize-space(@class),' '),' uiInputRadio ') and @type='radio' and @value='" + recordTypeId + "']"));
		return new RadioButton(getWebDriver(), result);
	}

	public ActionButton findButton(String label) {
		// div[class=modal-footer]
		WebElement modalFooter = getContext().findElement(By.xpath(".//div[contains(concat(' ',normalize-space(@class),' '),' modal-footer ')]"));
		// button->span[Class=label]/text()="Next"
		WebElement result = modalFooter.findElement(By.xpath(".//button[contains(concat(' ',normalize-space(span/@class),' '),' label ') and span/text()='" + label + "']"));
		return new ActionButton(getWebDriver(), result);
	}

}
