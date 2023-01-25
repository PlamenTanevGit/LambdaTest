package ShoppingTests;

import org.testng.annotations.Test;

import PagesEcommerce.DP;
import PagesEcommerce.base;

public class TESTS_ContinueShopping extends base {

	
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
		
		// click on Continue Button and return to Home page
		shoppingCartPage.clickOnContinueShoppingButton();
		
		// Assert the Home page title
		super.pageTitleVerify("Your Store");
	}

	
	
}
