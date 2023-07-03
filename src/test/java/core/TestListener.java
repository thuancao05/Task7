package core;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReportManager;
import reports.ExtentTestManager;
import utils.LogUtils;

public class TestListener implements ITestListener {
    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }
    @Override
    public void onFinish(ITestContext result) {
        LogUtils.info("End testing " + result.getName());

        //Kết thúc và thực thi Extents Report
        ExtentReportManager.getExtentReports().flush();
    }

    @Override
    public void onStart(ITestContext result) {
        LogUtils.info("Start auto test");
        //PropertiesHelper.loadAllFiles();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogUtils.error("This test case failed: " + result.getName());
        //Extent Report
        ExtentTestManager.addScreenShot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, result.getName() + " is failed.");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.info("This test case skipped: " + result.getName());
        //Extent Report
        ExtentTestManager.logMessage(Status.SKIP, result.getThrowable().toString());

    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtils.info("This test case succeed: " + result.getName());
        ExtentTestManager.logMessage(Status.PASS, result.getName() + " is passed.");

    }
}