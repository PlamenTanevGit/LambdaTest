package Pages;

import org.openqa.selenium.WebElement;

import PagesEcommerce.base;

public class MyAccount_page extends base {

	public WebElement MyAccount_title () {
		return element = super.findElement("xpath",
				"//h2[contains(text(),'My Account')]");
	}
	
	
	
	public MyAccount_page() {


	}
	
	

}
