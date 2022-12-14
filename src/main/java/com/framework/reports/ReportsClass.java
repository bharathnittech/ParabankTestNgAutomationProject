package com.framework.reports;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.framework.commons.WebCommons;

public class ReportsClass {

	// This class will have common methods to generate customized test results
	// report by using extent reports

	public static ExtentReports extent = null; // Class to create new blank html report
	public static ExtentTest logger = null; // Class to print messages

	@BeforeSuite(alwaysRun = true)
	public static void setupReport() {
		ExtentHtmlReporter html = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "\\Reports\\AutomationReport" + new WebCommons().uniqueId() + ".html");
		extent = new ExtentReports();
		extent.attachReporter(html);
		extent.setSystemInfo("Project Name", "Parabank");
		extent.setSystemInfo("Developer", "Bharath");
	}

	public static void startReportingForTestCase(String testname) {
		logger = extent.createTest(testname);
	}

	public static void stopReporting() {
		extent.flush();
	}

}
