package Genericcultility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	protected static final ExtentTest logger = null;
	public static WebDriver driver;
	private ExtentReports report;
	private String path;
	@BeforeSuite
	public void lanchingBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/extentdemo.html");
		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);

	}

	@BeforeTest
	public void beforeTest(){
		ExtentTest logger = report.createTest("testcase1");
	}
	
	
	@BeforeClass
	public void navigatingToApp(ExtentTest logger) {
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		logger.log(Status.INFO,"succesfully navigated to application");
		
	}
	
	
	@AfterMethod
	public void CheckingFailure(ITestResult result) throws IOException {
		if(result.getStatus()==result.FAILURE) {
			ScreenshotUtility.takingScreenshot(result.getName());
			System.out.println(result.getName());
			logger.log(Status.FAIL,"the test script "+result.getName()+" is failed");
			logger.addScreenCaptureFromPath(path);
		}


	}


	@AfterClass
	public void loggingOut() {
		System.out.println("logged out");
		logger.log(Status.INFO,"logged out from application");

	}
	@AfterSuite
	public void tearDownTheBrowser() {
		driver.quit();
      logger.log(Status.INFO,"closed the browser");
      report.flush();

	}
}
