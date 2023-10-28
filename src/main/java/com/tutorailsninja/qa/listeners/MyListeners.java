package com.tutorailsninja.qa.listeners;

import java.io.IOException;
import com.tutorialsninja.qa.utilities.utilities;

import java.awt.Desktop;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Date;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utilities.ExtentReporter;
import com.tutorialsninja.qa.utilities.utilities;

public class MyListeners implements ITestListener{
	ExtentReports extentReport;
	ExtentTest extentTest;
	String testName;
	
	@Override
	public void onStart(ITestContext context) {

		try {
			extentReport=ExtentReporter.generatedExentReport();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		testName=result.getMethod().getMethodName();
		extentTest= extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName+ " started exceuting");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		testName=result.getMethod().getMethodName();
		extentTest.log(Status.PASS, testName+ " got successfully exceutited");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		testName=result.getMethod().getMethodName();
        WebDriver driver=null;
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		String path=utilities.captureScreenshot(driver,testName);
        extentTest.addScreenCaptureFromPath(path);
        extentTest.log(Status.INFO, result.getThrowable());
         extentTest.log(Status.FAIL, testName+" got failed");
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
     testName=result.getMethod().getMethodName();
      extentTest.log(Status.INFO, result.getThrowable());
	  extentTest.log(Status.SKIP, testName+" got skipped");    
	}


	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		
		String pathOfExtentReport= System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File extentReportFile=new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReportFile.toURI());//auto launching of extent reports
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

	
}
