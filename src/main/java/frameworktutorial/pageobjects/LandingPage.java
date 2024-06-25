package frameworktutorial.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import frameworktutorial.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)//A constructor, the first block of code to be executed in this class
	{
		super(driver); //This sends driver to the parent class 
		
		this.driver= driver;
		PageFactory.initElements(driver, this);//This allows for replacement of driver.findElementB y
		
	}

	//WebElement userEmail = 	driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(id="login")
	WebElement submit;
	
	
	@FindBy(css="div[aria-label='Incorrect email or password.']")
	WebElement loginErrorMessage;
	
	
	public void loginApplication(String email, String password)//Action methods
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
	}
	
	public String getLoginErrorMessage()
	{
		waitForWebElementToAppear(loginErrorMessage);
		return loginErrorMessage.getText();
		
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}
