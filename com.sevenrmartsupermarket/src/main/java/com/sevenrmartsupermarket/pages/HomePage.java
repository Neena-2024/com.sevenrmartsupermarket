package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='d-block']")
	private WebElement profileName;
	@FindBy(xpath="//img[@class='img-circle']")
	private WebElement adminLogo;
	@FindBy(xpath="//a[@class='dropdown-item'][2]")
	private WebElement logoutMenu;
	@FindBy(xpath="(//p[contains(text(),'Sub Category')]//following::a[1])[2]")
	private WebElement subCategory;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']//i[@class='fas fa-arrow-circle-right']")
	private WebElement adminUser;
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	private WebElement adminUserText;
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	private WebElement subCategoryText;
	@FindBy(xpath="//b[contains(text(),'7rmart supermarket')]")
	private WebElement loginText;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getProfileName()
	{
		return profileName.getText();
	}
	public String isTitlePresent() {
		return driver.getTitle();
	}
	public void clickLogout() {
		adminLogo.click();
		logoutMenu.click();
	}
	public String loginPageText() {
		return loginText.getText();
	}
	public SubcategoryPage clickSubCategory() {
		subCategory.click();
		return new SubcategoryPage(driver);
	}
	public String subCategoryPageDisplay() {
		return subCategoryText.getText();
	}
	public AdminUserPage clickAdminUsers() {
		adminUser.click();
		return new AdminUserPage(driver);
	}
	public String adminUserPageDisplay() {
		return adminUserText.getText();
	}
	
	
}
