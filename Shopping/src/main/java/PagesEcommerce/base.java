package PagesEcommerce;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import Pages.AccountRegister_page;
import Pages.Checkout_page;
import Pages.ConfirmOrder_page;
import Pages.Home_page;
import Pages.Login_page;
import Pages.MyAccount_page;
import Pages.SearchResults_page;
import Pages.ShoppingCart_page;
import Pages.Success_page;
import Pages.TopHeader_page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	// Properties Initialize
	public static Properties config = new Properties();
	public static Properties or = new Properties();

	// FileInputStream init
	public static java.io.FileInputStream fis;
	public static java.io.FileInputStream fis2;

	public static final Browsers BROWSER2 = Browsers.CHROME;
	public static final String BROWSER = "chrome";
	public static String baseUrl;
	public static WebElement element;
	public static WebDriver driver;
	public static final int TIMEOUT = 10;
	public static final int PAGE_TIMEOUT = 35;
	public static final int SCRIPT_TIMEOUT = 35;
	public static String screenshotName;
	public static Actions actions;
	public static JavascriptExecutor js;
	static long startTime;
	static long endTime;
	public static SoftAssert softAssert;
	public WebDriverWait wait;

	/** Pages */
	protected Home_page homePage;
	protected SearchResults_page searchResultPage;
	protected ShoppingCart_page shoppingCartPage;
	protected Checkout_page checkoutPage;
	protected AccountRegister_page accountRegisterPage;
	protected ConfirmOrder_page confirmOrderPage;
	protected TopHeader_page topHeader;
	protected Success_page successPage;
	protected Login_page loginPage;
	protected MyAccount_page myAccountPage;

	public static WebDriver initialise(String browser) {

		/** create Chrome options */
		ChromeOptions chromeOptions = new ChromeOptions();

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			// WebDriverManager.chromedriver().driverVersion(" 95.0.4638.54").setup(); //
			// 98.0.4758.80 // 95.0.4638.54 // 99.0.4844.151

			chromeOptions.addArguments("--disable-infobars");
			chromeOptions.addArguments("--window-size=1920,1080");
			chromeOptions.addArguments("--ignore-certificate-errors");
			chromeOptions.addArguments("--disable-default-apps");
			chromeOptions.addArguments("--disable-popup-blocking");
			chromeOptions.addArguments("--incognito");

			driver = new ChromeDriver(chromeOptions);

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("chromeoption")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.setExperimentalOption("debuggerAddress", "localhost:20363"); // 9898
			driver = new ChromeDriver(option);

		}

		/* set amount of total time for search for element */
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		/* set amount of time to page load to complete before trow error */
		driver.manage().timeouts().pageLoadTimeout(PAGE_TIMEOUT, TimeUnit.SECONDS);
		/*
		 * set amount of time to wait for a script to finish execution before throwing
		 * error
		 */
		driver.manage().timeouts().setScriptTimeout(SCRIPT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;

	}

	public static void initConfiguration() {
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
		try {
			config.load(fis);

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fis2 = new FileInputStream(System.getProperty("user.dir") + "\\properties\\or.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			or.load(fis2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void openUrl(String url) {
		driver.get(url);
		Reporter.log("Successfully opened url '" + url + "'");
	}

	public static void assertElementIsDisplayed(WebElement element) {
		Assert.assertTrue(element.isDisplayed());
	}
	  public void softAssertElementIsNotDisplayed(By locator) {

	        List<WebElement> searchedElemeents = driver.findElements(locator);
	        System.out.println(searchedElemeents.size());
	        softAssert.assertTrue(searchedElemeents.isEmpty());
	        softAssert.assertAll();
	  
	  }

	/*
	 * WebElement returns element based on different locator
	 */
	public static WebElement returnElement(String locatorType, String locatorPath) {

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

		switch (locatorType.toLowerCase()) {
		case "id":
			return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(locatorPath))));
		case "xpath":
			return driver.findElement(By.xpath(locatorPath));
		case "name":
			return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name(locatorPath))));
		case "classname":
			return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(locatorPath))));
		case "cssselector":
			return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(locatorPath))));
		case "linktext":
			return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(locatorPath))));
		case "tagname":
			return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName(locatorPath))));

		default:
			throw new RuntimeException("Unknown locator " + locatorType + " : " + locatorPath);
		}

	}

	public List<WebElement> getElementList(String locator, String type) {
		type = type.toLowerCase();
		List<WebElement> elementList = new ArrayList<WebElement>();
		if (type.equals("id")) {
			elementList = driver.findElements(By.id(locator));
		} else if (type.equals("name")) {
			elementList = driver.findElements(By.name(locator));
		} else if (type.equals("xpath")) {
			elementList = driver.findElements(By.xpath(locator));
		} else if (type.equals("css")) {
			elementList = driver.findElements(By.cssSelector(locator));
		} else if (type.equals("classname")) {
			elementList = driver.findElements(By.className(locator));
		} else if (type.equals("tagname")) {
			elementList = driver.findElements(By.tagName(locator));
		} else if (type.equals("linktext")) {
			elementList = driver.findElements(By.linkText(locator));
		} else if (type.equals("partiallinktext")) {
			elementList = driver.findElements(By.partialLinkText(locator));
		} else {
			System.out.println("Locator type not supported");
		}
		if (elementList.isEmpty()) {
			System.out.println("Element not found with " + type + ": " + locator);

		} else {
			System.out.println("Element found with " + type + ": " + locator);
		}
		return elementList;
	}

	/*
	 * findElement using 'returnElement' and verify is Displayed
	 */
	public static WebElement findElement(String locatorType, String locatorPath) {
		try {
			element = returnElement(locatorType, locatorPath);
			element.isDisplayed();
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
		}
		
		return element;
	}

	/*
	 * Method for finding Fields and Highlight them before enter a value
	 */
	public static WebElement findFieldAndSentKeys(WebElement element, String value) {
		element.isDisplayed();
		HighLightElement(element);
		element.clear();
		element.sendKeys(value);
		Reporter.log(" Enter value : " + value);
		return element;
	}

	/*
	 * Highlights the fileds in yellow color apply for the filed that is under
	 * typing
	 */
	public static void HighLightElement(WebElement element) {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;')", element);
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element);
	}

	/*
	 * method for scroll down
	 */
	public static void scrollDown(WebElement Element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);

	}

	/**
	 * Method for click on WebElement using JavascriptExecutor
	 * 
	 * @param element
	 */
	public static void jSClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		js = (JavascriptExecutor) driver;
		try {
			element = wait.until(ExpectedConditions.elementToBeClickable(element));
			js.executeScript("arguments[0].click();", element);
			// element.click();
			// Reporter.log("Successfully click on element " + element.getText());
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
		}
	}

	public static void pseudoClickJavascript(String cssPath, String key) {

		switch (key) {
		case "before":
			((JavascriptExecutor) driver).executeScript("document.querySelector(arguments[0],':before').click();",
					cssPath);
			break;

		case "after":
			((JavascriptExecutor) driver).executeScript("document.querySelector(arguments[0],':after').click();",
					cssPath);
			break;

		default:
			break;
		}

	}

	/*
	 * method for click on WebElement using JavascriptExecutor
	 */
	public static void JSclickOnWebElement(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * Mehtod for capture of Screenshot and using it in the listeners
	 * 
	 * @return
	 * @throws IOException
	 */
	public static String ScreenCapture() throws IOException {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		zoomOutPage(50);
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String Path = System.getProperty("user.dir") + "\\screenshots\\" + screenshotName;

		File screenshotName = new File(Path);

		FileUtils.copyFile(scrFile, screenshotName);
		Reporter.log("<a href=" + screenshotName + "></a>");
		Reporter.log("<br>  <img src='" + screenshotName + "' height='200' width='200' /><br>");

		return Path;

	}

	/*
	 * Work on Dropdowns
	 **/
	public static void select(WebElement select1, String value) {

		Select select = new Select(select1);
		select.selectByVisibleText(value);
		Reporter.log("Selecting from dropdown value as : " + value);

	}

	/* Page title assert */
	public static void pageTitleVerify(String expected) {
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
		Reporter.log("Page title  is Verified");
		System.out.println("Page title  is Verified");

	}

	/* method performing Page zoom out */
	public static void zoomOutPage(int percent) {
		JavascriptExecutor js = (JavascriptExecutor) base.driver;
		js.executeScript("document.body.style.zoom='" + percent + "%'");
	}

	public static void verifyEqualTexts(WebElement element, String expected) {

		Assert.assertEquals(element.getText(), expected);
		Reporter.log("Text : " + element.getText() + " - is Verified");
		System.out.println("Text : " + element.getText() + " -  is Verified");

	}

	public void movesToTheElement(WebElement element) {
		actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);

		try {
			element = wait.until(ExpectedConditions.visibilityOf(element));
			actions.moveToElement(element).build().perform();
			// Log.info("Moved to Element ");
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + element + " was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Element " + element + " was not clickable " + e.getStackTrace());

		}
	}

	public int convertDoubleToInt(double doubleAmount) {
		int a = 0;
		Double newData = new Double(doubleAmount);
		return a = newData.intValue();
	}

	public List<WebElement> visiblilityOfAllElements(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(locator)));
		return driver.findElements(locator);
	}

	public WebElement waitForElementToBePresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return getElement(locator);
	}

	public WebElement waitForElementToBeClickable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return getElement(locator);
	}

	public WebElement waitForElementToBeVisbile(By locator, int timeout) {
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	public void clickWhenReady(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		getElement(locator).click();
	}

	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}



	/* check all checkBoxSelection method - capturing them by common tagName */
	public void TermsAndConditionsclickAllCheckBoxes(String tagname, String attribute, String text) {
		List<WebElement> list = driver.findElements(By.tagName(tagname));
		int size = list.size();
		for (int i = 0; i < size; i++) {
			list.get(i).getText();
		}
		for (WebElement webElement : list) {
			if (webElement.getAttribute(attribute).equals(text)) {
				base.jSClick(webElement);
			}
		}
	}

	public static String randomString(int lenght) {
		String characters = "abcdefghijklmnopqrstuvwxyz";
		String randomString = "";

		Random rand = new Random();
		char[] text = new char[lenght];

		for (int i = 0; i < lenght; i++) {
			text[i] = characters.charAt(rand.nextInt(characters.length()));
		}

		for (int i = 0; i < text.length; i++) {
			randomString += text[i];
		}
		return randomString;
	}
	
	

	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("");
		startTime = System.nanoTime();
		softAssert = new SoftAssert();

	}

	@BeforeClass
	public void beforeClass() {
		initialise(BROWSER);
		Reporter.log(BROWSER + " is Initialised");

		initConfiguration();

		homePage = new Home_page();
		searchResultPage = new SearchResults_page();
		shoppingCartPage = new ShoppingCart_page();
		checkoutPage = new Checkout_page();
		accountRegisterPage = new AccountRegister_page();
		confirmOrderPage = new ConfirmOrder_page();
		topHeader = new TopHeader_page();
		successPage = new  Success_page();
		loginPage = new Login_page();
		myAccountPage = new MyAccount_page();
	}

	@AfterClass
	public void afterClass() {

		if (driver != null) {
			driver.quit();
		}

	}

	@AfterSuite
	public void afterSuite() {
		if (driver != null) {
			driver.quit();
		}
		Reporter.log("Driver quit");
		endTime = System.nanoTime();
		long dur = endTime - startTime;
		long convert = TimeUnit.SECONDS.convert(dur, TimeUnit.NANOSECONDS);
		Reporter.log("Duration of Suite is : " + convert + " sec.");
		System.out.println("Duration of Suite is : " + convert + " sec.");

	}

}
