package com.automation.businesscomponents;

import java.io.IOException;

import org.testng.annotations.Test;

import com.automation.base.HomeBase;
import com.automation.common.Common;

public class Home {
	@Test(priority = 1)
	public void sortItemsByName() throws IOException {
		Common.createTestName("Test case - Sort Items By Name");
		HomeBase.sortByName();
		

	}
	@Test(priority = 2)
	public void sortItemsByPrice() throws IOException {
		Common.createTestName("Test case - Price Sort Low-High");
		HomeBase.sortLowToHigh();
		
	}

	@Test(priority = 3)
	public void addItemToCart() throws IOException {
		Common.createTestName("Test case - Add lowest price item to Cart");
		HomeBase.addFirstItemToCart();

	}
}
