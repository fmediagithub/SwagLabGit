package com.automation.businesscomponents;

import java.io.IOException;

import org.testng.annotations.Test;

import com.automation.base.CartBase;
import com.automation.common.Common;

public class Cart {

	@Test(priority = 1)
	public void checkOut() throws IOException {
		Common.createTestName("Test case - Place order");
		CartBase.checkOutItems();

	}

}
