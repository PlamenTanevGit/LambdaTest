package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PagesEcommerce.base;

public class ACCOUNT_REGISTER_page extends base {

	public String firstName;
	public String lastName;
	public String email;
	public String telephone;
	public String password;
	public String confrimPassword;
	public String company;
	public String address1;
	public String address2;
	public String city;
	public String postCode;
	public String country;
	public String region;
	public String VAT;

	public WebElement Checkout_topLeftIcon() {
		return element = super.findElement("xpath", "//li[@class='breadcrumb-item active']");
	}

	public WebElement YourPersonalDetails_form_window() {
		return element = super.findElement("xpath", "//html//div[@id='account']");

	}

	public WebElement FirstName_field() {
		return element = super.findElement("xpath", "//html//div[@id='account']//input[@id='input-payment-firstname']");

	}

	public WebElement LastName_field() {
		return element = super.findElement("xpath", "//html//div[@id='account']//input[@id='input-payment-lastname']");

	}

	public WebElement Email_field() {
		return element = super.findElement("xpath", "//html//div[@id='account']//input[@id='input-payment-email']");

	}

	public WebElement Telephone_field() {
		return element = super.findElement("xpath", "//html//div[@id='account']//input[@id='input-payment-telephone']");

	}

	public WebElement Password_field() {
		return element = super.findElement("xpath", "//html//div[@id='account']//input[@id='input-payment-password']");

	}

	public WebElement PasswordConfirm_field() {
		return element = super.findElement("xpath", "//html//div[@id='account']//input[@id='input-payment-confirm']");

	}

	public WebElement BillingAddress_form_window() {
		return element = super.findElement("xpath", "//div[@id='payment-address']");

	}

	public WebElement Company_field() {
		return element = super.findElement("xpath", "//div[@id='payment-address']//input[@id='input-payment-company']");

	}

	public WebElement Address1_field() {
		return element = super.findElement("xpath",
				"//div[@id='payment-address']//input[@id='input-payment-address-1']");

	}

	public WebElement Address2_field() {
		return element = super.findElement("xpath",
				"//div[@id='payment-address']//input[@id='input-payment-address-2']");

	}

	public WebElement City_field() {
		return element = super.findElement("xpath", "//div[@id='payment-address']//input[@id='input-payment-city']");

	}

	public WebElement PostCode_field() {
		return element = super.findElement("xpath",
				"//div[@id='payment-address']//input[@id='input-payment-postcode']");

	}

	public WebElement Country_dropdown() {
		return element = super.findElement("xpath",
				"//div[@id='payment-address']//select[@id='input-payment-country']");

	}

	public WebElement Region_State_dropdown() {
		return element = super.findElement("xpath", "//div[@id='payment-address']//select[@id='input-payment-zone']");

	}

	public WebElement PrivacyPolicy_checkbox() {
		return element = super.findElement("xpath", "//div[@class='custom-control custom-checkbox']//label[@for='input-account-agree']");

	}

	public WebElement TermsAndConditions_checkbox() {
		return element = super.findElement("xpath", "//div[@class='custom-control custom-checkbox']//label[@for='input-agree']");

	}
	
	public WebElement ContinueButton() {
		return element = super.findElement("xpath", "//button[@id='button-save']");

	}
	
	public WebElement AccountLogout_message() {
		return element = super.findElement("xpath", "//div[@id='content']/h1");

	}
	
	public WebElement AccountLogout_Continue_button() {
		return element = super.findElement("xpath", "//div[@class='buttons mb-4']/a");

	}
	
	public void clickOnContinueButton() {
		try {
			wait = new WebDriverWait(driver, 4);
			super.jSClick(ContinueButton());
			wait.until(ExpectedConditions.visibilityOf(confirmOrderPage.ConfirmOrder_title()));
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
			ContinueButton().click();			
		}
	}

	public void checkPrivacyPolicy() {
			
		try {
			super.pseudoClickJavascript("label[for='input-account-agree']", "before");			
		} catch (StaleElementReferenceException e) {
			System.out.println(e);			
		}
	}

	public void checkTermsAndConditions() {
		try {
			super.pseudoClickJavascript("label[for='input-agree']", "after");	
		} catch (StaleElementReferenceException e) {
			System.out.println(e);		
		}
	}

	public String setFirstName(String firstName) {
		try {
			super.findFieldAndSentKeys(FirstName_field(), firstName);
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
		}
		return firstName;

	}

	public String setLastName(String lastName) {
		try {
			super.findFieldAndSentKeys(LastName_field(), lastName);
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
		}
		return lastName;

	}

	public String setEmail(String email) {
		try {
			super.findFieldAndSentKeys(Email_field(), email);
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
		}
		return email;

	}

	public String setTelephone(String telephone) {
		try {
			super.findFieldAndSentKeys(Telephone_field(), telephone);
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
		}
		return telephone;

	}

	public String setPassword(String password) {
		try {
			super.findFieldAndSentKeys(Password_field(), password);
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
		}
		return password;

	}

	public String setConfirmPassword(String confirmPassword) {
		try {
			super.findFieldAndSentKeys(PasswordConfirm_field(), confirmPassword);
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
		}
		return confirmPassword;

	}

	public String setCompany(String company) {
		try {
			super.findFieldAndSentKeys(Company_field(), company);
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
		}
		return company;

	}

	public String setAddress1(String address1) {
		try {
			super.findFieldAndSentKeys(Address1_field(), address1);
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
		}
		return address1;

	}

	public String setAddress2(String address2) {
		try {
			super.findFieldAndSentKeys(Address2_field(), address2);
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
		}
		return address2;

	}

	public String setCity(String city) {
		try {
			super.findFieldAndSentKeys(City_field(), city);
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
		}
		return city;

	}

	public String setPostCode(String postCode) {
		try {
			super.findFieldAndSentKeys(PostCode_field(), postCode);
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
		}
		return postCode;

	}

	/***
	 * Dropdown Selection
	 * 
	 * @param searchedCountry
	 * @return
	 */
	public String selectCountry(String searchedCountry) {
		try {
			selectDropdownOptionByTagName(Country_dropdown(), "option", searchedCountry);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FirstName_field().click();
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
		}
		return searchedCountry;
	}

	/**
	 * Dropdown selection
	 * 
	 * @param searchedRegion
	 * @return
	 */
	public String selectRegionState(String searchedRegion) {
		try {
			selectDropdownOptionByTagName(Region_State_dropdown(), "option", searchedRegion);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FirstName_field().click();
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
		}
		return searchedRegion;
	}

	public void addPersonalDetails(String fn, String ln, String email, String phone, String password, String confPass) {
		setFirstName(fn);
		setLastName(ln);
		setEmail(email);
		setTelephone(phone);
		setPassword(password);
		setConfirmPassword(confPass);

	}

	public void addBillingAddress(String company, String addr1, String addr2, String city, String postCode,
			String country, String region) {
		setCompany(company);
		setAddress1(addr1);
		setAddress2(addr2);
		setCity(city);
		setPostCode(postCode);
		selectCountry(country);
		selectRegionState(region);

	}

	public String selectDropdownOptionByTagName(WebElement dropdown, String tagName, String searchedOption) {
		try {
			dropdown.click();			
		} catch (Exception e) {
			super.jSClick(dropdown);
			e.printStackTrace();			
		}
		List<WebElement> options = driver.findElements(By.tagName(tagName));
		for (WebElement option : options) {
			if (option.getText().equals(searchedOption)) {

				try {
					option.click();
				} catch (Exception e) {
					e.printStackTrace();
					super.jSClick(option);
				}
				break;
			}
		}
		return searchedOption;

	}
	
	
	/***
	 *  Product Right Side Elements 
	 */
	public WebElement SubTotal_value() {
		return element = super.findElement("xpath", "//body//div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/strong[1]");

	}
	
	public WebElement FlatShipping_value() {
		return element = super.findElement("xpath", "//body//div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/strong[1]");

	}
	
	public WebElement EcoTax_value() {
		return element = super.findElement("xpath", "//body//div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[2]/strong[1]");

	}
	public WebElement VAT_value() {
		return element = super.findElement("xpath", "//body//div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/strong[1]");

	}
	
	public WebElement Total_value (String VAT) {
		
		switch (VAT) {
		
		case "VAT_YES":
			element = super.findElement("xpath",
					"//body//div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[2]/strong[1]");
			break;

		case "VAT_NO":
			element = super.findElement("xpath",
					"//body//div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[2]/strong[1]");
			break;

		default:
			break;
		}

		return element;
	}
	
	/***
	 *  Values
	 */
	public double  getSubTotalAmount () {
		return  getDoubleFromStringAmount(SubTotal_value().getText());								
	}
	
	public double  getFlatShippingRateAmmount () {
		return  getDoubleFromStringAmount(FlatShipping_value().getText());								
	}
	
	public double  getEcoTaxAmount () {
		return  getDoubleFromStringAmount(EcoTax_value().getText());								
	}
	
	public double  getVATAmount () {
		return  getDoubleFromStringAmount(VAT_value().getText());								
	}
	
	public double  getTotalAmount (String VAT) {
		return  getDoubleFromStringAmount(Total_value(VAT).getText());								
	}

	
	
	public static double getDoubleFromStringAmount (String stringUpd) {
		double priceDouble= 0;
		String price1 = stringUpd.replace("$", "");
		priceDouble= Double.parseDouble(price1);
		return priceDouble;
	}
	
	
	public ACCOUNT_REGISTER_page() {
		
		confirmOrderPage = new CONFIRM_ORDER_PAGE();

	}

}
