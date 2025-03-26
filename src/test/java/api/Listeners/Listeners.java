package api.Listeners;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Listeners implements ITestListener {
	
	static Date date = new Date();
	static String file = date.toString().replace(":", "_").toString().replace(" ", "_");
	public static  ExtentSparkReporter htmlReporter;
	public static  ExtentReports  extent;
	public static ExtentTest test;
    public static String filePath = System.getProperty("user.dir") + "/src/main/resources/ExtentReports/extent.html";
  
    @Override
    public void onTestStart(ITestResult result) {
    	
    	test=extent.createTest("@TESTCASE : " + result.getName());
    	//test.assignCategory(result.getMethod().getGroups());
 	   
    }
    @Override
    public void onTestSuccess(ITestResult result) {
       
    	
        
        test.log(Status.PASS, "Test Passed");
        
    }
    @Override
    public void onTestFailure(ITestResult result) {
       
            String details = result.getThrowable().getMessage();
            String getThrowable = "<details><summary><font color=red>" + "Exception occurred: Click to see more"
                    + "</font></summary> <p>" + details.replaceAll(",", "<br>") + "</p></details>";
            
        //  test.createNode(result.getName());
            
            
            test.log(Status.FAIL, "TEST PASSED");
            test.log(Status.FAIL, getThrowable);
            
          
        
    }
    @Override
    public void onTestSkipped(ITestResult result) {
    	
       
        test.log(Status.SKIP, "TEST SKIPPED");
      
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // No change needed here
    }
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // No change needed here
    }
    @Override
    public void onStart(ITestContext context) {
    	
    	 
 	    // Create a local HtmlReporter object and configure it
 	    htmlReporter = new ExtentSparkReporter(filePath);
 	    htmlReporter.config().setDocumentTitle("Test Report");  // Use a generic title or pass a custom one
 	    htmlReporter.config().setReportName("Test Report for PET Store");  // Use a more descriptive report name
 	    htmlReporter.config().setTheme(Theme.STANDARD);
 	    htmlReporter.config().setEncoding("UTF-8");  // Corrected encoding
 	    
 	    // Create an instance of ExtentReports and attach the reporter
 	    extent = new ExtentReports();
 	    extent.setSystemInfo("Tester", "Lerato Motshabi");
 	    extent.setSystemInfo("Environment", "Windows 10");
 	    extent.setSystemInfo("Project", "Banking Domain Application Testing");
 	    
 	    extent.attachReporter(htmlReporter);
    	
    }
    @Override
    public void onFinish(ITestContext context) {
        
            extent.flush(); // This finalizes the report
     
    }

}
