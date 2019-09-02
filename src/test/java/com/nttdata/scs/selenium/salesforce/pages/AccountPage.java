package com.nttdata.scs.selenium.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nttdata.scs.selenium.salesforce.ActionButton;
import com.nttdata.scs.selenium.salesforce.HeaderOneRegionTemplate;
import com.nttdata.scs.selenium.salesforce.RecordPageSection;

public class AccountPage extends HeaderOneRegionTemplate {

	public AccountPage(WebDriver driver) {
		super(driver, null);
	}

	@Override
	public String getRecordName() {
		return "Account";
	}

	public ActionButton findActionButton(String name) {
		/*
		div class slds-page-header--object-home
		ul class forceActionsContainer
		a [class=forceActionLink title="New"]
		*/
		RecordPageSection oneRegion = getOneRegion();
		
		WebElement result1 = oneRegion.getContext().findElement(By.xpath(".//div[contains(concat(' ',normalize-space(@class),' '),' forceRecordLayout ')]"));
		WebElement result2 = result1.findElement(By.xpath(".//ul[contains(concat(' ',normalize-space(@class),' '),' forceActionsContainer ')]"));
		WebElement result3 = result2.findElement(By.xpath(".//a[contains(concat(' ',normalize-space(@class),' '),' forceActionLink ') and @title='" + name + "']"));
		
		return new ActionButton(getWebDriver(), result3);
	}

}
