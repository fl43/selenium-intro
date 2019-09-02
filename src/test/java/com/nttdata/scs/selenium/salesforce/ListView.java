package com.nttdata.scs.selenium.salesforce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class ListView extends BaseComponent {

	public ListView(WebDriver webDriver, WebElement webElement) {
		super(webDriver, webElement);
	}
	
	public ActionButton findActionButton(String name)
	{
		/*
		div class slds-page-header--object-home
		ul class forceActionsContainer
		a [class=forceActionLink title="New"]
		*/
		System.out.println("Finding action button element...");
		
		WebElement result1 = getContext().findElement(By.xpath(".//div[contains(concat(' ',normalize-space(@class),' '),' slds-page-header--object-home ')]"));
		System.out.println("Found div element " + result1.getAttribute("data-aura-rendered-by"));
		
		WebElement result2 = result1.findElement(By.xpath(".//ul[contains(concat(' ',normalize-space(@class),' '),' forceActionsContainer ')]"));
		System.out.println("Found list element " + result2.getAttribute("data-aura-rendered-by"));
		
		WebElement result3 = result2.findElement(By.xpath(".//a[contains(concat(' ',normalize-space(@class),' '),' forceActionLink ') and @title='" + name + "']"));
		System.out.println("Found link element " + result3.getAttribute("data-aura-rendered-by"));
		
		return new ActionButton(getWebDriver(), result3);
	}

	public InputElement findSearchInput() {
		/*
		 div class search-in-list
		 input type="search"
		 */
		System.out.println("Finding search input element...");
		
		WebElement result = getContext().findElement(By.xpath(".//div[contains(concat(' ',normalize-space(@class),' '),' search-in-list ')]"));
		System.out.println("Found enclosing div element");
		
		return new InputElement(getWebDriver(), result, InputElement.TypeEnum.SEARCH);
	}

	public Link findResultItem(String name) {
		/*
		table class="forceRecordLayout"
		th class="cellContainer"
		a class="forceOutputLookup" title="<name>"
		 */
		WebElement result1 = getContext().findElement(By.xpath(".//table[contains(concat(' ',normalize-space(@class),' '),' forceRecordLayout ')]"));
		WebElement result2 = result1.findElement(By.xpath(".//th[contains(concat(' ',normalize-space(@class),' '),' cellContainer ')]"));
		WebElement result3 = result2.findElement(By.xpath(".//a[contains(concat(' ',normalize-space(@class),' '),' forceOutputLookup ') and @title='" + name + "']"));
		
		return new Link(getWebDriver(), result3);
	}


}
