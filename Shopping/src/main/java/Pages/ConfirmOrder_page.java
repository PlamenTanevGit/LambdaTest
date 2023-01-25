package Pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import PagesEcommerce.base;

public class ConfirmOrder_page extends base {

	public WebElement ConfirmOrder_title() {
		return element = super.findElement("xpath",
				"//h1[normalize-space()='Confirm Order']");
	}

	public WebElement ConfirmOrder_ProductName_title () {
		return element = super.findElement("xpath",
				"/html//div[@id='content']//table/thead/tr/td[1]");
	}
	
	public WebElement ConfirmOrder_Model_title () {
		return element = super.findElement("xpath",
				"/html//div[@id='content']//table/thead/tr/td[2]");
	}
	
	public WebElement ConfirmOrder_Quantity_title () {
		return element = super.findElement("xpath",
				"/html//div[@id='content']//table/thead/tr/td[3]");
	}
	
	public WebElement ConfirmOrder_Price_title () {
		return element = super.findElement("xpath",
				"/html//div[@id='content']//table/thead/tr/td[4]");
	}
	
	public WebElement ConfirmOrder_Total_title () {
		return element = super.findElement("xpath",
				"/html//div[@id='content']//table/thead/tr/td[5]");
	}
	
	/**
	 * Inner form fields
	 */
	public WebElement ConfirmOrder_SubTotal_label () {
		return element = super.findElement("xpath",
				"/html//div[@id='content']//table//strong[text()='Sub-Total:']");
	}
	
	public WebElement ConfirmOrder_SubTotal_value () {
		return element = super.findElement("xpath",
				"/html//div[@id='content']//table/tfoot/tr[1]/td[2]");
	}
	
	public WebElement ConfirmOrder_FlatShippingRate_label () {
		return element = super.findElement("xpath",
				"/html//div[@id='content']//table//strong[text()='Flat Shipping Rate:']");
	}
	
	public WebElement ConfirmOrder_FlatShippingRate_value () {
		return element = super.findElement("xpath",
				"/html//div[@id='content']//table/tfoot/tr[2]/td[2]");
	}
	
	public WebElement ConfirmOrder_Total_label () {
		return element = super.findElement("xpath",
				"/html//div[@id='content']//table//strong[text()='Total:']");
	}
	
	public WebElement ConfirmOrder_Total_value (String VAT) {
		
		switch (VAT) {
		
		case "VAT_YES":
			element = super.findElement("xpath",
					"/html//div[@id='content']//table/tfoot/tr[5]/td[2]");
			break;
			
		case "VAT_NO":
			element = super.findElement("xpath",
					"/html//div[@id='content']//table/tfoot/tr[3]/td[2]");
			break;

		default:
			break;
		}
		
		return element ;
	}
	
	/**
	 * Payment Address, Shipping address, Shipping Method
	 */
	
	public WebElement PaymentAddress_title () {
		return element = super.findElement("xpath",
				"/html//div[@id='content']//h4[text()='Payment Address']");
	}
	
	public WebElement PaymentAddress_box () {
		return element = super.findElement("xpath",
				"//div[@id='content']//div[1]//div[1]//div[1]");
	}
	
	public WebElement ShippingAddress_title () {
		return element = super.findElement("xpath",
				"/html//div[@id='content']//h4[text()='Shipping Address']");
	}
	
	public WebElement ShippingAddress_box () {
		return element = super.findElement("xpath",
				"//div[@id='content']//div[1]//div[1]//div[1]");
	}
	
	public WebElement ShippingMethod_title () {
		return element = super.findElement("xpath",
				"/html//div[@id='content']//h4[text()='Shipping Method:']");
	}
	
	public WebElement ShippingMethod_box () {
		return element = super.findElement("xpath",
				"//div[@id='content']/div[@class='card mb-4']/div");
	}
	
	public WebElement Edit_button () {
		return element = super.findElement("xpath",
				"//div[@class='buttons d-flex justify-content-between']/a");
	}
	
	public WebElement ConfirmOrder_button () {
		return element = super.findElement("xpath",
				"//div[@class='buttons d-flex justify-content-between']/button");
	}
	
	public void ConfirmOrder() {
		try {
			wait = new WebDriverWait(driver, 4);
			super.jSClick(ConfirmOrder_button());
//			wait.until(ExpectedConditions.visibilityOf(successPage.OrderPlaced_SuccessMessage()));
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
			ConfirmOrder_button().click();			
		}
	}
	
	
	public static double getDoubleFromStringAmount (String stringUpd) {
		double priceDouble= 0;
		String price1 = stringUpd.replace("$", "");
		priceDouble= Double.parseDouble(price1);
		return priceDouble;
	}
	
	/**
	 * This method gets the SubTotal String valuje and using getDoubleFromStringAmount convert it to double value 
	 * @return
	 */
	public double  getSubTotalAmount () {
		return  getDoubleFromStringAmount(ConfirmOrder_SubTotal_value().getText());								
	}
	
	public double  getFlatShippingRateAmount () {
		return  getDoubleFromStringAmount(ConfirmOrder_FlatShippingRate_value().getText());								
	}
	
	public double  getTotalAmount (String VAT) {
		return  getDoubleFromStringAmount(ConfirmOrder_Total_value(VAT).getText());								
	}
	
	public void validateConfirmOrderForm(double subTotal, double flatRate, double total ) {
		super.verifyEqualTexts(ConfirmOrder_ProductName_title(), "Product Name");
		super.verifyEqualTexts(ConfirmOrder_Model_title(), "Model");
		super.verifyEqualTexts(ConfirmOrder_Quantity_title(), "Quantity");
		super.verifyEqualTexts(ConfirmOrder_Price_title(), "Price");
		super.verifyEqualTexts(ConfirmOrder_Total_title(), "Total");
		
		
	}
	
	public ConfirmOrder_page() {
		
	}

}
