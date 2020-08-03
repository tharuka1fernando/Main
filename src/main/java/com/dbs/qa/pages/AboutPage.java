package com.dbs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dbs.qa.base.TestBase;

public class AboutPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Who We Are')]")
	WebElement WhoWeAre;

	public AboutPage() {
		PageFactory.initElements(driver, this);

	}

	public String getAboutPageTitle() {
		return driver.getTitle();
	}

	public WhoWeArePage NavigateWhoWeAre() {

		WhoWeAre.click();
		return new WhoWeArePage();
	}

}
