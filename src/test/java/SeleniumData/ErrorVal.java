package SeleniumData;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import TestComponents.LandingPageObject;


public class ErrorVal extends BaseTest {

	@Test(groups ={"ErrorHandling"})
	public void demoTest() throws IOException {
		// TODO Auto-generated method stub
//		String productName = "ZARA COAT 3";
//		
//		LandingPageObject landingPage = LaunchApplication();
//		landingPage.goTo();
		landingPage.LoginApplication("jackthesparrow0071@gmail.com", "#Sameerpolice");
		Assert.assertEquals("Incorrect email password",landingPage.getErrorMsg() );
//		ProductCatalog productCatalog = new ProductCatalog(driver);
//		List<WebElement> products = productCatalog.getProductLists();
//		productCatalog.addProductToCart(productName);

		
	    
	    
	   // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
//	    driver.findElement(By.cssSelector("([routerlink*='cart'])"));
	
	}

}
