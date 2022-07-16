package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class Tc_001_AccountRegistrationPage extends BaseClass {

	@Test(groups= {"regression","master"})
	public void test_account_Registration() throws InterruptedException, IOException {
		try
		{
		logger.info("Starting Tc_001_AccountRegistrationPage");
		driver.get(rb.getString("appURL"));
		logger.info("opened url");
	driver.manage().window().maximize();
	
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	logger.info("clicked My ACcount");
	hp.clickRegister();
	logger.info("Clicked Register");
	AccountRegistrationPage repage=new AccountRegistrationPage(driver);
	repage.setFirstName("Sony");
	logger.info("Provided FirstName");
	
	repage.setLastName("mamidi");
	logger.info("Provided LastName");
	repage.setEmail(randomeString()+"@gmail.com");
	logger.info("Provided Email");
	repage.setPassword("oiuyt");
	logger.info("Provided Password");
	//repage.clickRadiobtn();
	repage.setPrivacy();
	logger.info("Clicked on privacy");
	repage.clickContinue();
	logger.info("Clicked on Continue");
		}  // close bracket of try block
		catch(Exception e) 
		{
			logger.error("Account Registration failed");
			Assert.fail();
		}
		captureScreen(driver,"test_account_Registration");
	
	logger.info("Finished Tc_001_AccountRegistrationPage");
	}
	
	}


