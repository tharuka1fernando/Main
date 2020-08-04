package com.dbs.qa.testcases;

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
import com.dbs.qa.pages.SingaporePage;
import com.dbs.qa.pages.SustainabilityPage;
import com.dbs.qa.util.ExcelWriter;

public class SingaporePageTest extends TestBase {

	FirstPage firstPage;
	SustainabilityPage sustainabilityPage;
	CreatingSocialImpactPage creatingSocialImpactPage;
	DBSSTrongTogetherPage dBSStrongtogetherPage;
	SingaporePage singaporePage;
	AboutPage aboutPage;

	// Page 5
	public SingaporePageTest() {
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

	}

	@Test(priority = 1)
	public void getSingaporePageTitle() {
		String singTitle = singaporePage.getSingaporePageTitle();
		Assert.assertEquals(singTitle, "DBS Stronger Together Fund | DBS Bank");
	}

	@Test(priority = 2)
	public void readAndWriteTableTest() {

		WebElement tableElement = driver.findElement(By.xpath("//tbody"));
		List<WebElement> tableRows = tableElement.findElements(By.tagName("tr"));

		String[][] report = new String[tableRows.size()][];
		for (int i = 0; i < tableRows.size(); i++) {
			List<WebElement> tableColummns = tableRows.get(i).findElements(By.tagName("td"));

			String[] colVal = new String[tableColummns.size()];
			for (int j = 0; j < tableColummns.size(); j++) {
				colVal[j] = tableColummns.get(j).getText().trim().length() == 0 ? ""
						: tableColummns.get(j).findElement(By.tagName("p")).getText();
			}
			report[i] = colVal;
		}
		System.out.println(Arrays.deepToString(report));		

		ExcelWriter reader = new ExcelWriter(".\\src\\main\\java\\com\\dbs\\qa\\testdata\\DBSAssesmentTestData.xlsx",
				"TableData", report,false);
		reader.write();
		}
	

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
