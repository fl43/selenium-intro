package com.nttdata.scs.selenium.salesforce.pages;

import org.openqa.selenium.WebDriver;

import com.nttdata.scs.selenium.salesforce.HeaderSubheaderRightSidebarTemplate;
import com.nttdata.scs.selenium.salesforce.RecordPageSection;

public class OpportunityPage extends HeaderSubheaderRightSidebarTemplate {

	public OpportunityPage(WebDriver driver) {
		super(driver, null);
	}

	@Override
	public String getRecordName() {
		return "Opportunity";
	}

	public DTopptiesFlowContainer findFlowContainer() {
		RecordPageSection rightSidebar = getRightSidebar();
		
		return DTopptiesFlowContainer.findIn(rightSidebar);
	}

}
