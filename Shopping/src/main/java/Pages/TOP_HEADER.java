package Pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import PagesEcommerce.base;

public class TOP_HEADER extends base {

	public WebElement topHeaderMenusRow() {
		return element = super.findElement("xpath",
				"//div[@id='entry_217831']");
	}	
	
	public WebElement topHeaderMenusRow_ShopByCategory() {
		return element = super.findElement("xpath",
				"//div[@id='entry_217831']//a[normalize-space()='Shop by Category']");
	}

	public WebElement topHeaderMenusRow_Home() {
		return element = super.findElement("xpath",
				"//div[@id='entry_217831']//a[normalize-space()='Home']");
	}
	
	public WebElement topHeaderMenusRow_Special() {
		return element = super.findElement("xpath",
				"//div[@id='entry_217831']//div[normalize-space()='Special']");
	}
	
	public WebElement topHeaderMenusRow_Blog() {
		return element = super.findElement("xpath",
				"//div[@id='entry_217831']//div[normalize-space()='Blog']");
	}
	
	public WebElement topHeaderMenusRow_MegaMenu() {
		return element = super.findElement("xpath",
				"//div[@id='entry_217831']//div[normalize-space()='Mega Menu']");
	}
	
	public WebElement topHeaderMenusRow_AddOns() {
		return element = super.findElement("xpath",
				"//div[@id='entry_217831']//div[normalize-space()='AddOns']");
	}
	
	public WebElement topHeaderMenusRow_MyAccount() {
		return element = super.findElement("xpath",
				"//div[@id='entry_217831']//div[normalize-space()='My account']");
	}
	
	/**
	 * My Account dropdown  Elements
	 */
	public WebElement MyAccount_Dashboard() {
		return element = super.findElement("xpath",
				"//span[normalize-space()='Dashboard']");
	}
	
	public WebElement MyAccount_MyOrder() {
		return element = super.findElement("xpath",
				"//span[normalize-space()='My order']");
	}
	
	public WebElement MyAccount_Return() {
		return element = super.findElement("xpath",
				"//span[normalize-space()='Return']");
	}
	
	public WebElement MyAccount_Tracking() {
		return element = super.findElement("xpath",
				"//a[@class='icon-left both dropdown-item']//span[@class='title'][normalize-space()='Tracking']");
	}
	
	public WebElement MyAccount_MyVoucher() {
		return element = super.findElement("xpath",
				"//span[normalize-space()='My voucher']");
	}
	
	public WebElement MyAccount_Logout() {
		return element = super.findElement("xpath",
				"//span[normalize-space()='Logout']");
	}
	
	public void verifyMyAccountLoggedUserDropdown() {
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, 3);
		try {
			wait.until(ExpectedConditions.visibilityOf(topHeaderMenusRow_MyAccount()));
            actions.moveToElement(topHeaderMenusRow_MyAccount()).build().perform();

            wait.until(ExpectedConditions.visibilityOf(MyAccount_Dashboard()));
		} catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element " + element + " was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Element " + element + " was not clickable " + e.getStackTrace());
        }
		super.verifyEqualTexts(MyAccount_Dashboard(),"Dashboard");
		super.verifyEqualTexts(MyAccount_MyOrder(),"My order");
		super.verifyEqualTexts(MyAccount_Return(),"Return");
		super.verifyEqualTexts(MyAccount_Tracking(),"Tracking");
		super.verifyEqualTexts(MyAccount_MyVoucher(),"My voucher");
		super.verifyEqualTexts(MyAccount_Logout(),"Logout");
		
	}
	
	
	public void logOut () {
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, 3);
		try {
			wait.until(ExpectedConditions.visibilityOf(topHeaderMenusRow_MyAccount()));
            actions.moveToElement(topHeaderMenusRow_MyAccount()).build().perform();

            wait.until(ExpectedConditions.visibilityOf(MyAccount_Logout()));
            actions.click(MyAccount_Logout()).build().perform();
            
            wait.until(ExpectedConditions.visibilityOf(accountRegisterPage.AccountLogout_message()));
            actions.click(accountRegisterPage.AccountLogout_Continue_button());
            Thread.sleep(200);
		} catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element " + element + " was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Element " + element + " was not clickable " + e.getStackTrace());
        }
		
		
		
	}
	
	public void headerElmentsVerify() {
		super.assertElementIsDisplayed(topHeaderMenusRow());
		super.assertElementIsDisplayed(topHeaderMenusRow_ShopByCategory());
		super.assertElementIsDisplayed(topHeaderMenusRow_Home());
		super.assertElementIsDisplayed(topHeaderMenusRow_Special());
		super.assertElementIsDisplayed(topHeaderMenusRow_Blog());
		super.assertElementIsDisplayed(topHeaderMenusRow_MegaMenu());
		super.assertElementIsDisplayed(topHeaderMenusRow_AddOns());
		super.assertElementIsDisplayed(topHeaderMenusRow_MyAccount());

		super.verifyEqualTexts(topHeaderMenusRow_ShopByCategory(),"Shop by Category");
		super.verifyEqualTexts(topHeaderMenusRow_Home(),"Home");
		super.verifyEqualTexts(topHeaderMenusRow_Special(),"Special");
		super.verifyEqualTexts(topHeaderMenusRow_Blog(),"Blog");
		super.verifyEqualTexts(topHeaderMenusRow_MegaMenu(),"Mega Menu");
		super.verifyEqualTexts(topHeaderMenusRow_AddOns(),"AddOns");
		super.verifyEqualTexts(topHeaderMenusRow_MyAccount(),"My account");

	}

	public TOP_HEADER() {
		
		

	}

}
