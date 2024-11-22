package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
//import com.sevenrmartsupermarket.tests.WebDriverWait;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;
	Properties properties=new Properties();
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement userNameField;
	@FindBy(xpath="//input[@type='password']")
	private WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement signInButton;
	@FindBy(xpath="//div[@class='login-box']//h5[contains(text(),' Alert!')]")
	private WebElement invalidLoginAlert;
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement checkbox;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream ip=new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void enterUserName(String username) {
		userNameField.sendKeys(username);
	
	}
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	public void clickSignInButton() {
		signInButton.click();
	}
	public void login(String userName,String password) {
		enterUserName(userName);
		enterPassword(password);
		clickSignInButton();	
	}
	public void login() {
		String userName=properties.getProperty("username");
		String passWord=properties.getProperty("password");
		enterUserName(userName);
		enterPassword(passWord);
		clickSignInButton();
	}
	public boolean signInButtonEnabled() {
		
		return signInButton.isEnabled();
	}
	public boolean checkBoxEnabled() {
		return checkbox.isEnabled(); 
	}
	public String getAlertText() {
		GeneralUtility generalutility=new GeneralUtility();
		return invalidLoginAlert.getText();
	}
}
