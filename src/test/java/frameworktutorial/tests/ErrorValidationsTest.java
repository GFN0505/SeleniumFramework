package frameworktutorial.tests;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import frameworktutorial.TestComponents.BaseTests;
import frameworktutorial.pageobjects.CartPage;
import frameworktutorial.pageobjects.CheckoutPage;
import frameworktutorial.pageobjects.ConfirmationPage;
import frameworktutorial.pageobjects.LandingPage;
import frameworktutorial.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationsTest extends BaseTests{
	
	
	@Test
	public void LoginErrorValidation() throws IOException, InterruptedException {
		
		landingPage.loginApplication("anshika@gmail.com", "Iamki@000");
		Assert.assertEquals("Incorrect email password.", landingPage.getLoginErrorMessage());
	}
	

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";
		String countryName = "india";

		
		landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
		
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductTocart(productName);
		
		Thread.sleep(10000);
		
		productCatalogue.goToCartPage();
		
		//to confirm the added product is in the cart
		CartPage cartPage = new CartPage(driver);
		Boolean match = cartPage.VerifyProductsDisplay(countryName);
		Assert.assertFalse(match);
		
		
	}

}
