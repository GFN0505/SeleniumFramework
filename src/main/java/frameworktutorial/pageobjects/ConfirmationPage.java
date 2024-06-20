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

public class ConfirmationPage extends AbstractComponents{
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver)//A constructor, the first block of code to be executed in this class
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}

	
	
	//driver.findElement(By.cssSelector(".hero-primary"))
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	


	
	
	
	public String getConfirmationMessage()
	
	{
		return confirmationMessage.getText();
		
	}
	
	
	
	

}
