package ShoppingTests;

import org.testng.annotations.Test;

import PagesEcommerce.DP;
import PagesEcommerce.base;

public class TESTS_PurchaseRegisteredAccount_VAT extends base {

	
	@Test(alwaysRun = true,
			description = "This test search for product then do a checkout by selection of country with VAT")
	public void CheckoutItem_With_VAT() throws InterruptedException {
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

		// Perform adding of N number of items in the Cart
		searchResultPage.addToCartMultipleItems("1", numberOfAddedItems);

		// ASSERTION - UNIT Price = chosen product captured price
		double UnitPricFromGrid = shoppingCartPage.getUnitPrice_ShoppingCartGrid_Value();
		softAssert.assertEquals(UnitPricFromGrid, (priceDouble));

		// ASSERTION - Total Grid Price == UnitPrice * numberOfAddedItems
		double TotalTopValue = shoppingCartPage.assertTotalTop_value((priceDouble * numberOfAddedItems));
		
		// ASSERTION - ECO Tax value
		shoppingCartPage.assertEcoTaxValue(numberOfAddedItems * 2);

		// ASSERTION Total Top Value == Total bottom value
		shoppingCartPage.assertTotalBottom_value("VAT_YES", TotalTopValue);	
		
		// Select the Checkout
		shoppingCartPage.selectCheckout();
		/**
		 * Issue ! ECO Tax and VAT changes on Checkout !
		 */
		// ASSERTIONS ON THE CHECKOUT FORM LABELS AND FLAT VALUE

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
		// Click on Continue Button and verifu landing on home page
		successPage.clickOnContinue_button();
		super.assertElementIsDisplayed(homePage.Search_Field());
	}

	
	
	
	
	
	
	
	
	
	
	
	
	/***
	 * NOT executing /DRAFTS/
	 */
	
	
	@Test (enabled =   false)
	public void ggg() {
		System.out.println(accountRegisterPage.getSubTotalAmount());
		System.out.println(accountRegisterPage.getFlatShippingRateAmmount());
		System.out.println(accountRegisterPage.getEcoTaxAmount());
		System.out.println(accountRegisterPage.getVATAmount());
		System.out.println(accountRegisterPage.getTotalAmount("VAT_NO"));

		System.out.println(confirmOrderPage.getSubTotalAmount());
		System.out.println(confirmOrderPage.getFlatShippingRateAmount());
		System.out.println(confirmOrderPage.getTotalAmount("VAT_NO"));
	}

	@Test(enabled = false, dataProviderClass = DP.class, dataProvider = "productInputs", description = "This test performs search product and verifies the found product")
	public void TBD(String fn, String ln, String em, String ph, String pass, String cmpn, String addr1, String addr2,
			String city, String pc, String cntry, String rgn, String VAT) throws InterruptedException {

		accountRegisterPage.firstName = fn;
		accountRegisterPage.lastName = ln;
		accountRegisterPage.email = em;
		accountRegisterPage.telephone = ph;
		accountRegisterPage.password = pass;
		accountRegisterPage.confrimPassword = pass;
		accountRegisterPage.company = cmpn;
		accountRegisterPage.address1 = addr1;
		accountRegisterPage.address2 = addr2;
		accountRegisterPage.city = city;
		accountRegisterPage.postCode = pc;
		accountRegisterPage.country = cntry;
		accountRegisterPage.region = rgn;
		accountRegisterPage.VAT = VAT;

		// Provide number of items that will be added in the Cart
		int numberOfAddedItems = 1;

		baseUrl = config.getProperty("homePage");
		base.openUrl(baseUrl);

		// Enter product in the Search field and click on Search button
		homePage.enterProductInSearchField("HTC Touch HD");
		homePage.clickOnSearch();

		// Get the Product price from Article as String
		String price = searchResultPage.getPriceFromArticle("1");

		// Convert the Price to double
		double priceDouble = searchResultPage.getThePriceAmount(price);
		System.out.println("DOUBLE PRICE" + priceDouble);

		// Perform adding of N number of items in the Cart
		searchResultPage.addToCartMultipleItems("1", numberOfAddedItems);

		// ASSERTION - UNIT Price = chosen product captured price
		softAssert.assertEquals(shoppingCartPage.getUnitPrice_ShoppingCartGrid_Value(), (priceDouble));
		// ASSERTION - Total Grid Price == UnitPrice * numberOfAddedItems
		softAssert.assertEquals(shoppingCartPage.getTotal_ShoppingCartGrid_Value(), (priceDouble * numberOfAddedItems));
		System.out.println("Total Grid Price" + shoppingCartPage.getTotal_ShoppingCartGrid_Value());

		// ASSERTION - ECO Tax value
		softAssert.assertEquals(super.convertDoubleToInt(shoppingCartPage.getEcoTaxValue()), (numberOfAddedItems * 2));

		// ASSERTION GRID TOTAL amount == TOTAL amount at the order
		softAssert.assertEquals(shoppingCartPage.getTotal_ShoppingCartGrid_Value(),
				shoppingCartPage.getTotalValue("VAT_NO"));
		softAssert.assertAll();
		System.out.println("GRID TOTAL : " + shoppingCartPage.getTotal_ShoppingCartGrid_Value());
		System.out.println("SHOPPING CART TOTAL VALUE " + shoppingCartPage.getTotalValue("VAT_NO"));
		// Select the Checkout
		shoppingCartPage.selectCheckout();
		/**
		 * Issue ! ECO Tax and VAT changes on Checkout !
		 */
		// ASSERTIONS ON THE CHECKOUT FORM LABELS AND FLAT VALUE

		// Fill Personal Details Side Form
		accountRegisterPage.addPersonalDetails(accountRegisterPage.firstName, accountRegisterPage.lastName,
				accountRegisterPage.email, accountRegisterPage.telephone, accountRegisterPage.password,
				accountRegisterPage.password, "RegisteredAccount");

		// Fill AddBilling Address side form
		accountRegisterPage.addBillingAddress(accountRegisterPage.company, accountRegisterPage.address1,
				accountRegisterPage.address2, accountRegisterPage.city, accountRegisterPage.postCode,
				accountRegisterPage.country, accountRegisterPage.region);

		// Check the Privacy Policy and Terms and Conditions
		accountRegisterPage.checkPrivacyPolicy();
		accountRegisterPage.checkTermsAndConditions();

		// Get The Values from the Checkout Screen and then compare them with confirm
		// order screen

		// Click on Continue Order to go on the final page
//		accountRegisterPage.clickOnContinueButton();

		// ASSERTIONS FOR THE CONFIRM ORDER SCREEN

		// Assert Product Name,Model,Quantity,Price,Total - labels

		// Assert Total1

		// Assert Sub-Total

		// Assert Flat Shipping Rate = 5

		// Assert Total2
		double TotalCheckoutAmmount =

				(confirmOrderPage.getSubTotalAmount() + confirmOrderPage.getFlatShippingRateAmount()
						+ confirmOrderPage.getTotalAmount(accountRegisterPage.VAT));
		System.out.println("SubTotalAmount " + confirmOrderPage.getSubTotalAmount());
		System.out.println("FlatShippingRateAmount " + confirmOrderPage.getFlatShippingRateAmount());
		System.out.println("TotalAmount" + confirmOrderPage.getTotalAmount(accountRegisterPage.VAT));
		softAssert.assertEquals(TotalCheckoutAmmount, shoppingCartPage.getTotalValue("VAT_NO"));

		/***
		 * At the Confirm Order Screen Eco tax is +1 item VAT value is different
		 */

		// CLICK ON CONFIRM ORDER

		// ASSERTIONS FOR PLACED ORDER

		// LOG OUT
//		topHeader.logOut();

	}
}
