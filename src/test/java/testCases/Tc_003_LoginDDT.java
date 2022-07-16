package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class Tc_003_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData")
	public void test_LoginDDT(String email,String pwd,String exp) {
		logger.info("Starting Tc_003_LoginDDT");
		try
		{
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
		lp.setEmail(email);
		logger.info("provided email");
		lp.setPassword(pwd);
		logger.info("Provided Password");
		lp.clickLogin();
		logger.info("clicked on login ");
		
		/*boolean targetPage=lp.isMyAccountPageExists();
		 if(exp.equals("valid")) 
		 {
		if(targetPage==true) 
		{
			logger.info(" Login success");
			MyAccountPage myaccpage=new MyAccountPage(driver);  // here iam not created logout MyAccountPage  page object ..because it was not displayed 
			myaccpage.clickLogOut();
			Assert.assertTrue(true);
		}
		else {
			logger.info(" login Failed");
			captureScreen(driver,"test_login");
			Assert.assertTrue(false);
		}
		 }
		if(exp.equals("invalid")) {
			if(targetPage==true) {
				MyAccountPage myaccpage=new MyAccountPage(driver);
				myaccpage.clickLogOut();
				Assert.assertTrue(false);
			}
			else {
				logger.info("login failed");
				Assert.assertTrue(true);
			}
				
			}*/
		}
		
		catch(Exception e) {
			logger.fatal("Login Failed");
			Assert.fail();
		}
		logger.info(" Finished Tc_003_LoginDDT ");
	}
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";
		
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  //1
		{		
			for(int j=0;j<totalcols;j++)  //0
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return logindata;
				
	}
	}
	

	


