package com.nttdata.scs.selenium.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;

public class GenericPage extends BasePage {

	public GenericPage(WebDriver webDriver) {
		super(webDriver, null);
	}

	public ListView getListView() {
		// div class forceListViewManager
		WebElement result = getWebDriver().findElement(new ByChained(By.tagName("div"), By.className("forceListViewManager")));
		
		return new ListView(getWebDriver(), result);
	}


	public ModalContainer getModalContainer() {
		WebElement result = getWebDriver().findElement(By.xpath(".//div[contains(concat(' ',normalize-space(@class),' '),' modal-container ')]"));
		return new ModalContainer(getWebDriver(), result);
	}

}
