package ShoppingTests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PagesEcommerce.DP;
import PagesEcommerce.base;

public class TESTS_HomePage extends base {

//	String searchedProduct = "HTC";
//	int searchedProductSize = 5;


	@Test(enabled = true, description = "The Test verifies the main components on the Home Page")
	public void t1_verify_HomePageElements() throws InterruptedException {
		// navigate to home page
		baseUrl = config.getProperty("homePage");
		base.openUrl(baseUrl);

		// verify main components on the page are displayed
		homePage.homePageComponentsVerify();

		// Open the side bar
		homePage.openTopCategoriesSideBar();

		// Verify all Options Components in the Top Categories Side bar
		String[] elements = { "Components", "Cameras", "Phone, Tablets & Ipod", "Software", "MP3 Players",
				"Laptops & Notebooks", "Desktops and Monitors", "Printers & Scanners", "Mice and Trackballs",
				"Fashion and Accessories", "Beauty and Saloon", "Autoparts and Accessories", "Washing machine",
				"Gaming consoles", "Air conditioner", "Web Cameras" };

		List<WebElement> Str = super.getElementList(
				"//div[@id='widget-navbar-217841']//ul[@class='navbar-nav vertical']//span", "xpath");

		for (int i = 0; i < elements.length; i++) {
			System.out.println(Str.get(i).getText());
			Assert.assertEquals(elements[i], Str.get(i).getText());

		}

	}

	@Test(enabled = true, dataProviderClass = DP.class, dataProvider = "productInputs", description = "This Test will enter a product in the search field and confirm auto suggested results, test is executed with 2 sets of data")
	public void t2_SearchField_verifyAutoSuggestResults(String product, int numberOfResults)
			throws InterruptedException {
		// navigate to home page
		baseUrl = config.getProperty("homePage");
		base.openUrl(baseUrl);

		// Enter product in the Search field
		homePage.enterProductInSearchField(product);
		

		// Verify products appear as suggestions
		List<WebElement> Str = super.getElementList(
				"//div[@id='entry_217822']//ul[@class='dropdown-menu autocomplete w-100']/li", "xpath");

		// Assertion for result search is equal to 5 products listed
		Assert.assertTrue(Str.size() == numberOfResults);

		// Loop through results and assert all of them contain the searched product name
		for (int i = 0; i < Str.size(); i++) {
			System.out.println(Str.get(i).getText());
			Assert.assertTrue(Str.get(i).getText().contains(product));

		}

	}

	@Test(enabled = true,
			dataProviderClass = DP.class, dataProvider = "productInputs",
			description = "This test performs search product and verifies the found product")
	public void t3_search_ProductInTheSearchFieldAndVerifyResults(String productName, String price, int size) throws InterruptedException {

		// navigate to home page
		baseUrl = config.getProperty("homePage");
		base.openUrl(baseUrl);

		// Enter product in the Search field and click on Search button
		homePage.enterProductInSearchField(productName);
		homePage.clickOnSearch();

		// Verify Search result page components 
		searchResultPage.searchResultPageComponenetsVerify();
		
		// Verify Search Title updates with the searched Product
		softAssert.assertTrue(searchResultPage.SearchPage_SearchResult_title(productName).getText().equals("Search - "+productName));
		softAssert.assertAll();

		// Verify products appear as suggestions
		List<WebElement> Str = super.getElementList("//div[@class='row']/div", "xpath");

		// Assertion for result size after the search
		Assert.assertTrue(Str.size() == size);

		// Loop through the results by provided Elements locator
		//and Assert the results contain specific text
		for (int i = 0; i < Str.size(); i++) {
			System.out.println(Str.get(i).getText());
			Assert.assertTrue(Str.get(i).getText().contains(productName));
			Assert.assertTrue(Str.get(i).getText().contains(price));
		}

	}
	
	@Test (enabled = false)	
	public void t5 () {		
			System.out.println(System.getProperty("user.dir"));
	}

}
