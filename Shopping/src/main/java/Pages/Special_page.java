package Pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PagesEcommerce.base;

public class Special_page extends base {

	public WebElement Search_Field() {
		return element = super.findElement("xpath",
				"//div[@class='entry-module module-mz_filter d-none d-lg-block']//h3[text()='Filter']");
	}

	
	
	


	public Special_page() {
		pageTitleVerify("");

	}

}
