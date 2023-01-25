package ShoppingTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import PagesEcommerce.DP;
import PagesEcommerce.base;

public class TESTS_ShoppingCartAddRemoveItems extends base {

	/**
	 * Tests in this class are for NON Registered User
	 */

	@Test(alwaysRun = true, dataProviderClass = DP.class, dataProvider = "productInputs", description = "This test performs search product and verifies the found product")
	public void t1_shoppingCartVerificationAndRemoveProducts(String productName, String model, String quantity,
			String unitPrice, String totalPrice) throws InterruptedException {

		// navigate to home page
		baseUrl = config.getProperty("homePage");
		base.openUrl(baseUrl);

		// Enter product in the Search field and click on Search button
		homePage.enterProductInSearchField(productName);
		homePage.clickOnSearch();

		// Hover on the desired Product (by number) and click on Add to cart
		searchResultPage.addToCart("1");
		super.assertElementIsDisplayed(searchResultPage.AddToCart_popUp());
		super.verifyEqualTexts(searchResultPage.AddToCart_popUp_CheckOut_button(), "Checkout");
		super.verifyEqualTexts(searchResultPage.AddToCart_popUp_ViewCart_button(), "View Cart");

		// click on ViewCart and open the View Cart page
		searchResultPage.selectViewCart();
		super.pageTitleVerify("Shopping Cart");

		// Shopping Cart Grid and Components assertions for Displayed and Text
		shoppingCartPage.shoppingCartPageComponentsVerify(productName, model, quantity, unitPrice, totalPrice);

		// click on Remove button and clean the Quantity and Assert Displayed message
		shoppingCartPage.clickOnRemoveQuantity();
		super.assertElementIsDisplayed(shoppingCartPage.Message_EmptyCart());

	}

	
	@Test(alwaysRun = true, description = "This test performs search product and verifies the found product")	
	public void t2_shopingCart_AddMultipleItemsVerification() throws InterruptedException {
		// Provide number of items that will be added in the Cart
		int numberOfAddedItems = 3;
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

		// Assertion Total Top Value == Total bottom value
		shoppingCartPage.assertTotalBottom_value("VAT_YES", TotalTopValue);

		// Click on Remove button to Empty the Cart
		shoppingCartPage.clickOnRemoveQuantity();
		shoppingCartPage.clickOnContinueButton();
	}

	
}
