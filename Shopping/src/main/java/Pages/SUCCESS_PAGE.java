package Pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PagesEcommerce.base;

public class SUCCESS_PAGE extends base {

	public WebElement Checkout_topLeftIcon() {
		return element = super.findElement("xpath",
				"//li[@class='breadcrumb-item active']");
	}

	
	public SUCCESS_PAGE() {
		
	}

}
