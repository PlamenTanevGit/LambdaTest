package ShoppingTests;

import org.testng.annotations.Test;

import PagesEcommerce.DP;
import PagesEcommerce.base;

public class TESTS_DirectCheckout extends base {

	
	@Test(alwaysRun = true,
			description = "The test performs Add to Cart and Direct Checkout ")
	public void DirectCheckoutItem_With_VAT() throws InterruptedException {
		
		// Provide number of items that will be added in the Cart
		int numberOfAddedItems = 1;
		String productPrice = null;

		baseUrl = config.getProperty("homePage");
		base.openUrl(baseUrl);

		// Enter product in the Search field and click on Search button
		homePage.enterProductInSearchField(or.getProperty("product1"));
		homePage.clickOnSearch();

		// Get the Product price from Article as String
		productPrice = searchResultPage.getPriceFromArticle("1");

		// Convert the Price to double
		double priceDouble = searchResultPage.getThePriceAmount(productPrice);

		// Perform CHECKOUT DIRECT of N number of items in the Cart		
		searchResultPage.checkoutMultipleItems("1", numberOfAddedItems);

		// ASSERTION - UNIT Price = chosen product captured price
		double UnitPricFromGrid = shoppingCartPage.getUnitPrice_ShoppingCartGrid_Value();
		softAssert.assertEquals(UnitPricFromGrid, (priceDouble));

		// Fill Personal Details Side Form
		accountRegisterPage.fillPersonalAndAddressData(
				or.getProperty("country3"),
				or.getProperty("city3"),
				"RegisteredAccount");
		
		// ASSERTION VAT is displayed
		super.verifyEqualTexts(checkoutPage.VAT_label(), "VAT (20%):");
				
		// click on inner Update button to update the info
		checkoutPage.clickOnUpdate_button();

		// Check the Privacy Policy and Terms and Conditions
		accountRegisterPage.checkPrivacyPolicy();
		accountRegisterPage.checkTermsAndConditions();
		/**
		 *  Get from checkout screen 
		 *   - Sub-Total
		 *   - Flat shipping rate
		 */
		double subTotal_midCheckout  = accountRegisterPage.getSubTotalAmount();
		double flatShippingRate_midCheckout  = accountRegisterPage.getFlatShippingRateAmmount();
		
		// Click on Continue and open ConfrimOrderScreen
		accountRegisterPage.clickOnContinueButton();
		/**
		 *  Get from checkout screen 
		 *   - Sub-Total
		 *   - Flat shipping rate
		 */
		double subTotal_confirmOrder = confirmOrderPage.getSubTotalAmount();
		double flatShippingRate_confirmOrder = confirmOrderPage.getFlatShippingRateAmount();
		
		// ASSERT VALUES for sub-total and Flat shipping rate are same from both screens
		softAssert.assertEquals(subTotal_midCheckout, subTotal_confirmOrder);
		softAssert.assertEquals(flatShippingRate_midCheckout, flatShippingRate_confirmOrder);
		/***
		 *  issue / difference in the Total price from midCheckout and ConfrimOrder screen
		 */
		softAssert.assertAll();
		
		// Click on Confirm Order and assert the Confirm screen 
		confirmOrderPage.ConfirmOrder();
		// Click on Continue Button and verify landing on home page
		successPage.clickOnContinue_button();
		super.assertElementIsDisplayed(homePage.Search_Field());
	}
	
}
