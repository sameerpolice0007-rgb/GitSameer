package TestComponents;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReporterNG;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;

public class TestListneres extends BaseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal extentTest = new ThreadLocal();
	public void onTestStart(ITestResult result) {
		extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, "Test PAssed");
	}
	
	
public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File filePath = null;
		try {
			 filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromBase64String((result.getMethod().getMethodName()));
	}

public void onFinish(ITestContext context) {
	
	extent.flush();
}
	
	
	

}
