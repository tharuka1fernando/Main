package com.dbs.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.dbs.qa.base.TestBase;

public class OurAwardsPage extends TestBase {

	public OurAwardsPage() {
		PageFactory.initElements(driver, this);
	}

	public String getAwardPageTitle() {
		return driver.getTitle();
	}

}
