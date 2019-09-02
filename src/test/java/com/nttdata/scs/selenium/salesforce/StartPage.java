package com.nttdata.scs.selenium.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage extends BasePage {

	private String url;
	
	public StartPage(WebDriver webDriver, String url) {
		super(webDriver, null);
		this.url = url;
	}
	
	public HomePage doLogin(String userName, String password) throws InterruptedException
	{
		// execute login

		// TODO parametrize this
		getWebDriver().get(url);
		
		waitForPageToBeReady();
		
		getWebDriver().findElement(By.id("username")).sendKeys(userName);
		getWebDriver().findElement(By.id("password")).sendKeys(password);
		getWebDriver().findElement(By.id("Login")).click();
//		driver.get("https://websso-myiam-ite1-cp.app.t-internal.com/sps/myiamite1test/saml20/logininitial?RequestBinding=HTTPPost&PartnerId=https://magentaforce--int.cs89.my.salesforce.com&NameIdFormat=Email");
		
		// TODO find a better solution
//		Thread.sleep(4000);
		waitForPageToBeReady();
		
		return new HomePage(getWebDriver());
	}
}
