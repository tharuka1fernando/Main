package com.dbs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dbs.qa.base.TestBase;

public class SingaporePage extends TestBase {

	@FindBy(xpath = "//div[@class='navbar-links-left']//a[text()='About']")
	WebElement about;

	public SingaporePage() {
		PageFactory.initElements(driver, this);
	}

	public String getSingaporePageTitle() {
		return driver.getTitle();
	}

	public AboutPage nevigateAbout() {

		about.click();
		return new AboutPage();

	}
}
