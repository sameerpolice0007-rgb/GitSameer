package SeleniumData;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestComponents.LandingPageObject;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/client");
		LandingPageObject landingPage = new LandingPageObject(driver);
		driver.findElement(By.id("userEmail")).sendKeys("jackthesparrow0071@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("#Sameerpolice1");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	

		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
	    prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	    
	   // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
	    driver.findElement(By.cssSelector("([routerlink*='cart'])"));
	
	}

}
