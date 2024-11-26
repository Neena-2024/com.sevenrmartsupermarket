package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='d-block']")
	private WebElement profileName;
	@FindBy(xpath="(//p[contains(text(),'Sub Category')]//following::a[1])[2]")
	private WebElement subCategory;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getProfileName()
	{
		return profileName.getText();
	}
	public SubcategoryPage clickSubCategory() {
		subCategory.click();
		return new SubcategoryPage(driver);
	}
	
}
