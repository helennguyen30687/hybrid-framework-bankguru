package reportConfig;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import commons.BaseTest;

public class ReportNGListener implements ITestListener {
	String projectLocation = System.getProperty("user.dir") + "/screenshotReportNG/";
	WebDriver driver;

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			System.out.println("---------- " + result.getName() + " FAILED test ----------");
			System.setProperty("org.uncommons.reportng.escape-output", "false");

			Object testClass = result.getInstance();
			WebDriver driver = ((BaseTest) testClass).getWebDriver(); 

			String screenshotPath = captureScreenshot(driver, result.getName());
			Reporter.getCurrentTestResult();
			
			Reporter.log("<br><a target=\"_blank\" href=\"file:///data:image/png;base64," + screenshotPath + "\">" + "<img src=\"data:image/png;base64," + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
			Reporter.setCurrentTestResult(null);
		} catch (NoSuchSessionException e) {
			e.printStackTrace();
		}catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {

	}

	@Override
	public void onTestStart(ITestResult arg0) {

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {

	}
	public String captureScreenshot(WebDriver driver, String screenshotName) {
		String screenshotBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		return screenshotBase64;
		//try {
			//Calendar calendar = Calendar.getInstance();
		//	SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			//File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			//String screenPath = projectLocation + screenshotName + "_" + formater.format(calendar.getTime()) + ".png";
		//	FileUtils.copyFile(source, new File(screenPath));
		//	return screenPath;
		//} catch (IOException e) {
		//	System.out.println("Exception while taking screenshot: " + e.getMessage());
		//	return e.getMessage();
		//}
	}
}
