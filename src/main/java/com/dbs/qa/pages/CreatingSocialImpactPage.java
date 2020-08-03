package com.dbs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dbs.qa.base.TestBase;

public class CreatingSocialImpactPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'DBS Stronger Together Fund')]")
	WebElement StrongTogether;

	public CreatingSocialImpactPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateSocialImpactPageTitle() {
		return driver.getTitle();
	}

	public DBSSTrongTogetherPage selectStrongTogether() {
		StrongTogether.click();

		return new DBSSTrongTogetherPage();
	}
}
