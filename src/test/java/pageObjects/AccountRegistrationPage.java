package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage {

	WebDriver driver;

	public AccountRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "firstname")
	WebElement txtFirstName;

	@FindBy(name = "lastname")
	WebElement txtLastName;

	@FindBy(name = "email")
	WebElement txtEmail;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(name = "newsletter")
	WebElement radiobtn;

	@FindBy(xpath = "//div[@class='d-inline-block pt-2 pd-2 w-100']//input[@type='checkbox']")
	WebElement txtchkBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement txtContbtn;

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String Lname) {
		txtLastName.sendKeys(Lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	// public void clickRadiobtn() {
	// radiobtn.click();
	// }

	public void setPrivacy() {
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", txtchkBox); 
	}

	public void clickContinue() throws InterruptedException {
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", txtContbtn);
	}
}
