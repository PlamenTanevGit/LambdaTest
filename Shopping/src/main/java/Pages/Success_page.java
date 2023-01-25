package Pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import PagesEcommerce.base;

public class Success_page extends base {

	public WebElement Checkout_topLeftIcon() {
		return element = super.findElement("xpath",
				"//li[@class='breadcrumb-item active']");
	}

	public WebElement OrderPlaced_SuccessMessage () {
		return element = super.findElement("xpath",
				"//div[@id='common-success']//p[text()='Your order has been successfully processed!']");
	}
	
	public WebElement Continue_button () {
		return element = super.findElement("xpath",
				"//div[@id='common-success']//a[text()='Continue']");
	}
	
	
	public void clickOnContinue_button() {
		try {
			super.jSClick(Continue_button());
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
			Continue_button().click();			
		}
	}
	
	
	public Success_page() {
		
	}

}
