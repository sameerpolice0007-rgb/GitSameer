package TestComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponentsDemo;

public class LandingPageObject extends AbstractComponentsDemo {

	WebDriver driver;
	public LandingPageObject(WebDriver driver) {
		//initia;ization
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page factory 
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css= "[class*= 'flyInout']")
	WebElement errorMessage;
	
	public ProductCatalog LoginApplication(String mail, String PWD) {
		userEmail.sendKeys(mail);
		userPassword.sendKeys(PWD);
		submit.click();
		return new ProductCatalog(driver);
	}
	
	public WebElement getErrorMsg() {
		waitForWebElementToAppear(errorMessage);
		errorMessage.getText();
		return errorMessage;
		
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}
}
