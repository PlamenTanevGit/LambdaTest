package Pages;

import org.openqa.selenium.WebElement;

import PagesEcommerce.base;

public class Login_page extends base {

	public WebElement EmailAddress_field () {
		return element = super.findElement("xpath",
				"//input[@id='input-email']");
	}
	
	public WebElement Password_field () {
		return element = super.findElement("xpath",
				"//input[@id='input-password']");
	}

	public WebElement Login_btn () {
		return element = super.findElement("xpath",
				"//input[@value='Login']");
	}
	
	public WebElement Warnning_loginMessage () {
		return element = super.findElement("xpath",
				"//div[@class='alert alert-danger alert-dismissible']");
	}
	
	
	public void doLogin (String user, String pass) {	
		super.findFieldAndSentKeys(EmailAddress_field(), user);
		super.findFieldAndSentKeys(Password_field(), pass);
		super.jSClick(Login_btn());

	}
	
	public Login_page() {
		myAccountPage = new MyAccount_page();

	}
	
	

}
