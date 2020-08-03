package com.dbs.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dbs.qa.base.TestBase;
import com.dbs.qa.pages.AboutPage;
import com.dbs.qa.pages.CreatingSocialImpactPage;
import com.dbs.qa.pages.DBSSTrongTogetherPage;
import com.dbs.qa.pages.FirstPage;
import com.dbs.qa.pages.OurAwardsPage;
import com.dbs.qa.pages.SingaporePage;
import com.dbs.qa.pages.SustainabilityPage;
import com.dbs.qa.pages.WhoWeArePage;

public class WhoWeArePageTest extends TestBase {

	FirstPage firstPage;
	SustainabilityPage sustainabilityPage;
	CreatingSocialImpactPage creatingSocialImpactPage;
	DBSSTrongTogetherPage dBSStrongtogetherPage;
	SingaporePage singaporePage;
	AboutPage aboutPage;
	WhoWeArePage whoWeArePage;
	OurAwardsPage ourAwardsPage;

	//Page 7
	public WhoWeArePageTest() {

	}

	@BeforeMethod
	public void Setup() {
		initialization();
		firstPage = new FirstPage();
		sustainabilityPage = firstPage.GoToSustainability();
		creatingSocialImpactPage = sustainabilityPage.SelectSocialImpact();
		dBSStrongtogetherPage = creatingSocialImpactPage.selectStrongTogether();
		singaporePage = dBSStrongtogetherPage.selectSingapore();
		aboutPage = singaporePage.nevigateAbout();
		whoWeArePage = aboutPage.NavigateWhoWeAre();

	}

	@Test(priority = 1)
	public void getWoWeArePageTitleTest() {
		String whoweareTitle = whoWeArePage.getWhoWeArePageTitle();
		Assert.assertEquals(whoweareTitle, "Who We Are");

	}

	@Test(priority = 2)
	public void navigateToAwardPageTest() {
		ourAwardsPage = whoWeArePage.navigateToAwards();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
