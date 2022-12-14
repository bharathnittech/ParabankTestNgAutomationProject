package com.framework.liseners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.framework.commons.WebCommons;
import com.framework.reports.ReportsClass;

public class TestListener extends ReportsClass implements ITestListener {

	// This class will have methods to perform specific actions based test execution And test results	

	public void onTestStart(ITestResult result) {
		startReportingForTestCase(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.pass(result.getMethod().getMethodName()+" Is Successfully Executed");
		stopReporting();
	}

	public void onTestFailure(ITestResult result) {
		logger.fail(result.getMethod().getMethodName()+" is Failed");
		logger.fail(result.getThrowable().getMessage());
		String path = new WebCommons().takeScreenshotOfWindow(result.getMethod().getMethodName());
		try {
			logger.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		stopReporting();
	}

}
