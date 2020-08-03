package com.dbs.qa.testcases;

//import static org.testng.Assert.assertEquals;

import org.testng.Assert;
//import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dbs.qa.base.TestBase;
import com.dbs.qa.pages.CreatingSocialImpactPage;
import com.dbs.qa.pages.FirstPage;
import com.dbs.qa.pages.SustainabilityPage;

public class SustainabilityPageTest extends TestBase {

	FirstPage firstPage;
	SustainabilityPage sustainabilityPage;
	CreatingSocialImpactPage creatingSocialImpactPage;

	// Page 2
	public SustainabilityPageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		initialization();
		firstPage = new FirstPage();
		sustainabilityPage = firstPage.GoToSustainability();
	}

	@Test(priority = 1)
	public void sustainabilityPageTitleTest() {
		String susPagetitle = sustainabilityPage.getPageTitle();
		Assert.assertEquals(susPagetitle, "Sustainability | DBS Bank");
	}

	@Test(priority = 2)
	public void clickCreatingSocialImpactTest() {
		creatingSocialImpactPage = sustainabilityPage.SelectSocialImpact();
		System.out.println(creatingSocialImpactPage.validateSocialImpactPageTitle());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
