package Pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PagesEcommerce.base;

public class SHOPPING_CART_PAGE extends base {

	
	
	public WebElement shoppingCart_topLeftIcon() {
		return element = super.findElement("xpath", 
				"//li[@class='breadcrumb-item active']");
	
	}
	
	public WebElement ItemCheckoutGrid() {
		return element = super.findElement("xpath", 
				"//form[@action='https://ecommerce-playground.lambdatest.io/index.php?route=checkout/cart/edit']");
	
	}
	
	public WebElement ItemCheckoutGrid_quantityField() {
		return element = super.findElement("cssselector", 
				".flex-nowrap.input-group>input");
	
	}
	
	public WebElement ItemCheckoutGrid_IMAGE_title() {
		return element = super.findElement("xpath", 
				"/html[1]//table[1]/thead[1]/tr[1]/th[1]");
	
	}
	
	public WebElement ItemCheckoutGrid_PRODUCT_NAME_title() {
		return element = super.findElement("xpath", 
				"/html[1]//table[1]/thead[1]/tr[1]/th[2]");
	
	}
	
	public WebElement ItemCheckoutGrid_MODEL_title() {
		return element = super.findElement("xpath", 
				"/html[1]//table[1]/thead[1]/tr[1]/th[3]");
	
	}
	
	public WebElement ItemCheckoutGrid_QUANTITY_title() {
		return element = super.findElement("xpath", 
				"/html[1]//table[1]/thead[1]/tr[1]/th[4]");
	
	}
	
	public WebElement ItemCheckoutGrid_UNIT_PRICE_title() {
		return element = super.findElement("xpath", 
				"/html[1]//table[1]/thead[1]/tr[1]/th[5]");
	
	}
	
	public WebElement ItemCheckoutGrid_TOTAL_title() {
		return element = super.findElement("xpath", 
				"/html[1]//table[1]/thead[1]/tr[1]/th[6]");
	
	}
	
	public WebElement ItemCheckoutGrid_UpdateButton() {
		return element = super.findElement("xpath", 
				"//button[@data-original-title='Update']");
	
	}
	
	public WebElement ItemCheckoutGrid_RemoveButton() {
		return element = super.findElement("xpath", 
				"//button[@class='btn btn-danger']");
	
	}
	
	public WebElement ItemCheckout_TitleLink(String productName) {
		return element = super.findElement("xpath", 
				"//td[@class='text-left']//a[contains(text(),'"+productName+"')]");
	
	}
	
	public WebElement ItemCheckout_Image(String productName) {
		return element = super.findElement("xpath", 
				"//td[@class='text-center']//img[@title='"+productName+"']");
	
	}
	
	public WebElement ItemCheckout_MODEL (String model) {
		return element = super.findElement("xpath", 
				"//td[contains(text(),'"+model+"')]");
	
	}
	
	public WebElement ItemCheckout_UNIT_PRICE() {
		return element = super.findElement("xpath", 
				"/html//table[1]/tbody[1]/tr[1]/td[5]");
	
	}
	
	public WebElement ItemCheckout_TOTAL_PRICE() {
		return element = super.findElement("xpath", 
				"/html//table[1]/tbody[1]/tr[1]/td[6]");
	
	}
	
	public WebElement Message_EmptyCart() {
		return element = super.findElement("xpath", 
				"//div[@id='content']/p[.='Your shopping cart is empty!']");
	
	}
	
	public WebElement CheckoutButton() {
		return element = super.findElement("xpath", 
				"//a[@class='btn btn-lg btn-primary']");
	
	}
	
	public WebElement ContinueShoppingButton() {
		return element = super.findElement("xpath", 
				"//a[normalize-space()='Continue Shopping']");
	
	}
	
	public WebElement ContiniueButton() {
		return element = super.findElement("xpath", 
				"//div[@class='buttons']/a");
	
	}

	public void clickOnContinueButton () {
		try {
			wait = new WebDriverWait(driver, 4);
			super.movesToTheElement(ContiniueButton());
			super.jSClick(ContiniueButton());
			wait.until(ExpectedConditions.visibilityOf(homePage.topRowButtonsSection_shopByCattergory_Button()));
	
		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}

	}
	

	public void selectCheckout () {
		try {
			wait = new WebDriverWait(driver, 4);
			super.movesToTheElement(CheckoutButton());
			super.jSClick(CheckoutButton());
			wait.until(ExpectedConditions.visibilityOf(checkoutPage.Checkout_topLeftIcon()));
	
		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}

	}

	
	public void clickOnRemoveQuantity () {
		try {
			wait = new WebDriverWait(driver, 4);
			super.movesToTheElement(ItemCheckoutGrid_RemoveButton());
			super.jSClick(ItemCheckoutGrid_RemoveButton());
			wait.until(ExpectedConditions.visibilityOf(Message_EmptyCart()));
	
		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}

	}
	public double  getUnitPrice_ShoppingCartGrid_Value () {
		double UnitPrice_valueShoppingCart = 0;
		String unitPriceStringValueShoppingCart = ItemCheckout_UNIT_PRICE().getText();
		String unitPriceStringValueShoppingCartModified = unitPriceStringValueShoppingCart.replace("$", "");
		UnitPrice_valueShoppingCart= Double.parseDouble(unitPriceStringValueShoppingCartModified);			
		
		return UnitPrice_valueShoppingCart;		
		
	}
	
	public double  getTotal_ShoppingCartGrid_Value () {
		double Total_value_shoppingCartGrid = 0;
		String totalValue_shoppingCartGrid = ItemCheckout_TOTAL_PRICE().getText();
		String totalValue_shoppingCartGridModified = totalValue_shoppingCartGrid.replace("$", "");
		Total_value_shoppingCartGrid= Double.parseDouble(totalValue_shoppingCartGridModified);			
		
		return Total_value_shoppingCartGrid;		
		
	}
	
	
	public double  getSubTotalValue () {
		double SubTotalValue = 0;
		String subTotalValue = super.findElement
				("xpath", "/html[1]/body[1]/div[1]//div[2]/table[1]/tbody[1]/tr[1]/td[2]").getText();
		String subTotalModified = subTotalValue.replace("$", "");
		SubTotalValue= Double.parseDouble(subTotalModified);	
		
		return SubTotalValue;		
		
	}
	
	
	public double  getEcoTaxValue () {
		double EcoTaxValue = 0;
		String EcoTaxStringValue = super.findElement
				("xpath", "/html[1]/body[1]/div[1]//div[2]/table[1]/tbody[1]/tr[2]/td[2]/strong[1]").getText();
		String EcoTaxStringModified = EcoTaxStringValue.replace("$", "");
		EcoTaxValue= Double.parseDouble(EcoTaxStringModified);	
		
		return EcoTaxValue;		
		
	}
	
	public double  getVATValue () {
		double VatValueDouble = 0;
		String VatStringValue = super.findElement
				("xpath", "//body//div[2]/table[1]/tbody[1]/tr[3]/td[2]/strong[1]").getText();
		String VatStringValueModified = VatStringValue.replace("$", "");
		VatValueDouble= Double.parseDouble(VatStringValueModified);	
		
		return VatValueDouble;		
		
	}
	
	public double  getTotalValue (String VAT) {
		double TotalValue = 0;
		String TotalStringValue = null;
		switch (VAT) {
		case "VAT_YES":
			TotalStringValue = super.findElement
			("xpath", "//div[@class='row mb-3 align-items-end']//table[@class='table table-bordered m-0']/tbody/tr[4]/td[2]").getText();
			break;
		case "VAT_NO":
			TotalStringValue = super.findElement
			("xpath", "//div[@class='row mb-3 align-items-end']//table[@class='table table-bordered m-0']/tbody/tr[2]/td[2]").getText();
			break;
		default:
			break;
		}
		
		String TotalStringValueModified = TotalStringValue.replace("$", "");
		TotalValue= Double.parseDouble(TotalStringValueModified);	
		
		return TotalValue;		
		
	}
	
	
	
	public void shoppingCartPageComponentsVerify(String productName,String model,String quantity,String unitPrice,String totalPrice) {
		/** Grid Titles assertions
		 * */
		super.assertElementIsDisplayed(ItemCheckoutGrid());
		super.verifyEqualTexts(ItemCheckoutGrid_IMAGE_title(), "IMAGE");
		super.verifyEqualTexts(ItemCheckoutGrid_PRODUCT_NAME_title(), "PRODUCT NAME");
		super.verifyEqualTexts(ItemCheckoutGrid_MODEL_title(), "MODEL");
		super.verifyEqualTexts(ItemCheckoutGrid_QUANTITY_title(), "QUANTITY");
		super.verifyEqualTexts(ItemCheckoutGrid_UNIT_PRICE_title(), "UNIT PRICE");
		super.verifyEqualTexts(ItemCheckoutGrid_TOTAL_title(), "TOTAL");
		/**
		 * Grid values assertions
		 */
//		softAssert.assertTrue(ItemCheckout_Image(productName).isDisplayed());
//		softAssert.assertTrue(ItemCheckout_TitleLink(productName).isDisplayed());
//		softAssert.assertTrue(ItemCheckout_MODEL(model).isDisplayed());
//		softAssert.assertTrue(ItemCheckoutGrid_quantityField().getAttribute("value").equals(quantity));
//		softAssert.assertTrue(ItemCheckout_UNIT_PRICE().getText().equals(unitPrice));
//		softAssert.assertTrue(ItemCheckout_TOTAL_PRICE().getText().equals(totalPrice));		
		softAssert.assertAll();
	}
	

	public double assertTotalTop_value (double expectedPrice) {
		double TotalGridPrice = getTotal_ShoppingCartGrid_Value();
		System.out.println("TOTAL TOP VALUE : " + TotalGridPrice);		
		softAssert.assertEquals(TotalGridPrice, (expectedPrice));
		softAssert.assertAll();
		return TotalGridPrice;
		
	}
	
	public int assertEcoTaxValue (int expectedValue) {
		int EcoTaxValue = super.convertDoubleToInt(getEcoTaxValue());
		System.out.println("ECO TAX VALUE : " + EcoTaxValue);		
		softAssert.assertEquals(EcoTaxValue, (expectedValue));
		softAssert.assertAll();
		return EcoTaxValue;
		
	}
	
	
	public double assertTotalBottom_value (String VAT,double expectedValue) {
		double TotalBottomValue = getTotalValue(VAT);
		System.out.println("TOTAL BOTTOM VALUE" + TotalBottomValue);		
		softAssert.assertEquals(TotalBottomValue, (expectedValue));
		softAssert.assertAll();
		return TotalBottomValue;
		
	}

	public SHOPPING_CART_PAGE() {
		checkoutPage = new CHECKOUT_PAGE();
		homePage = new HOME_PAGE();
	}

}
