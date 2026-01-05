package StepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestComponents.BaseTest;
import TestComponents.LandingPageObject;
import TestComponents.ProductCatalog;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination extends BaseTest{
	public LandingPageObject landPageObject;
	public ProductCatalog productCatalog;
	
	@Given("I landed on Ecommerce page")
	public void StepDefImpl() throws IOException {
		
		//code
		landPageObject = LaunchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String userName, String pwd) {
		
	productCatalog = landPageObject.LoginApplication(userName,pwd);
		
		//landingPage.LoginApplication(userName,pwd);
		
	}
	
	@When("^I add product (.*) from cart$")
	public void I_add_product_from_cart(String productName) {
		List<WebElement> products = productCatalog.getProductLists();
		productCatalog.addProductToCart(productName);
		
		
	}
	
	@Then("^\"([^\"]*)\" message is displayed$")
	public void something_message_is_displayed(String StrArg1) {
		
		Assert.assertEquals(StrArg1, landingPage.getErrorMsg());
		driver.close();
	}
}
