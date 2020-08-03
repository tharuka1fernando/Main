package com.dbs.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dbs.qa.base.TestBase;
import com.dbs.qa.pages.CreatingSocialImpactPage;
import com.dbs.qa.pages.DBSSTrongTogetherPage;
import com.dbs.qa.pages.FirstPage;
import com.dbs.qa.pages.SustainabilityPage;

public class CreatingSocialImpactPageTest extends TestBase {

	FirstPage firstPage;
	SustainabilityPage sustainabilityPage;
	CreatingSocialImpactPage creatingSocialImpactPage;
	DBSSTrongTogetherPage dBSStrongtogetherPage;

	// Page 3
	CreatingSocialImpactPageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		initialization();
		firstPage = new FirstPage();
		sustainabilityPage = firstPage.GoToSustainability();
		creatingSocialImpactPage = sustainabilityPage.SelectSocialImpact();

	}

	@Test(priority = 1)
	public void socialImapctPageTitleTest() {
		String sipTitle = creatingSocialImpactPage.validateSocialImpactPageTitle();
		Assert.assertEquals(sipTitle, "Sustainability | DBS Bank");
	}

	@Test(priority = 2)
	public void gotoDBSStrongTogetherTest() {
		dBSStrongtogetherPage = creatingSocialImpactPage.selectStrongTogether();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
