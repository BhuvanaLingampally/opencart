package testCases;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class Tc_002_Login extends BaseClass{
@Test(groups= {"sanity","master"})
public void test_login() throws IOException {
	try
	{
	logger.info("Starting Tc_002_Login");
	driver.get(rb.getString("appURL"));
	logger.info("Opened URL");
	driver.manage().window().maximize();
	logger.info("Maximized window");
	
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	logger.info("clicked on My Account");
	hp.clickLogin();
	logger.info("clicked on Login");
	
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(rb.getString("email"));
	logger.info("Provided Email");
	lp.setPassword(rb.getString("password"));
	logger.info("Provided Password");
	lp.clickLogin();
	logger.info("clicked on login ");
	
	/*boolean targetPage=lp.isMyAccountPageExists();
	if(targetPage) {
		logger.info(" Login success");
		Assert.assertTrue(true);
	}
	else {
		logger.info(" login Failed");
		captureScreen(driver,"test_login");
		Assert.assertTrue(false);
	}*/
	}
	catch(Exception e) {
		logger.fatal("Login Failed");
		Assert.fail();
	}
	logger.info(" Finished Tc_002_Login ");
}
}
