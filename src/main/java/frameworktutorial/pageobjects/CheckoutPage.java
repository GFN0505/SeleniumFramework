package frameworktutorial.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import frameworktutorial.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)//A constructor, the first block of code to be executed in this class
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}

	
	
	//driver.findElement(By.cssSelector("[placeholder='Select Country']"))
	@FindBy(css="[placeholder='Select Country']")
	WebElement countrySelect;
	
	@FindBy(xpath="(//button[contains(@class, 'ta-item')])[2]")
	WebElement selectedCountry;
	
	@FindBy(css=".action__submit")
	WebElement submitCheckout;
	
	By results = By.cssSelector(".ta-result");
	
	
	
	public void selectCountry(String countryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(countrySelect, countryName).build().perform();
		//waitForElementToAppear(results);
		selectedCountry.click();
		submitCheckout.click();

	}
	
	public void submitOrder()
	{
		submitCheckout.click();
	}
	
	
	
	

}
