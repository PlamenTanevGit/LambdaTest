package ShoppingTests;

import org.testng.annotations.Test;

import PagesEcommerce.DP;
import PagesEcommerce.base;

public class LAMBDA_TESTS_ShoppingCart extends base {


	@Test(alwaysRun = true,
			dataProviderClass = DP.class, dataProvider = "productInputs",
			description = "This test performs search product and verifies the found product")
	public void t1_shoppingCartVerificationAndRemoveProducts (String productName,String model,String quantity,String unitPrice,String totalPrice) throws InterruptedException {

		// navigate to home page
		baseUrl = config.getProperty("homePage");
		base.openUrl(baseUrl);

		// Enter product in the Search field and click on Search button
		homePage.enterProductInSearchField(productName);
		homePage.clickOnSearch();		
		
		//Hover on the desired Product (by number) and click on Add to cart
		searchResultPage.addToCart("1");		
		super.assertElementIsDisplayed(searchResultPage.AddToCart_popUp());
		super.verifyEqualTexts(searchResultPage.AddToCart_popUp_CheckOut_button(), "Checkout");
		super.verifyEqualTexts(searchResultPage.AddToCart_popUp_ViewCart_button(), "View Cart");
		
		//click on ViewCart and open the View Cart page
		searchResultPage.selectViewCart();
		super.pageTitleVerify("Shopping Cart");
		
		//Shopping Cart Grid and Components assertions for Displayed and Text
		shoppingCartPage.shoppingCartPageComponentsVerify( productName, model, quantity, unitPrice, totalPrice);
				
		// click on Remove button and clean the Quantity and Assert Displayed message
		shoppingCartPage.clickOnRemoveQuantity();
		super.assertElementIsDisplayed(shoppingCartPage.Message_EmptyCart());
		
	}

	
	@Test(alwaysRun = true,
			description = "This test performs search product and verifies the found product")
	public void t2_shopingCart_AddMultipleItemsVerification () throws InterruptedException {
		// Provide number of items that will be added in the Cart
		int numberOfAddedItems = 3;		
		
		baseUrl = config.getProperty("homePage");
		base.openUrl(baseUrl);

		// Enter product in the Search field and click on Search button
		homePage.enterProductInSearchField("HTC Touch HD");
		homePage.clickOnSearch();		
		
		// Get the Product price from Article as String
		String price = searchResultPage.getPriceFromArticle("1");
		
		// Convert the Price to double 
		double priceDouble = searchResultPage.getThePriceAmount(price);
		
		// Perform adding of N number of items in the Cart
		searchResultPage.addToCartMultipleItems("1",numberOfAddedItems);	
				
		
		/** Following 3 assertions are commented due fields have been removed from the form 
		 * */
		// ASSERTION - UNIT Price = chosen product captured price 
		softAssert.assertEquals(shoppingCartPage.getUnitPrice_ShoppingCartGrid_Value(), (priceDouble));
		// ASSERTION - Total Grid Price == UnitPrice * numberOfAddedItems
		softAssert.assertEquals(shoppingCartPage.getTotal_ShoppingCartGrid_Value(), (priceDouble*numberOfAddedItems));
		//ASSERTION - ECO Tax value
		softAssert.assertEquals(super.convertDoubleToInt(shoppingCartPage.getEcoTaxValue()), (numberOfAddedItems*2));		
		
		// ASSERTION GRID TOTAL amount == TOTAL amount at the order 
		softAssert.assertEquals(shoppingCartPage.getTotal_ShoppingCartGrid_Value(), shoppingCartPage.getTotalValue());		
		softAssert.assertAll();		
	}
	
	
	@Test(alwaysRun = true,
			dataProviderClass = DP.class, dataProvider = "productInputs",
			description = "This test performs search product and verifies the found product")
	public void t3_CheckoutItem (String fn,String ln,String em,String ph, String pass, 
			String cmpn, String addr1, String addr2, String city, String pc, String cntry, String rgn) throws InterruptedException {
		
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
		
		// Perform adding of N number of items in the Cart
		searchResultPage.addToCartMultipleItems("1",numberOfAddedItems);	
				
		/** Following 3 assertions are commented due fields have been removed from the form 
		 * */
		// ASSERTION - UNIT Price = chosen product captured price 
		softAssert.assertEquals(shoppingCartPage.getUnitPrice_ShoppingCartGrid_Value(), (priceDouble));
		// ASSERTION - Total Grid Price == UnitPrice * numberOfAddedItems
		softAssert.assertEquals(shoppingCartPage.getTotal_ShoppingCartGrid_Value(), (priceDouble*numberOfAddedItems));
		//ASSERTION - ECO Tax value
		softAssert.assertEquals(super.convertDoubleToInt(shoppingCartPage.getEcoTaxValue()), (numberOfAddedItems*2));		
		
		// ASSERTION GRID TOTAL amount == TOTAL amount at the order 
		softAssert.assertEquals(shoppingCartPage.getTotal_ShoppingCartGrid_Value(), shoppingCartPage.getTotalValue());		
		softAssert.assertAll();

		// Select the Checkout 
		shoppingCartPage.selectCheckout();			
		/**
		 * Issue ! ECO Tax and VAT changes on Checkout !
		 */		
		// ASSERTIONS ON THE CHECKOUT FORM LABELS AND FLAT VALUE
		
		
		// Fill Personal Details Side Form
		accountRegisterPage.addPersonalDetails(
				accountRegisterPage.firstName,
				accountRegisterPage.lastName,
				accountRegisterPage.email,
				accountRegisterPage.telephone,
				accountRegisterPage.password, 
				accountRegisterPage.password);
				
		// Fill AddBilling Address side form
		accountRegisterPage.addBillingAddress(
				accountRegisterPage.company,
				accountRegisterPage.address1, 
				accountRegisterPage.address2, 
				accountRegisterPage.city,
				accountRegisterPage.postCode, 
				accountRegisterPage.country,
				accountRegisterPage.region);		
		
		// Check the Privacy Policy and Terms and Conditions
		accountRegisterPage.checkPrivacyPolicy();
		accountRegisterPage.checkTermsAndConditions();
		// Click on Continue Order to go on the final page
		accountRegisterPage.clickOnContinueButton();
		
		// ASSERTIONS FOR THE CONFIRM ORDER SCREEN
		
		// CLICK ON PLACE ORDER
		
		// ASSERTIONS FOR PLACED ORDER
		
		//LOG OUT
		
		
		
	}
	

}
