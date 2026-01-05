package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponentsDemo {
	
	WebDriver driver;
  public AbstractComponentsDemo(WebDriver driver) {
	  this.driver=driver;
		
	}

  public void waitElementToAppear(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
}
  
  public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
}
