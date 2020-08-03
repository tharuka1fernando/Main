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
import com.dbs.qa.pages.SingaporePage;
import com.dbs.qa.pages.SustainabilityPage;
import com.dbs.qa.pages.WhoWeArePage;

public class AboutPageTest extends TestBase {

	FirstPage firstPage;
	SustainabilityPage sustainabilityPage;
	CreatingSocialImpactPage creatingSocialImpactPage;
	DBSSTrongTogetherPage dBSStrongtogetherPage;
	SingaporePage singaporePage;
	AboutPage aboutPage;
	WhoWeArePage whoWeArePage;

	// Page 6
	public AboutPageTest() {
		super();
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

	}

	@Test(priority = 1)
	public void getAboutPageTitle() {
		String aboutTitle = aboutPage.getAboutPageTitle();
		Assert.assertEquals(aboutTitle, "About DBS Bank – Asia’s Safest Bank - Singapore’s Bank of Choice | DBS Bank");
	}

	@Test(priority = 2)
	public void goToWhoWeAre() {
		whoWeArePage = aboutPage.NavigateWhoWeAre();

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
