package frameworktutorial.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import frameworktutorial.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)//A constructor, the first block of code to be executed in this class
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}

	//List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	
	public Boolean VerifyProductsDisplay(String productName)
	{
	Boolean match =  cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
	return match;
	}
	
	public void goToCheckout()
	{
		checkoutEle.click();

	}
	
	
	
	

}
