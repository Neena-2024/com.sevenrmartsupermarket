package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class AdminUserPage {
	WebDriver driver;
	GeneralUtility generalutility=new GeneralUtility();
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButtonFirst;
	@FindBy(xpath="//input[@id='un']")
	private WebElement usernameField;
	@FindBy(xpath="//select[@id='ut']")
	WebElement userTypeSelect;
	@FindBy(xpath="//button[@value='sr']")
	WebElement searchButton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[5]//i[@class='fas fa-trash-alt']")
	private WebElement deleteIcon;
	@FindBy(xpath="//i[@class=' fa fa-search']")
	private WebElement searchIcon;
	@FindBy(xpath="//input[@id='un']")
	private WebElement usernameFiled;
	@FindBy(xpath="//select[@id='ut']")
	private WebElement userTypeField;
	@FindBy(xpath="//button[@value='sr']")
	private WebElement searchButtonRed;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[5]//i[@class='fas fa-edit']")
	private WebElement editButton;
	@FindBy(xpath="//button[@name='Update']")
	private WebElement updateButton;
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement editUserNameField;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//h5[contains(text(),'Alert!')]")
	private WebElement alert;
	
	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public String clickOnDeleteAdminUserButton(String userName,String userType){
		PageUtility pageutility=new PageUtility(driver);
		searchButtonFirst.click();
		usernameField.sendKeys(userName);
		userTypeSelect.sendKeys(userType);
		searchButton.click();
		deleteIcon.click();
		String alertText=driver.switchTo().alert().getText();
		pageutility.dismissJSAlert();
		return alertText;
	}
	public AdminUserPage clickOnadminUserSearch() {
		searchIcon.click();
		return this;
	}
	public AdminUserPage serachAdminUsers(String userName,String userType) {
		usernameField.sendKeys(userName);
		userTypeField.sendKeys(userType);
		searchButtonRed.click();
		return this;
	}
	public AdminUserPage editAdminUserName(String userName,String newUserName) {
		editButton.click();
		editUserNameField.clear();
		editUserNameField.sendKeys(newUserName);
		updateButton.click();
		return this;
	}
	public String getTextOfTheAlert() {
		return generalutility.getTextValue(alert);
	}
}
