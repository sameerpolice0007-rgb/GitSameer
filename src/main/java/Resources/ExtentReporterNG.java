package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject() {
		
		//ExtentRepports class, ExtentSparkReporter class
				String path = System.getProperty("suer.dir")+ "\\reports\\index.html";
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				reporter.config().setReportName("Web Automation Results");
				reporter.config().setDocumentTitle("Test Results");
			    ExtentReports extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Sameer");
				return extent;

	}

}
