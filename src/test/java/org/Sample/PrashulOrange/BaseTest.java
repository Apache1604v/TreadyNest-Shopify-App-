package org.Sample.PrashulOrange;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest {
	
	protected static ExtentReports reports;
	protected static ExtentTest ETtest;
		
		
		@BeforeSuite
		public void SetUp()
		{
			ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/ETReports/ExtentReportResults.html");

			// Configure the report
			htmlReporter.config().setDocumentTitle("Automation Test Report"); 
			htmlReporter.config().setReportName("Regression Test Results");        
			htmlReporter.config().setTheme(Theme.STANDARD);         
			htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
			 
			
			reports = new ExtentReports();
			reports.attachReporter(htmlReporter);
			
			   // Add system info
			reports.setSystemInfo("Tester Name", "Prashul D");
			reports.setSystemInfo("Region", "INDIA");
			reports.setSystemInfo("Organization", "TrendyNest");
			reports.setSystemInfo("Environment", "Production");
			reports.setSystemInfo("Browser", "Chrome");
			reports.setSystemInfo("OS", System.getProperty("os.name"));
			reports.setSystemInfo("Java Version", System.getProperty("java.version"));
	        
			// You can add more custom fields as needed
			reports.setSystemInfo("Project Name", "TREANDY NEST");
			reports.setSystemInfo("Release Version", "1.0.0");
			reports.setSystemInfo("Sprint", "Sprint 1");
		}
		
		@AfterSuite
		public void tearDown()
		{
			reports.flush();
		}


}
