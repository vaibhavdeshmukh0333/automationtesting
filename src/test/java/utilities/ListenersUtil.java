package utilities;

import baseclass.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * ListenersUtil class to listen to test execution events and perform actions based on results.
 * Implements ITestListener for TestNG.
 */
public class ListenersUtil implements ITestListener {

    private ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        try {
            test = ExtentReportUtil.getInstance().createTest(result.getMethod().getMethodName());
            test.log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            test.log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
            test.log(Status.FAIL, result.getThrowable());
            // Capture screenshot on failure
            String screenshotPath = CaptureScreenShotUtil.takeScreenShot(BaseClass.driver, result.getMethod().getMethodName());
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        try {
            test.log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
