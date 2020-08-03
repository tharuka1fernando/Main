package com.dbs.qa.pages;

//import org.openqa.selenium.By;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import com.dbs.qa.base.TestBase;

public class FirstPage extends TestBase {

	@FindBy(xpath = "//h4[contains(text(),'Sustainability at DBS')]")
	@CacheLookup
	WebElement sustainabilityWebElement;

	public FirstPage() {
		PageFactory.initElements(driver, this);
	}

	public String DefaultPageTitle() {
		return driver.getTitle();

	}

	public void scrollDown() {
		Actions actions = new Actions(driver);
		actions.moveToElement(sustainabilityWebElement);
		actions.perform();
	}

	public SustainabilityPage GoToSustainability() {
		scrollDown();

		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.elementToBeClickable(sustainabilityWebElement));

		sustainabilityWebElement.click();

		return new SustainabilityPage();
	}

}
