package com.dbs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dbs.qa.base.TestBase;

public class SustainabilityPage extends TestBase {
	
	@FindBy(xpath="//h4[contains(text(),'Creating Social Impact')]")
	WebElement createSocialImpact;
	
	
	public SustainabilityPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	
	public CreatingSocialImpactPage SelectSocialImpact() {
		createSocialImpact.click();
		
		return new CreatingSocialImpactPage();
	}

}
