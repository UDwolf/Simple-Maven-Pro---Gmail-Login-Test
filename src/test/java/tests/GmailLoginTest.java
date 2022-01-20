package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClass.TestBase;
import pages.GmailLoginPage;
import utilities.ExtentManager;
import utilities.TestBaseUtill;

public class GmailLoginTest extends TestBase{
	
	GmailLoginPage gp = new GmailLoginPage();
	TestBaseUtill td = new TestBaseUtill();
	//Logger print = Logger.getLogger("devpinoyLogger");
	ExtentReports reports;
	ExtentTest test;
	File srcFile;
	
	
	public GmailLoginTest() {
		super();
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		gp.openBrowser();
		gp.openGmailUrl();
		reports = ExtentManager.getReports();
	}
	

	@AfterMethod
	public void afterMethod() throws IOException {
		gp.closeBrowser();
		reports.flush();
	}
	
	@Test(priority = 1, groups = "smoke")
	public void LoginWithCorrectEmailAndPassword() throws InterruptedException, IOException {
		//Thread.sleep(2000);
		test = reports.createTest("Login With Correct Email And Password");
		String actualGmailMainPageTitle = gp.validatingPageTitle();
		String expectedGmailMainPageTitle = TestBaseUtill.GMAIL_MAIN_PAGE_TITLE;
		Assert.assertEquals(actualGmailMainPageTitle, expectedGmailMainPageTitle);
		test.log(Status.INFO, "Validated Gmail Main Page");
		//Thread.sleep(2000);
		
		gp.clickToSignIn();
		//Thread.sleep(2000);
		
		String actualSignUpPageTitle = gp.validatingPageTitle();
		String expectedSignUpPageTitle = TestBaseUtill.GMAIL_SIGNIN_PAGE_TITLE;
		Assert.assertEquals(actualSignUpPageTitle, expectedSignUpPageTitle);
		test.log(Status.INFO, "Validated Gmail SignIn Page");
			
		gp.gmailLogin(td.EMAIL_RIGHT);
		test.log(Status.INFO, "On password Page");
		Thread.sleep(2000);
		
		gp.passwordLogin(td.PASSWORD_RIGHT);
		Thread.sleep(2000);
		
		String actualInboxPageTitle = gp.validatingPageTitle();
		System.out.println(actualInboxPageTitle);
		Assert.assertTrue(actualInboxPageTitle.contains(td.EMAIL_RIGHT.toString()),"Pass");
		
		srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(srcFile, new File("C:\\Selenium_Workspace\\SimpleMavenProSeleniumTest\\ScreenShot\\sc1.png"));
		test.addScreenCaptureFromPath("C:\\Selenium_Workspace\\SimpleMavenProSeleniumTest\\ScreenShot\\sc1.png");	
	}
	
	
	@Test(priority = 2, groups = "regration")
	public void LoginWithNonExistingEmailTest() throws InterruptedException, IOException {
		//Thread.sleep(2000);
		test = reports.createTest("Login With Non-Existing Email");
		
		String actualGmailMainPageTitle = gp.validatingPageTitle();
		String expectedGmailMainPageTitle = td.GMAIL_MAIN_PAGE_TITLE;
		Assert.assertEquals(actualGmailMainPageTitle, expectedGmailMainPageTitle);
		
		//Thread.sleep(2000);
		
		gp.clickToSignIn();
		//Thread.sleep(2000);
		
		String actualSignUpPageTitle = gp.validatingPageTitle();
		String expectedSignUpPageTitle = td.GMAIL_SIGNIN_PAGE_TITLE;
		Assert.assertEquals(actualSignUpPageTitle, expectedSignUpPageTitle);
				
		gp.gmailLogin(td.EMAIL_NON_EXISTING);
		String expectedError = td.ERROR_NOT_FIND_ACCOUNT;
		System.out.println(expectedError);
		
		String actualError = gp.Error();
		Assert.assertEquals(actualError, expectedError,"Pass");	
		
		srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(srcFile, new File("C:\\Selenium_Workspace\\SimpleMavenProSeleniumTest\\ScreenShot\\sc2.png"));
		test.addScreenCaptureFromPath("C:\\Selenium_Workspace\\SimpleMavenProSeleniumTest\\ScreenShot\\sc2.png");
		
	}
	
	@Test(priority = 3, groups = "regration")
	public void LoginWithCorrectEmailAndWrongPassword() throws InterruptedException, IOException {
		//Thread.sleep(2000);
		test = reports.createTest("Login With Correct Email And Wrong Password");
		
		String actualGmailMainPageTitle = gp.validatingPageTitle();
		String expectedGmailMainPageTitle = TestBaseUtill.GMAIL_MAIN_PAGE_TITLE;
		Assert.assertEquals(actualGmailMainPageTitle, expectedGmailMainPageTitle);
		
		//Thread.sleep(2000);
		
		gp.clickToSignIn();
		//Thread.sleep(2000);
		
		String actualSignUpPageTitle = gp.validatingPageTitle();
		String expectedSignUpPageTitle = TestBaseUtill.GMAIL_SIGNIN_PAGE_TITLE;
		Assert.assertEquals(actualSignUpPageTitle, expectedSignUpPageTitle);
				
		gp.gmailLogin(td.EMAIL_RIGHT);
		System.out.println("After Email Page");
		//print.debug("After Email Page");
		Thread.sleep(2000);
		
		gp.passwordLogin(td.PASSWORD_WRONG);
		String expectedError = td.ERROR_WRONG_PASSWORD;
		System.out.println(expectedError);
		String actualError = gp.wrongPassword();
		Assert.assertEquals(actualError, expectedError,"Pass");	
		
		srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(srcFile, new File("C:\\Selenium_Workspace\\SimpleMavenProSeleniumTest\\ScreenShot\\sc3.png"));
		test.addScreenCaptureFromPath("C:\\Selenium_Workspace\\SimpleMavenProSeleniumTest\\ScreenShot\\sc3.png");
	}
	
	@Test(priority = 4, groups = "regration")
	public void LoginWithSpecialCharacterEmail() throws InterruptedException, IOException {
		//Thread.sleep(2000);
		test = reports.createTest("Login With Special Character Email");
		
		String actualGmailMainPageTitle = gp.validatingPageTitle();
		String expectedGmailMainPageTitle = td.GMAIL_MAIN_PAGE_TITLE;
		Assert.assertEquals(actualGmailMainPageTitle, expectedGmailMainPageTitle);
		
		//Thread.sleep(2000);
		
		gp.clickToSignIn();
		//Thread.sleep(2000);
		
		String actualSignUpPageTitle = gp.validatingPageTitle();
		String expectedSignUpPageTitle = td.GMAIL_SIGNIN_PAGE_TITLE;
		Assert.assertEquals(actualSignUpPageTitle, expectedSignUpPageTitle);
				
		gp.gmailLogin(td.EMAIL_SPECIAL_CHAR);
		String expectedError = td.ERROR_INVELID_EMAIL;
		System.out.println(expectedError);
		
		String actualError = gp.Error();
		Assert.assertEquals(actualError, expectedError, "Pass");		
		
		srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(srcFile, new File("C:\\Selenium_Workspace\\SimpleMavenProSeleniumTest\\ScreenShot\\sc4.png"));
		test.addScreenCaptureFromPath("C:\\Selenium_Workspace\\SimpleMavenProSeleniumTest\\ScreenShot\\sc4.png");
		
	}
	
	@Test(priority = 5, groups = "regration")
	public void LoginWithCurrectYahooEmailID() throws InterruptedException, IOException {
		//Thread.sleep(2000);
		test = reports.createTest("Login With Correct Yahoo Email");
		
		String actualGmailMainPageTitle = gp.validatingPageTitle();
		String expectedGmailMainPageTitle = td.GMAIL_MAIN_PAGE_TITLE;
		Assert.assertEquals(actualGmailMainPageTitle, expectedGmailMainPageTitle);
		
		//Thread.sleep(2000);
		
		gp.clickToSignIn();
		//Thread.sleep(2000);
		
		String actualSignUpPageTitle = gp.validatingPageTitle();
		String expectedSignUpPageTitle = td.GMAIL_SIGNIN_PAGE_TITLE;
		Assert.assertEquals(actualSignUpPageTitle, expectedSignUpPageTitle);
				
		gp.gmailLogin(td.EMAIL_YAHOO);
		String expectedError = td.ERROR_NOT_FIND_ACCOUNT;
		System.out.println(expectedError);
		
		String actualError = gp.Error();
		Assert.assertEquals(actualError, expectedError, "Pass");	
		
		srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(srcFile, new File("C:\\Selenium_Workspace\\SimpleMavenProSeleniumTest\\ScreenShot\\sc5.png"));
		test.addScreenCaptureFromPath("C:\\Selenium_Workspace\\SimpleMavenProSeleniumTest\\ScreenShot\\sc5.png");
		
	}
	
	@Test(priority = 6, groups = "regration")
	public void LoginWithGoogleConnectedAccountEmailID() throws InterruptedException, IOException {
		//Thread.sleep(2000);
		test = reports.createTest("Login With Google connected Account Email");
		
		String actualGmailMainPageTitle = gp.validatingPageTitle();
		String expectedGmailMainPageTitle = TestBaseUtill.GMAIL_MAIN_PAGE_TITLE;
		Assert.assertEquals(actualGmailMainPageTitle, expectedGmailMainPageTitle);
		
		//Thread.sleep(2000);
		
		gp.clickToSignIn();
		//Thread.sleep(2000);
		
		String actualSignUpPageTitle = gp.validatingPageTitle();
		String expectedSignUpPageTitle = TestBaseUtill.GMAIL_SIGNIN_PAGE_TITLE;
		Assert.assertEquals(actualSignUpPageTitle, expectedSignUpPageTitle);
				
		gp.gmailLogin(td.EMAIL_GOOGLE_CONNECTED);
		System.out.println("After Email Page");
		//print.debug("After Email Page");
		Thread.sleep(2000);
		
		gp.passwordLogin(td.PASSWORD_RIGHT_GOOGLE_CONNECTED);
		System.out.println("After Password Page");
		//print.debug("After Password Page");
		Thread.sleep(2000);
		
		String actualInboxPageTitle = gp.validatingPageTitle();
		System.out.println("Title = "+ actualInboxPageTitle);
		//print.debug(actualInboxPageTitle);
		Assert.assertTrue(actualInboxPageTitle.contains(td.EMAIL_GOOGLE_CONNECTED),"Pass");
		
		srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(srcFile, new File("C:\\Selenium_Workspace\\SimpleMavenProSeleniumTest\\ScreenShot\\sc6.png"));
		test.addScreenCaptureFromPath("C:\\Selenium_Workspace\\SimpleMavenProSeleniumTest\\ScreenShot\\sc6.png");	
	}
}
