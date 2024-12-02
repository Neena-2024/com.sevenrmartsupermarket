package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class SubcategoryPage {
	WebDriver driver;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchicon;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	private WebElement categorydropdown;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement subcategoryfield;
	@FindBy(xpath = "//button[@class='class='btn btn-danger btn-fix']")
	private WebElement search;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	private WebElement searchButtonRed;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	private List<WebElement> table;
	@FindBy(xpath="//span[@id='res']")
	private WebElement errorResult;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//h5[contains(text(),'Alert!')]")
	private WebElement newAlert;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetButton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[4]")
	private WebElement statusButton;
	@FindBy(xpath="//input[@type='file']")
	private WebElement imageFileButton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[5]//i[@class='fas fa-trash-alt']")
	private WebElement deleteButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//h5[contains(text(),'Alert')]")
	private WebElement alertDeletion;
	
	GeneralUtility generalutility=new GeneralUtility();
	
	public SubcategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnSearchIcon() {
		searchicon.click();
	}
	public void selectCategory(String category) {
		PageUtility pageutility = new PageUtility(driver);
		pageutility.selectByvisibleText(categorydropdown, category);
		categorydropdown.sendKeys(category);
	}
	public void enterSubCategory(String subCategory) {
		subcategoryfield.click();
		subcategoryfield.sendKeys(subCategory);
	}
	public void clickonSearchButtobRed() {
		searchButtonRed.click();
	}
	public void searchSubCategory(String category, String subCategory) {
		clickOnSearchIcon();
		selectCategory(category);
		enterSubCategory(subCategory);
		clickonSearchButtobRed();
	}
	public List<String> getSearchResult() {
		List<String> list=new ArrayList<String>();
		list=generalutility.getTextOfElements(table);
		return list;
	}
	public String resultNotfoundMeggaseVerification() {
		return generalutility.getTextValue(errorResult);
	}
	public void addingNewSubCategory(String category,String subCategory) {
		newButton.click();
		selectCategory(category);
		enterSubCategory(subCategory);
		saveButton.click();
	}
	public String subCtegoryCreatedSuccessfullyMessageVerification() {
		return generalutility.getTextValue(newAlert);
	}
	public boolean resetButtonIsEnabled() {
		return resetButton.isEnabled();
	}
	public void searchSubCategoryDataProvider(String category, String subCategory) {
		clickOnSearchIcon();
		selectCategory(category);
		enterSubCategory(subCategory);
		clickonSearchButtobRed();
	}
	public void addingNewSubcategoryWithImage(String category,String subCategory) {
		newButton.click();
		selectCategory(category);
		enterSubCategory(subCategory);
		imageFileButton.sendKeys(Constants.IMAGEFILE_PATH);
		saveButton.click();
	}
	public void clickDeleteSubcategoryDetails() {
		WaitUtility waitutility=new WaitUtility(driver);
		waitutility.waitForElementToBeClickable(deleteButton, 20);
		deleteButton.click();
		driver.switchTo().alert().accept();
	}
	public String subcategoryDeletedSuccessfullyMessageDeletion() {
		return generalutility.getTextValue(alertDeletion);
	}
	
}
