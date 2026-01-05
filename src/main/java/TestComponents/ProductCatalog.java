package TestComponents;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponentsDemo;

public class ProductCatalog extends AbstractComponentsDemo{

	WebDriver driver;
	public ProductCatalog(WebDriver driver) {
		//initiaization
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Page factory 
	
	@FindBy(id=".mb-3")
	List<WebElement> products;
	
	By productsList= By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	
	public List<WebElement> getProductLists() {
		
		waitElementToAppear(productsList);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		WebElement prod = getProductLists().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		return prod;
		
	}
	
	public void addProductToCart(String productName) {
		
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();		
		
	}
	
}
