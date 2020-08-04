package com.dbs.qa.testcases;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import com.dbs.qa.util.ExcelWriter;

public class OurAwardsPageTest extends TestBase {

	FirstPage firstPage;
	SustainabilityPage sustainabilityPage;
	CreatingSocialImpactPage creatingSocialImpactPage;
	DBSSTrongTogetherPage dBSStrongtogetherPage;
	SingaporePage singaporePage;
	AboutPage aboutPage;
	WhoWeArePage whoWeArePage;
	OurAwardsPage ourAwardsPage;

	public OurAwardsPageTest() {

	}
	
	//Page 8

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
		ourAwardsPage = whoWeArePage.navigateToAwards();
	}

	@Test(priority = 1)
	public void getPageTitle() {
		String AwardTitle = ourAwardsPage.getAwardPageTitle();
		Assert.assertEquals(AwardTitle, "Banking Awards & Accolades | DBS Bank");
	}

	@Test(priority = 2)
	public void takeAwardListTest() {
		List<WebElement> objLinks = driver.findElements(By.xpath("//div[@class='row mBot-20']"));
		String[][] report = new String[objLinks.size() + 1][2];
		report[0] = new String[] { "Award Name", "Caption of the award" };

		for (int i = 0; i < objLinks.size(); i++) {
			report[i + 1] = new String[] { objLinks.get(i).findElement(By.tagName("strong")).getText(),
					objLinks.get(i).findElement(By.tagName("p")).getText() };
		}

		System.out.println(Arrays.deepToString(report));

		ExcelWriter reader = new ExcelWriter(".\\src\\main\\java\\com\\dbs\\qa\\testdata\\DBSAssesmentTestData.xlsx",
				"AwardList", report,true);
		reader.write();

		int size1 = driver.findElements(By.xpath("//div[@class='row mBot-20']")).size();
		System.out.println(size1);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
