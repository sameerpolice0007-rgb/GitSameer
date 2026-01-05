package SeleniumData;
import java.io.File;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import TestComponents.ProductCatalog;


public class Demo extends BaseTest {

	@Test(dataProvider="getData")
	public void demoTest(HashMap<String,String> input) throws IOException {
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";
		
//		LandingPageObject landingPage = LaunchApplication();
//		landingPage.goTo();
		landingPage.LoginApplication(input.get("email"), input.get("pwd"));
		Assert.assertEquals("Incorrect email and  password",landingPage.getErrorMsg() );
		ProductCatalog productCatalog = new ProductCatalog(driver);
		List<WebElement> products = productCatalog.getProductLists();
		productCatalog.addProductToCart(productName);

		
	    
	    
	   // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
//	    driver.findElement(By.cssSelector("([routerlink*='cart'])"));
	
	}
	
//	public File getScreenshot(String testCaseName) throws IOException {
//		
//	  TakesScreenshot ts =(TakesScreenshot)driver;
//	 File source =  ts.getScreenshotAs(OutputType.FILE);
//	 File file = new File(System.getProperty("user.dir")+ "//report" + testCaseName + ".png");
//	 FileUtils.copyFile(source, file);
//	 return file;
//	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email",  "jackthesparrow0071@gmail.com");
//		map.put("pwd", "#Sameerpolice1");
//		
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email",  "jackthesparrow0071@gmail.com");
//		map1.put("pwd", "#Sameerpolice1");
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\DataPackage\\PurchaseOrder.json");
		
		return new Object[][]     {{data.get(0)},{data.get(1)}};
		
	}
	

}
