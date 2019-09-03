package com.nttdata.scs.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.nttdata.scs.selenium.salesforce.ActionButton;
import com.nttdata.scs.selenium.salesforce.GenericPage;
import com.nttdata.scs.selenium.salesforce.HomePage;
import com.nttdata.scs.selenium.salesforce.InputElement;
import com.nttdata.scs.selenium.salesforce.Link;
import com.nttdata.scs.selenium.salesforce.ListView;
import com.nttdata.scs.selenium.salesforce.RadioButton;
import com.nttdata.scs.selenium.salesforce.StartPage;
import com.nttdata.scs.selenium.salesforce.pages.AccountPage;
import com.nttdata.scs.selenium.salesforce.pages.OpportunityPage;

public class CreateOpportunityTest {

	private WebDriver driver;

	@BeforeEach
	public void main() throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver", "c:\\tools\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	}

	@Test
	public void erstelleVorhabenAufdemGP() throws InterruptedException {
		SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-dd HH:mm"); // "yyyy-MM-dd HH:mm:ss.SSS"

		StartPage startPage = new StartPage(driver, "https://trailhead-iaam-dev-ed.my.salesforce.com");

		// HomePage homePage = startPage.doLogin("...",
		// "???");
		HomePage homePage = startPage.doLogin("lazy.beaver@nttdata.com.iaam", "REPLACE_THIS");

		// TODO FL delete homePage.impersonateUser("magentaforce2@telekom.demo.int2");

		/*
		 * driver.findElement(By.xpath(
		 * "/html[1]/body[1]/div[5]/div[1]/section[1]/header[1]/div[3]/one-appnav[1]/div[1]/one-app-nav-bar[1]/nav[1]/ul[1]/li[4]/a[1]"
		 * )) .click(); Thread.sleep(4000);
		 */
		GenericPage recordsPage = homePage.navigateToRecordsPage("Account", "00B58000001NiknEAC");
		recordsPage.waitForPageToBeReady();

		ListView accountsListView = recordsPage.getListView();

		// Druecken des Button "Neu"
		/*
		 * driver.findElement( By.xpath(
		 * "/html/body/div[5]/div[1]/section/div[2]/div/div[1]/div[2]/div/div/div[1]/div[1]/div[2]"
		 * )) .click(); Thread.sleep(4000);
		 */
		// search GP "De-LAN-BUT-V1-102"
		InputElement searchInput = accountsListView.findSearchInput();
		searchInput.enter("26022060");
		searchInput.sendKeys(Keys.ENTER);

		recordsPage.waitForPageToBeReady();

		Link link = accountsListView.findResultItem("De-LAN-BUT-V1-102");
		link.click();

		AccountPage accountPage = new AccountPage(driver);
		accountPage.waitForPageToBeReady();

		ActionButton actionButton = accountPage.findActionButton("Neues Vorhaben");
		actionButton.click();

		/*
		 * TODO ActionButton actionButton = accountsListView.findActionButton("Neu");
		 * actionButton.click();
		 */

		// TODO for SysAdmin only
		/*
		 * ModalContainer modalContainer = recordsPage.getModalContainer();
		 * 
		 * // select radio button // TODO make recordtype ID dynamically (or
		 * configurable) RadioButton radioButton =
		 * modalContainer.findRadioButton("01258000000cYIgAAM"); radioButton.click();
		 * 
		 * // click button ActionButton actionButtonNext =
		 * modalContainer.findButton("Next"); actionButtonNext.click();
		 */

		// TODO HighlightsPanel highLightsPanel = new
		// HighlightsPanel(opptyPage.getHeader());
		DTaddOpportunity addOpportunity = DTaddOpportunity.findIn(accountPage);

		// Fuellen des Feldes "Vorhaben-Name"
		/*
		 * driver.findElement(By.xpath(
		 * "/html[1]/body[1]/div[5]/div[1]/section[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]"
		 * )) .sendKeys("Automatisierter_Test" + sdf.format(new Date()));
		 * Thread.sleep(4000);
		 */
		InputElement vorhabenName = addOpportunity.findInputElement("uiInputText", "Vorhaben-Name");
		vorhabenName.enter("Automatisierter_Test" + sdf.format(new Date()));

		// Fuellen des Feldes "Geschaeftspartner"
		/*
		 * driver.findElement(By.xpath(
		 * "/html[1]/body[1]/div[5]/div[1]/section[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/span[1]/input[1]"
		 * )) .sendKeys("De-LAN-BUT-V1-102"); Thread.sleep(4000);
		 */
		/*
		 * TODO DTaddPartnerToOppty addPartnerToOppty =
		 * DTaddPartnerToOppty.findIn(addOpportunity);
		 * 
		 * InputElement gp = addPartnerToOppty.findInputElement(); // gp.click();
		 * gp.enter("De-LAN-BUT-V1-102"); gp.selectSuggestedValue();
		 * 
		 * System.out.println(driver.getPageSource());
		 */

		// gp.clickSuggestedValue("De-LAN-BUT-V1-102");

		/*
		 * TODO remove
		 * 
		 * gp.click();
		 */

		// Druecken des Button "Speichern"
		/*
		 * driver.findElement(By.xpath(
		 * "/html[1]/body[1]/div[5]/div[1]/section[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/span[1]/span[1]/div[1]/span[1]/div[1]/p[1]"
		 * )) .click(); Thread.sleep(4000);
		 */
		ActionButton save = addOpportunity.findButton("Speichern");
		save.click();

		/*
		 * ??? driver.findElement(By.xpath(
		 * "/html[1]/body[1]/div[5]/div[1]/section[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[3]/button[2]"
		 * )) .click(); Thread.sleep(4000);
		 */

		OpportunityPage opportunityPage = new OpportunityPage(driver);
		// TODO is this really needed?
		opportunityPage.waitForPageToBeReady();

		DTopptiesFlowContainer flowContainer = opportunityPage.findFlowContainer();

		ActionButton weiterButton1 = flowContainer.findWeiter();
		weiterButton1.click();

		RadioButton radioButton = flowContainer.findRadioButton("Direktübergabe - (Senior-)VB");
		radioButton.click();

		InputElement inputElement = flowContainer.findInputElement();
		inputElement.enter("Automatisierter_Test" + sdf.format(new Date()));

		ActionButton weiterButton2 = flowContainer.findWeiter();
		weiterButton2.click();

		// TODO some assert
	}

	@AfterEach
	public void cleanup() {
		driver.quit();
	}

}
