package com.sis.generic.listnerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sis.generic.webdriverutility.ThreadLocalUtility;

public class ListenerImplementation implements ISuiteListener, ITestListener{
	public ExtentReports report;
	public ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		String suitename = suite.getName();
		
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvancedReport/SalesAndInventorySystem_"+suitename+"_"+time+"_report");
		spark.config().setDocumentTitle("Sales and inventory system "+suitename+"_result");
		spark.config().setReportName("Sales and inventory system "+suitename+"_report");
		spark.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows10");
		report.setSystemInfo("browser", "chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		 report.flush();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		test=report.createTest(testName);
		test.log(Status.INFO, testName+" execution started");
		ThreadLocalUtility.setTest(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		test.log(Status.PASS, testName+"execution is successful");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		
		TakesScreenshot screenshot = (TakesScreenshot)ThreadLocalUtility.getDriver();
		String file = screenshot.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(file,testName+""+time+"errorFile");
		test.log(Status.FAIL, testName+"execution failed");
		test.log(Status.INFO, result.getThrowable());
		 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		test.generateLog(Status.SKIP, testName+"execution skipped");
		test.log(Status.INFO, result.getThrowable());

	}

	
	

}
