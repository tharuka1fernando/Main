package com.dbs.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dbs.qa.base.TestBase;
import com.dbs.qa.pages.CreatingSocialImpactPage;
import com.dbs.qa.pages.DBSSTrongTogetherPage;
import com.dbs.qa.pages.FirstPage;
import com.dbs.qa.pages.SingaporePage;
import com.dbs.qa.pages.SustainabilityPage;

public class DBSSTrongTogetherPageTest extends TestBase {

	FirstPage firstPage;
	SustainabilityPage sustainabilityPage;
	CreatingSocialImpactPage creatingSocialImpactPage;
	DBSSTrongTogetherPage dBSStrongtogetherPage;
	SingaporePage singaporePage;

	DBSSTrongTogetherPageTest() {
		super();
	}

	// Page 4
	@BeforeMethod
	public void Setup() {
		initialization();
		firstPage = new FirstPage();
		sustainabilityPage = firstPage.GoToSustainability();
		creatingSocialImpactPage = sustainabilityPage.SelectSocialImpact();
		dBSStrongtogetherPage = creatingSocialImpactPage.selectStrongTogether();

	}

	@Test(priority = 1)
	public void getDBSSTPageTitleTest() {
		String dbssttitle = dBSStrongtogetherPage.verifyDBSSTPageTitle();
		Assert.assertEquals(dbssttitle, "DBS Stronger Together Fund | DBS Bank");
	}

	@Test(priority = 2)
	public void selectSingaporeTest() {
		singaporePage = dBSStrongtogetherPage.selectSingapore();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
