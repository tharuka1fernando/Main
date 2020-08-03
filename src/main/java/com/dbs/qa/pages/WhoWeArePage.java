package com.dbs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dbs.qa.base.TestBase;

public class WhoWeArePage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Our Awards & Accolades')]")
	WebElement Awards;

	WhoWeArePage() {
		PageFactory.initElements(driver, this);
	}

	public String getWhoWeArePageTitle() {
		return driver.getTitle();
	}

	public OurAwardsPage navigateToAwards() {
		Awards.click();
		return new OurAwardsPage();
	}
}
