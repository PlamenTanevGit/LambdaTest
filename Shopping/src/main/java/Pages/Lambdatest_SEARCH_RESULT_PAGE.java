package Pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PagesEcommerce.base;

public class Lambdatest_SEARCH_RESULT_PAGE extends base {

	public WebElement SearchPage_topLeftIcon() {
		return element = super.findElement("xpath",
				"//li[@class='breadcrumb-item active']");
	}

	public WebElement SearchPage_FILTER_title() {
		return element = super.findElement("xpath",
				"//h3[normalize-space()='Filter']");
	}
	
	public WebElement SearchPage_FILTER_Price_title() {
		return element = super.findElement("xpath",
				"(//div[contains(@class,'mz-filter-group-header')][normalize-space()='Price'])[2]");
	}
	
	public WebElement SearchPage_FILTER_Manufacturer_title() {
		return element = super.findElement("xpath",
				"//div[@id='mz-filter-content-0']//div[contains(@class,'mz-filter-group-header')][normalize-space()='Manufacturer']");
	}
	
	public WebElement SearchPage_FILTER_Search_title() {
		return element = super.findElement("xpath",
				"//div[@id='mz-filter-content-0']//div[contains(@class,'mz-filter-group-header')][normalize-space()='Search']");
	}
	
	public WebElement SearchPage_FILTER_Color_title() {
		return element = super.findElement("xpath",
				"//div[@id='mz-filter-content-0']//div[contains(@class,'mz-filter-group-header')][normalize-space()='Color']");
	}
	
	public WebElement SearchPage_FILTER_Availability_title() {
		return element = super.findElement("xpath",
				"//div[@id='mz-filter-content-0']//div[@class='mz-filter-group-header '][normalize-space()='Availability']");
	}
	
	public WebElement SearchPage_FILTER_Dicount_title() {
		return element = super.findElement("xpath",
				"//div[@id='mz-filter-content-0']//div[contains(@class,'mz-filter-group-header')][normalize-space()='Discount']");
	}
	
	public WebElement SearchPage_FILTER_Rating_title() {
		return element = super.findElement("xpath",
				"//div[@id='mz-filter-content-0']//div[contains(@class,'mz-filter-group-header')][normalize-space()='Rating']");
	}
	
	
	public WebElement SearchPage_SearchResult_title(String product) {
		return element = super.findElement("xpath",
				"//h1[normalize-space()='Search - "+product+"']");
	}
	
	public WebElement SearchPage_SearchResult_ProductListItem(String productNum) {
		return element = super.findElement("xpath",
				"//body/div[@class='mz-pure-container']/div[@id='container']/div[@id='product-search']/div[@id='entry_212453']/div[@id='entry_212454']/div[@id='entry_212455']/div[@id='entry_212469']/div[@class='row']/div["+productNum+"]");
	}	
	
	public WebElement SearchPage_ProductList_AddToCart_button() {
		return element = super.findElement("xpath",
				"//button[@class='btn btn-cart cart-28']");
	}
	
	public WebElement AddToCart_popUp() {
		return element = super.findElement("xpath",
				"//div[@id='notification-box-top']");
	}
	
	public WebElement AddToCart_popUp_ViewCart_button() {
		return element = super.findElement("xpath",
				"//div[@id='notification-box-top']//a[normalize-space()='View Cart']");
	}
	
	public WebElement AddToCart_popUp_CheckOut_button() {
		return element = super.findElement("xpath",
				"//div[@id='notification-box-top']//a[normalize-space()='Checkout']");
	}

	public void addToCartMultipleItems(String itemNumber, int itemsNumber) throws InterruptedException {
		try {
			super.movesToTheElement(SearchPage_SearchResult_ProductListItem("1"));
			for (int i = 0; i < itemsNumber; i++) {
				super.jSClick(SearchPage_ProductList_AddToCart_button());
				Thread.sleep(150);			
			}
			super.jSClick(AddToCart_popUp_ViewCart_button());		
	
		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}

	}
	
	public void addToCart(String itemNumber) {
		try {
			wait = new WebDriverWait(driver, 4);
			super.movesToTheElement(SearchPage_SearchResult_ProductListItem(itemNumber));
			super.jSClick(SearchPage_ProductList_AddToCart_button());
			wait.until(ExpectedConditions.visibilityOf(AddToCart_popUp()));
	
		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}

	}
	
	public void selectViewCart() {
		
		try {
			wait = new WebDriverWait(driver, 4);
			super.movesToTheElement(AddToCart_popUp_ViewCart_button());
			super.jSClick(AddToCart_popUp_ViewCart_button());			
			wait.until(ExpectedConditions.visibilityOf(shoppingCartPage.shoppingCart_topLeftIcon()));
	
		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}

	}
	
	public String getPriceFromArticle (String artcileNumber) {		
		return super.findElement
	("xpath", "//div[@class='row']//div[1]//div[1]//div[2]//div[1]//span["+artcileNumber+"]").getText();
		
	}
	
	public double getThePriceAmount (String price) {
		double priceDouble= 0;
		String price1 = price.replace("$", "");
		priceDouble= Double.parseDouble(price1);
		return priceDouble;
	}
	
	
	
	public void searchResultPageComponenetsVerify() {
		base.assertElementIsDisplayed(SearchPage_topLeftIcon());
		softAssert.assertTrue(SearchPage_FILTER_title().getText().equals("FILTER"));
		softAssert.assertTrue(SearchPage_FILTER_Price_title().getText().equals("PRICE"));
		softAssert.assertTrue(SearchPage_FILTER_Manufacturer_title().getText().equals("MANUFACTURER"));
		softAssert.assertTrue(SearchPage_FILTER_Search_title().getText().equals("SEARCH"));
		softAssert.assertTrue(SearchPage_FILTER_Color_title().getText().equals("COLOR"));
		softAssert.assertTrue(SearchPage_FILTER_Availability_title().getText().equals("AVAILABILITY"));
		softAssert.assertTrue(SearchPage_FILTER_Dicount_title().getText().equals("DISCOUNT"));
		softAssert.assertTrue(SearchPage_FILTER_Rating_title().getText().equals("RATING"));
			
		softAssert.assertAll();
	}

	public Lambdatest_SEARCH_RESULT_PAGE() {
		shoppingCartPage = new Lambdatest_SHOPPING_CART_PAGE();
	}

}
