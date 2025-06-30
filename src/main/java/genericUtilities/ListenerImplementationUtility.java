package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITListener interface of TestNG
 * @author NR
 */
public class ListenerImplementationUtility implements ITestListener{

	ExtentReports report; // basic configuration
	
	ExtentTest test; // monitor the scripts
	
	
	@Override
	public void onTestStart(ITestResult result) {
		// Trying to capture current method name getting executed.
		String methodName = result.getMethod().getMethodName(); 
		System.out.println(methodName+ "- Test Execution Stared");
		
		//create test in extent reports
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// Trying to capture current method name getting executed.
		String methodName = result.getMethod().getMethodName(); 
		System.out.println(methodName+ "- Test PASS");
		
		//Log the test status as PASS in extent reports
		test.log(Status.PASS, methodName+ "-Test PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// Trying to capture current method name getting executed.
		String methodName = result.getMethod().getMethodName(); 
		System.out.println(methodName+ "- Test FAIL");
		
		//Log the test status as FAIL in extent reports
		test.log(Status.FAIL, methodName+ "-Test FAIL");
		
		//Capture the exception
		System.out.println(result.getThrowable());
		
		//Log the exception in extent reports
		test.log(Status.WARNING, result.getThrowable());
		
		//Capture the Screenshot
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
		
		
		//Configure ScreenshotName
		String screenshotName = methodName +"-" +j.getSystemDate();
		try {
			
		String path = 	s.captureScreenshot(BaseClass.sdriver, screenshotName);
		
		//Attach the screenshot to extent reports
		test.addScreenCaptureFromPath(path, screenshotName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// Trying to capture current method name getting executed.
		String methodName = result.getMethod().getMethodName(); 
		System.out.println(methodName+ "- Test SKIP");
		
		//Log the test status as SKIP in extent reports
		test.log(Status.SKIP, methodName);
		
		//Capture the exception
		System.out.println(result.getThrowable());
		
		//Log the exception in extent reports
		test.log(Status.WARNING, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite Execution Stared");
		
		//Basic Settings of Extent Report
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Report - "+new JavaUtility().getSystemDate()+".html");
		esr.config().setDocumentTitle("Swags Lab Execution Report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Swags Lab Automation Framework Execution");
		
		
		//Configure ExtentReports
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Environment", "Test Environment");
		report.setSystemInfo("Reporter Name", "Neethu Rajendran");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite Execution Finished");
		
		//Generate the Report
		report.flush();
	}

	
	
}
