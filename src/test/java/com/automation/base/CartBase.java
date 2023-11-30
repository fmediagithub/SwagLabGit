package com.automation.base;

import java.io.IOException;

import org.testng.Assert;

import com.automation.common.Common;
import com.automation.pageelements.CartObjects;

public class CartBase {
	public static void checkOutItems() throws IOException {
		try {
			Common.clickElemnt(CartObjects.BTN_CHECKOUT,"proceed to checkout");
			Common.enterText(CartObjects.INPUT_FIRSTNAME, Common.getDatFromExcel("First Name"),"First Name");
			Common.enterText(CartObjects.INPUT_LASTNAME, Common.getDatFromExcel("Seconed Name"),"Seconed Name");
			Common.enterText(CartObjects.INPUT_ZIPCODE, Common.getDatFromExcel("Pincode"),"Pincode");
			Common.clickElemnt(CartObjects.BTN_CONTINUE,"continue");
			Common.clickElemnt(CartObjects.BTN_FINISH,"finish");
			String msg=Common.getText(CartObjects.TXT_ORDER_SUCCESS_MSG);
			String expected_string="Thank you for your order!";
			if(msg.equals(expected_string))
				Common.pass("Order placed successfully");
			else {
				Common.fail("order failed");
				
				
			}
			
		} catch (Exception e) {
			Common.fail("order failed");
			Common.info(e.getMessage());
		}
		


	}

}
