package Pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PagesEcommerce.base;

public class Lambdatest_CONFIRM_ORDER_PAGE extends base {

	public WebElement ConfirmOrder_title() {
		return element = super.findElement("xpath",
				"//h1[normalize-space()='Confirm Order']");
	}

	
	public Lambdatest_CONFIRM_ORDER_PAGE() {
		
	}

}
