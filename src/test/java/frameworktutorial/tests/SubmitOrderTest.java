package frameworktutorial.tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import frameworktutorial.pageobjects.OrdersPage;
import frameworktutorial.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTests{
	
	
	String productName = "ZARA COAT 3";
	String countryName = "india";
	
	@Test(dataProvider = "getData", groups = {"Purchase"})
	public void submitOrder(HashMap<String,String>input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
			
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.loginApplication(input.get("email"), input.get("password"));
		
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductTocart(input.get("productName"));
		
		Thread.sleep(10000);
		
		productCatalogue.goToCartPage();
		
		//to confirm the added product is in the cart
		CartPage cartPage = new CartPage(driver);
		Boolean match = cartPage.VerifyProductsDisplay(input.get("productName"));
		Assert.assertTrue(match);
		
		cartPage.goToCheckout();
		
		CheckoutPage checkoutPage = new CheckoutPage (driver);
		checkoutPage.selectCountry(countryName);
		checkoutPage.submitOrder();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-result")));
		
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		String confirmMessage = confirmationPage.getConfirmationMessage();
		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(confirmMessage);
		
	}
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest()
	{
		landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
		OrdersPage ordersPage =  new OrdersPage(driver);
		ordersPage.goToOrdersPage();
		Assert.assertTrue( ordersPage.VerifyOrderDisplay(productName));
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		//HashMap<String,String> map = new HashMap<String,String>();
		//map.put("email", "anshika@gmail.com");
		//map.put("password", "Iamking@000");
		//map.put("productName", "ZARA COAT 3");
		
		//HashMap<String,String> map1 = new HashMap<String,String>();
		//map1.put("email", "shetty@gmail.com");
		//map1.put("password", "Iamking@000");
		//map1.put("productName", "ADIDAS ORIGINAL");
		
		List<HashMap<String, String>> data = getJsondataToMap(System.getProperty("user.dir") + "/src/test/java/frameworktutorial/data/PurchaseOrder.json");
		
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}

}
