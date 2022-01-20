package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.TestBase;import net.bytebuddy.asm.Advice.This;
import utilities.TestBaseUtill;

public class GmailLoginPage extends TestBase{
	
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement btnSignIn;
	
	@FindBy(xpath = "//input[@id='identifierId' and @type='email']")
	WebElement EleGmail;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement btnNext;
	
	@FindBy(xpath = "//input[@aria-label='Enter your password']")
	WebElement ElePassword;
	
	@FindBy(xpath = "//div[@class='o6cuMc']")
	WebElement error;
	
	@FindBy(xpath = "//div[@class='OyEIQ uSvLId']//div[@jsname='B34EJ']")
	WebElement passwordError;
	
	public GmailLoginPage() {
		super();
		PageFactory.initElements(driver, this);	
	}
	
	public void openGmailUrl() {
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(TestBaseUtill.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public String validatingPageTitle() {
		return driver.getTitle();		
	}
	
	public void clickToSignIn() {
		btnSignIn.click();
	}
	
	public void gmailLogin(String gmail) throws InterruptedException {
		EleGmail.sendKeys(gmail);
		//EleGmail.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		btnNext.click();
	}
	
	public void passwordLogin(String password) throws InterruptedException {
		ElePassword.sendKeys(password);
		//ElePassword.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		btnNext.click();
		
	}
	public String Error() {
		String actualError = error.getText().toString();
		return actualError;
	}
	
	public String wrongPassword() {
		String actualError = passwordError.getText().toString();
		return actualError;
	}
}
