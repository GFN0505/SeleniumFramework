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

public class OrdersPage extends AbstractComponents{
	
	WebDriver driver;
	
	public OrdersPage(WebDriver driver)//A constructor, the first block of code to be executed in this class
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}

	
	
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productNames;
	
	
	public Boolean VerifyOrderDisplay(String productName)
	{
	Boolean match =  productNames.stream().anyMatch(product-> product.getText().equalsIgnoreCase(productName));
	return match;
	}
	
	
	
	

}
