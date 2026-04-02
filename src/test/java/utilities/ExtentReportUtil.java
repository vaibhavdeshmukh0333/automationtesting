package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * ExtentReportUtil class to create and manage Extent Reports for test execution.
 * Uses singleton design pattern to ensure only one instance.
 */
public class ExtentReportUtil {

    private static ExtentReports extentReports;

    private ExtentReportUtil() {
        // Private constructor for singleton
    }

    /**
     * Returns the singleton instance of ExtentReports.
     * @return ExtentReports instance.
     */
    public static ExtentReports getInstance() {
        if (extentReports == null) {
            extentReports = new ExtentReports();
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReport/report.html");
            sparkReporter.config().setReportName("Boots Automation Report");
            sparkReporter.config().setDocumentTitle("Test Execution Report");
            extentReports.attachReporter(sparkReporter);
        }
        return extentReports;
    }

    /**
     * Flushes the report.
     */
    public static void flushReport() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}
