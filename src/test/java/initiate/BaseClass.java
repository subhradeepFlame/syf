package initiate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.*;
import utility.*;

public class BaseClass {

	public WebDriver driver;
	public static WebDriverWait wait;
	static int stepCount = 1;
	public static ConfigReader con = new ConfigReader();
//	static String baseurl = con.getUrl();
	static String baseurl = "https://dev.joinheatchallenge.com/login";
	static String browser = con.getBrowser();
	public static int passed_count = 0;
	public static int failed_count = 0;
	public static int skipped_count = 0;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName = "";
	public static String screenshotFolderPath;
	protected static String reportFolder = "Report" + File.separator + "TestingReport" + "-" + con.getEnv() + "-"
			+ getCurrentTimeStampString("ddMMYYYY-HH-mm");
	public static File screenshotFolder;
	public String currentTest;
	static File reportf;
	protected static ExcelHelper excelhelper;
	protected static CommonPage commonpage;
	protected static LoginPage loginpage;
	protected static ForgotPasswordPage forgotpasswordpage;
	protected static DashboardPage dashboardpage;
	protected static QuestionnairePage questionnairepage;
	protected static MealPlannerPage mealplannerpage;
	protected static RegistrationPage registrationpage;
	protected static ChallengeVideosPage challengevideospage;
	protected static HeatOnDemandPage heatondemandpage;
	protected static LivestreamPage livestreampage;
	protected static ActivityFeedsPage activityfeedspage;
	protected static ProfilePage profilepage;
	protected static AdminPage adminpage;
	static String headless = con.getHeadlessStatus("headless");
	public static Logger logger;

	@BeforeSuite(alwaysRun = true)
	protected void fetchSuiteConfiguration(ITestContext testContext) {
		reportf = new File(reportFolder);
		// Reporter.log("test123");
		System.out.println(reportf.getAbsoluteFile());
		screenshotFolderPath = reportFolder + File.separator + "screenshots";
		screenshotFolder = new File(screenshotFolderPath);
		if (!screenshotFolder.getAbsoluteFile().exists()) {
			screenshotFolder.mkdirs();
		}
		extent = new ExtentReports(reportf.getAbsoluteFile() + File.separator + "extent-report.html", false);
		extent.addSystemInfo("Environment", con.getEnv().toUpperCase().trim());
		extent.loadConfig(new File(System.getProperty("user.dir") + "/src/test/resources/extent-config.xml"));
		String logPath = reportf.getAbsoluteFile() + File.separator;
		con.setKeyValue(new File(System.getProperty("user.dir") + "/src/test/resources/Log4j.properties"), "logPath",
				logPath);
	}

	@BeforeClass
	public void setup(ITestContext testContext) {
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/Log4j.properties");
		logger = Logger.getLogger("Base Class");
		initiateBrowser();
		excelhelper = new ExcelHelper(driver);
		commonpage = new CommonPage(driver);
		loginpage = new LoginPage(driver);
		forgotpasswordpage = new ForgotPasswordPage(driver);
		dashboardpage = new DashboardPage(driver);
		questionnairepage = new QuestionnairePage(driver);
		mealplannerpage = new MealPlannerPage(driver);
		registrationpage = new RegistrationPage(driver);
		challengevideospage = new ChallengeVideosPage(driver);
		heatondemandpage= new HeatOnDemandPage(driver);
		livestreampage= new LivestreamPage(driver);
		activityfeedspage= new ActivityFeedsPage(driver);
		adminpage= new AdminPage(driver);
		profilepage= new ProfilePage(driver);
		currentTest = testContext.getCurrentXmlTest().getName();
	}

	@BeforeMethod
	public void beforeMethod(ITestContext testContext, Method method) {
		test = extent.startTest(
				testContext.getName() + " : " + this.getClass().getSimpleName() + " - " + method.getName(),
				testContext.getSuite().getName());
		System.err.println("Test Started" + testContext.getName() + ": " + method.getName());
		stepCount = 1;

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult, Method method) {

		if (testResult.getStatus() == ITestResult.SUCCESS) {
			passed_count++;
			test.log(LogStatus.PASS, "Test Status", "PASSED");
		}

		else if (testResult.getStatus() == ITestResult.FAILURE) {
			failed_count++;
			test.log(LogStatus.FAIL, "", "FAILED");

		}

		else if (testResult.getStatus() == ITestResult.SKIP) {
			skipped_count++;
			test.log(LogStatus.SKIP, "", "SKIPPED");

		}
		try {
			testName = testResult.getName();
			if (testResult.getStatus() != ITestResult.SUCCESS) {
				System.out.println("TEST FAILED - " + testName);
				System.out.println("ERROR MESSAGE: " + testResult.getThrowable());
				System.out.println("\n");
				Reporter.setCurrentTestResult(testResult);
				Reporter.log("<br></br><Strong><font color=#ff0000>Fail                  </font></strong><img src='"
						+ screenshotFolderPath + "\\fail.png' alt='fail' height='15' width='15'/>");
				String screenshotName = currentTest + "" + method.getName()
						+ getCurrentTimeStampString("ddmmyy-hhmmss");
				makeScreenshot(screenshotName);
				System.out.println(screenshotFolder + File.separator + screenshotName + ".png");
				test.log(LogStatus.FAIL, "",
						test.addScreenCapture("screenshots" + File.separator + screenshotName + ".png"));
				test.log(LogStatus.FAIL, " ", testResult.getThrowable());
			} else {
				System.out.println("TEST PASSED - " + testName + "\n");
			}
			System.out.println(" Test status : " + testResult.getStatus() + "  ");

		} catch (Exception throwable) {
			System.out.println("message from tear down" + throwable);
		} finally {

			if (browser.contains("internet explorer")) {
				// killIEServer();
				pause(5);
			}
		}
		extent.endTest(test);
		extent.flush();

	}

	@AfterClass
	public void close() {
		driver.close();
		driver.quit();
	}

	@AfterSuite
	public void testResults() throws FileNotFoundException {
		System.out.println("The passed tests - " + passed_count);
		System.out.println("The failed tests - " + failed_count);
		System.out.println("The skipped tests - " + skipped_count);
		extent.flush();
		extent.close();

//		try {
//			FileUtils.copyDirectory(new File(System.getProperty("user.dir")+"/log"), new File(reportf+"/log"));
//			System.out.println("log file  moved");
//			try {
//				FileUtils.deleteDirectory(new File(System.getProperty("user.dir")+"/log"));
//			} catch (Exception e) {
//				e.printStackTrace();
//				System.out.println("File not created");
//			}
//		} catch (IOException e) {
//			System.out.println("log file not moved");
//		}
	}

	public void initiateBrowser() {
		/*
		 * Initialize driver initiate the browser
		 */

		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		options.addArguments("--remote-allow-origins=*");
		options.setExperimentalOption("prefs", prefs);
		WebDriverManager.chromedriver().setup();
		options.addArguments("disable-infobars");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(con.getExplicitTime()));
		maximizeBrowser();
		driver.get(baseurl);
		waitForPageLoaded();

		logger.info("Chrome Browser Opened");

	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
		/* maximizing window for headless mode */
		if (headless.equalsIgnoreCase("y"))
			driver.manage().window().setSize(new Dimension(1440, 900));
	}

	/*
	 * wait utill the page is loaded
	 */
	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

	/*
	 * wait utill the element is present
	 */
	public void PresenceOfElement(By locator) {
		// wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		// WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/*
	 * wait utill the element is clickable
	 */
	public void clickableElement(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/*
	 * wait utill the element visible in the page
	 */
	public WebElement visibilityOfElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	/*
	 * scroll to a element
	 */
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	/*
	 * Highlight element
	 */
	public void highlightElement(WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border = '3px solid yellow'", element);
			pause(2);
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border = '0px'", element);
		} catch (Exception e) {

		}
	}

	/*
	 * click on a WebElement
	 */
	public void clickOn(WebElement element) {
		clickableElement(element);
		highlightElement(element);
		try {
			((JavascriptExecutor) driver).executeScript("return arguments[0].click();", element);
		} catch (Exception e) {
			clickableElement(element);
			element.click();
		}
		waitForPageLoaded();
	}

	/*
	 * sendkeys with highlight element
	 */
	public void enterValue(WebElement element, String input) {
		highlightElement(element);
		clearElement(element);
//		try {
//			((JavascriptExecutor) driver).executeScript("arguments[0].value='"+input+"';", element);
//		}
//		catch(Exception e) {
		element.sendKeys(input);
//		}
	}

	/*
	 * clear a webelement field
	 */
	public void clearElement(WebElement element) {
		while (!element.getAttribute("value").equals("")) {
			element.sendKeys(Keys.BACK_SPACE);
		}
	}

	/*
	 * Time pause
	 */
	public void pause(int secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException interruptedException) {
		}
	}

	/*
	 * Check email format validation
	 */
	public boolean isValidEmail(String email) {
		return email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
	}

	public static String getCurrentTimeStampString(String timeformat) {
		/*
		 * get current timestamp withtimeformat
		 */
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat(timeformat);
		TimeZone timeZone = TimeZone.getDefault();
		Calendar cal = Calendar.getInstance(new SimpleTimeZone(timeZone.getOffset(date.getTime()), "GMT"));
		sd.setCalendar(cal);
		return sd.format(date);
	}

	public void makeScreenshot(String screenshotName) {
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		String nameWithExtention = screenshotName + ".png";
		try {
			reportFolder = reportFolder + File.separator;

			FileUtils.copyFile(screenshot,
					new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
		} catch (IOException e) {
			// log("Failed to capture screenshot: " + e.getMessage());
		}
	}

	public static void testInfoLog(String msg) {
		test.log(LogStatus.INFO, "info", msg);
		System.err.println("Info : " + msg);
//		log(msg);
	}

	public static void testFatalLog(String msg) {
		test.log(LogStatus.FATAL, "info", msg);
		System.err.println("Fatal : " + msg);

//		log(msg);
	}

	public static void testErrorLog(String msg) {
		test.log(LogStatus.ERROR, "info", msg);
		System.err.println("Error : " + msg);

//		log(msg);
	}

	public void testSkipLog(String msg) {
		test.log(LogStatus.SKIP, "", msg);
		System.err.println("Skip : " + msg);
//		log(msg);

	}

	public void testPassLog(String msg) {
		test.log(LogStatus.PASS, "", msg);
		System.err.println("Pass : " + msg);
//		log(msg);
	}

	public void testStepsLog(String msg) {
		System.err.println("steps " + stepCount + " : " + msg);
		test.log(LogStatus.PASS, "step :" + stepCount++, msg);
		logger.info(msg);

		/*
		 * TRACE DEBUG INFO WARN ERROR FATAL ALL
		 */
//		log(msg);
		extent.flush();
	}

	public void testVerifyLog(String msg) {
		test.log(LogStatus.PASS, "Verified", msg);
//		log("<font color=#000080>" + msg + "</font>");
	}

	/*
	 * for switch between tabs
	 */
	public void switchTab(int tabNumber) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabNumber));
	}

	/*
	 * generates random value between max and min
	 */
	public static int randomValue(int min, int max) {
		Random random = new Random();
		int value = random.nextInt(max - min + 1) + min;
		return value;
	}

}
