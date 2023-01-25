package ShoppingTests;

import org.testng.annotations.Test;

import PagesEcommerce.base;

public class TESTS_Login extends base {
		
	@Test(alwaysRun = true,			
			description = "This Test performs Login with valid Credentials")
	public void t1_Login_Valid_UserCredentials() throws InterruptedException {

		// navigate to home page
		baseUrl = config.getProperty("loginPage");
		base.openUrl(baseUrl);		
		loginPage.doLogin(
				or.getProperty("usernameLogin"), 
				or.getProperty("passwordLogin"));
		//Assertion success login 
		super.assertElementIsDisplayed(myAccountPage.MyAccount_title());
		//logout
		topHeader.logOut();

	}
	
	@Test(alwaysRun = true,			
			description = "This Test performs Login with Invalid Credentials and Asserts warning message is displayed ")
	public void t2_Login_Invalid_UserCredentials() throws InterruptedException {

		// navigate to home page
		baseUrl = config.getProperty("loginPage");
		base.openUrl(baseUrl);		
		loginPage.doLogin(
				or.getProperty("usernameLogin"), 
				or.getProperty("passwordLogin2"));
		//ASSERTION for Warning message
		super.assertElementIsDisplayed(loginPage.Warnning_loginMessage());
		
	}

}
