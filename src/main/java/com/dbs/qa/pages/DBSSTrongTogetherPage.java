package com.dbs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dbs.qa.base.TestBase;

public class DBSSTrongTogetherPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Singapore') and @href='#slideToN103A6' and @class='hasDevice']")
	WebElement singapore;

	public DBSSTrongTogetherPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyDBSSTPageTitle() {
		return driver.getTitle();
	}

	public SingaporePage selectSingapore() {
		singapore.isSelected();
		return new SingaporePage();

	}

}
