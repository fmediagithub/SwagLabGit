package com.automation.pageelements;

import org.openqa.selenium.By;

public class CartObjects {
	public static final By TXT_PRICE=By.xpath("//div[@class='inventory_item_price']");
	public static final By BTN_CHECKOUT=By.xpath("//button[@id='checkout']");
	public static final By INPUT_FIRSTNAME=By.id("first-name");
	public static final String BTN_REMOVE="(//div[@class='inventory_item_price']/following-sibling::button)[%d]";
	public static final By INPUT_LASTNAME=By.id("last-name");
	public static final By INPUT_ZIPCODE=By.id("postal-code");
	public static final By BTN_CONTINUE=By.xpath("//input[@id='continue']");
	public static final By BTN_FINISH=By.xpath("//button[@id='finish']");
	public static final By TXT_ORDER_SUCCESS_MSG=By.xpath("//h2");
	public static final By BTN_HOME=By.xpath("//button[@id='back-to-products']");
}
