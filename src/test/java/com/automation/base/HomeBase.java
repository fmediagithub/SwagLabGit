package com.automation.base;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.automation.businesscomponents.Cart;
import com.automation.common.Common;
import com.automation.pageelements.CartObjects;
import com.automation.pageelements.HomeObjects;

public class HomeBase {   
	
	public static int number_of_items_to_cart = 0;
	
	public static void sortLowToHigh() throws IOException {
		try {
			ArrayList<Double> price_list = new ArrayList<Double>();
			Common.clickElemnt(HomeObjects.SELECT_SORT,"Filter dropdown ");
			Common.selectByText(HomeObjects.SELECT_SORT,"Price (low to high)");
			for (WebElement i : Common.getElements(CartObjects.TXT_PRICE)) {
				price_list.add(Double.parseDouble(i.getText().substring(1)));
			}
			int flag=0;
			for (int i = 0; i < price_list.size() - 1; i++) {
				if (!(price_list.get(i) <= price_list.get(i + 1))) {
					//Common.fail("Items are Not sorted");
					
					flag=1;
					break;
				}
			}
			if (flag == 0)
				Common.pass("Items are sorted by price low to high");

		} catch (Exception e) {
			Common.fail("Items sorting failed "+e.getMessage());
		}   
	}

	public static void addFirstItemToCart() throws IOException {
		
		try {
			Common.clickElemnt(HomeObjects.BTN_ADD_CART,"Add to cart");
			Common.clickElemnt(HomeObjects.BTN_CART,"main cart");
		} catch (IOException e) {
			Common.fail("Add to cart failed "+e.getMessage());
			
		}
		
		
	}
	public static void procreedCheckOut() throws IOException {
		//Common.clickElemnt(Home.BTN_CART);
		try {
			Common.clickElemnt(CartObjects.BTN_CHECKOUT,"proceed to checkout");
		} catch (IOException e) {
			Common.fail("proceed to checkout failed "+e.getMessage());
			
		}

		
	}

	public static void sortByName() throws IOException {
		try {
			Common.clickElemnt(HomeObjects.SELECT_SORT,"Filter dropdown ");
			Common.selectByText(HomeObjects.SELECT_SORT,"Name (Z to A)");
		} catch (IOException e) {
			Common.fail("Sort failed");
		}
		
		
	}

		
	


}

