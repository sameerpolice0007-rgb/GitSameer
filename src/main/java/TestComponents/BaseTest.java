package TestComponents;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseTest {
	public WebDriver driver;
	public LandingPageObject landingPage;
	
	public WebDriver initializerDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		//String browserName = prop.getProperty("browser");
		
		
		if(browserName.contains("chrome")){
			
		ChromeOptions options= new ChromeOptions();
		if(browserName.contains("headless")) {
		options.addArguments("headless");
		}
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver(options);
		
	}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	
public List<HashMap<String, String>> getJsonDataToMap(String FilePath) throws IOException {
		
		//Readfiles to string
		
		String jsonContent = FileUtils.readFileToString(new File(FilePath), StandardCharsets.UTF_8);
	//String to HashMap  //Jackson data dependency 
		
		ObjectMapper mapper = new  ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
			
		});
		return data;

	
	}

public File getScreenshot(String testCaseName, WebDriver driver) throws IOException {
	
	  TakesScreenshot ts =(TakesScreenshot)driver;
	 File source =  ts.getScreenshotAs(OutputType.FILE);
	 File file = new File(System.getProperty("user.dir")+ "//report" + testCaseName + ".png");
	 FileUtils.copyFile(source, file);
	 return file;
	}
	@BeforeMethod(alwaysRun=true)
	public LandingPageObject LaunchApplication() throws IOException {
		
		driver = initializerDriver();
		landingPage = new LandingPageObject(driver);
		landingPage.goTo();
		return landingPage;
}

	@AfterMethod(alwaysRun=true)
public void TearDown() {
	
	driver.close();
}
}
