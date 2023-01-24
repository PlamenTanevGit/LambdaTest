package PagesEcommerce;

import java.lang.reflect.Method;
import java.util.Random;

import org.testng.annotations.DataProvider;

public class DP {

	@DataProvider(name = "productInputs")
	public Object[][] getData(Method m) {
		
		if (m.getName().equals("t2_SearchField_verifyAutoSuggestResults")) {
			return new Object[][] { { "HTC Touch HD", 5 }, { "Palm Treo Pro", 2 },

			};
		}
		else if (m.getName().equals("t3_search_ProductInTheSearchFieldAndVerifyResults")) {
			return new Object[][] { { "Palm Treo Pro", "$337.99",2 }, { "HTC Touch HD", "$146.00",8 },

			};
		}
		else if (m.getName().equals("t1")) {
			return new Object[][] { { "HTC Touch HD" },

			};
		}
		
		else if (m.getName().equals("t1_shoppingCartVerificationAndRemoveProducts")) {
			return new Object[][] { { "HTC Touch HD","Product 1","1","$146.00","$146.00" },

			};
		}
		
		else if (m.getName().equals("t3_CheckoutItem")) {
			return new Object[][] { 
				{ 
				"firstName_"+base.randomString(3),
				"lastName_"+base.randomString(3),
				"email_"+base.randomString(3)+"@email.com", 
				"+359123123123",
				"pass"+base.randomString(3),
				"company_"+base.randomString(3),
				"address1_"+base.randomString(3),
				"address2_"+base.randomString(3),
				"Sofia",
				"1111",
				"Bulgaria",
				"Sofia",
				"VAT_NO"
				},
				
				{ 
				"firstName_"+base.randomString(3),
				"lastName_"+base.randomString(3),
				"email_"+base.randomString(3)+"@email.com", 
				"+359123123123",
				"pass"+base.randomString(3),
				"company_"+base.randomString(3),
				"address1_"+base.randomString(3),
				"address2_"+base.randomString(3),
				"Tirol",
				"9999",
				"Austria",
				"Tirol",
				"VAT_NO"
				},

			};
		}
		
		return new Object[][] { { "HTC Touch HD", 5 }, };
	}

	

}
