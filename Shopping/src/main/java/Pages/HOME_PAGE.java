package Pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PagesEcommerce.base;

public class HOME_PAGE extends base {

	public WebElement Search_Field() {
		return element = super.findElement("xpath",
				"//div[@id='entry_217822']//input[@placeholder='Search For Products']");
	}

	public WebElement Search_Field_Search_Button() {
		return element = super.findElement("xpath", "//button[normalize-space()='Search']");
	}

	public WebElement Compare_button() {
		return element = super.findElement("xpath", "//a[@aria-label='Compare']");
	}

	public WebElement Whishlist_button() {
		return element = super.findElement("cssselector",
				"[class='entry-design design-link flex-grow-0 flex-shrink-0']:nth-of-type(4) svg");
	}

	public WebElement Cart_button() {
		return element = super.findElement("xpath", "//div[@id='entry_217825']//a[@role='button']");
	}

	/**
	 * WebElements - TOP ROW
	 */
	public WebElement topRowButtonsSection() {
		return element = super.findElement("xpath",
				"//div[@class='entry-section container d-none d-md-flex flex-row align-items-center']");
	}

	public WebElement topRowButtonsSection_shopByCattergory_Button() {
		return element = super.findElement("xpath",
				"//div[@class='entry-section container d-none d-md-flex flex-row align-items-center']/div[@id='entry_217832']");
	}

	public WebElement topRowButtonsSection_Home_Button() {
		return element = super.findElement("xpath",
				"//div[@class='entry-section container d-none d-md-flex flex-row align-items-center']//span[normalize-space()='Home']");
	}

	public WebElement topRowButtonsSection_Special_Button() {
		return element = super.findElement("xpath",
				"//div[@class='entry-section container d-none d-md-flex flex-row align-items-center']//span[normalize-space()='Special']");
	}

	public WebElement topRowButtonsSection_Blog_Button() {
		return element = super.findElement("xpath",
				"//div[@class='entry-section container d-none d-md-flex flex-row align-items-center']//span[normalize-space()='Blog']");
	}

	public WebElement topRowButtonsSection_MegaMenu_Button() {
		return element = super.findElement("xpath",
				"//div[@class='entry-section container d-none d-md-flex flex-row align-items-center']//span[normalize-space()='Mega Menu']");
	}

	public WebElement topRowButtonsSection_AddOns_Button() {
		return element = super.findElement("xpath",
				"//div[@class='entry-section container d-none d-md-flex flex-row align-items-center']//span[normalize-space()='AddOns']");
	}

	public WebElement topRowButtonsSection_MyAccount_Button() {
		return element = super.findElement("xpath",
				"//div[@class='entry-section container d-none d-md-flex flex-row align-items-center']//span[normalize-space()='My account']");
	}

	public WebElement TopCategories_element(String category) {
		return element = super.findElement("xpath",
				"//div[@id='widget-navbar-217841']//ul[@class='navbar-nav vertical']//span[normalize-space()='"
						+ category + "']");
	}

	public void openTopCategoriesSideBar() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
			topRowButtonsSection_shopByCattergory_Button().click();
			wait.until(ExpectedConditions
					.visibilityOf(super.returnElement("xpath", "//span[normalize-space()='Components']")));

		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}

	}

	public void enterProductInSearchField (String product) {
		try {
			super.findFieldAndSentKeys(Search_Field(), product);
		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnSearch () {
		try {
			super.JSclickOnWebElement(Search_Field_Search_Button());
		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}
	}
	
	
	public void homePageComponentsVerify() {
		base.assertElementIsDisplayed(Search_Field());
		base.assertElementIsDisplayed(Search_Field_Search_Button());
		base.assertElementIsDisplayed(Compare_button());
		base.assertElementIsDisplayed(Whishlist_button());
		base.assertElementIsDisplayed(Cart_button());
		base.assertElementIsDisplayed(topRowButtonsSection());
		base.assertElementIsDisplayed(topRowButtonsSection_shopByCattergory_Button());
		base.assertElementIsDisplayed(topRowButtonsSection_Home_Button());
		base.assertElementIsDisplayed(topRowButtonsSection_Special_Button());
		base.assertElementIsDisplayed(topRowButtonsSection_Blog_Button());
		base.assertElementIsDisplayed(topRowButtonsSection_MegaMenu_Button());
		base.assertElementIsDisplayed(topRowButtonsSection_AddOns_Button());
		base.assertElementIsDisplayed(topRowButtonsSection_MyAccount_Button());

	}

	public HOME_PAGE() {


	}

}
