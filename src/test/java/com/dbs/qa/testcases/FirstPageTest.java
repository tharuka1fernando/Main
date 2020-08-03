package com.dbs.qa.testcases;

//import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dbs.qa.base.TestBase;
import com.dbs.qa.pages.FirstPage;
import com.dbs.qa.pages.SustainabilityPage;

public class FirstPageTest extends TestBase {
	FirstPage firstPage;
	SustainabilityPage sustainabilityPage;

	public FirstPageTest() {
		super();
	}
	
	// Page 1

	@BeforeMethod
	public void SetUp() {
		initialization();
		firstPage = new FirstPage();

	}

	@Test(priority = 1)
	public void defaultPageTitleTest() {
		String title = firstPage.DefaultPageTitle();
		Assert.assertEquals(title, "Bank Accounts, Cards, Loans, Financial Planning | DBS Singapore");

	}

	@Test(priority = 2)
	public void clickSustainabilityTest() {
		sustainabilityPage = firstPage.GoToSustainability();
		System.out.println(sustainabilityPage.getPageTitle());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
