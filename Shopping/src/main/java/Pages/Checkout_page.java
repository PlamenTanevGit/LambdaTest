package Pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import PagesEcommerce.base;

public class Checkout_page extends base {

	public WebElement Checkout_topLeftIcon() {
		return element = super.findElement("xpath",
				"//li[@class='breadcrumb-item active']");
	}
	
	
	public WebElement Update_inner_button() {
		return element = super.findElement("cssselector",
				"td:nth-of-type(3)  .input-group-append > button:nth-of-type(1)");
	}
	
	public WebElement VAT_label() {
		return element = super.findElement("cssselector",
				"#checkout-total tr:nth-of-type(4) td:nth-of-type(1)");
	}

	
	
	public void clickOnUpdate_button() {
		try {
			super.jSClick(Update_inner_button());
			Thread.sleep(300);
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
			Update_inner_button().click();			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Checkout_page() {
		
	}

}
