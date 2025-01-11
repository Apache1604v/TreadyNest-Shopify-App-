package org.Sample.PrashulOrange;

import org.openqa.selenium.By;

public interface ObjectRepository 
{
	public static By titlename = By.xpath("//p[@class='announcement-bar__message h5']");
	public static By productsList = By.xpath("//ul[@id='Slider-template--18930155028703__featured_collection']/li");
	public static By firstProduct = By.xpath("//h1[text()='Blue Bootcut Jeans']");
	public static By flashSaleText = By.id("prvw__block_title");
	public static By mostPopularOffer = By.id("prvw__label_2");
	public static By addToCartBtn = By.id("ProductSubmitButton-template--18930155192543__main");
	public static By Logobtn = By.cssSelector("//.header__heading-logo-wrapper");
	public static By Cartbtn = By.xpath("//*[text()='Cart']");
	public static By CartTitleText = By.cssSelector(".title.title--primary");
	public static By CheckOutBtn = By.xpath("//button[@id='checkout']");
	public static By EmailIpBox = By.id("email");	
	public static By FirstName = By.xpath("//input[@placeholder='First name (optional)']");
	public static By LastName = By.xpath("//input[@placeholder='Last name']");
	public static By Address = By.xpath("//input[@id='shipping-address1']");
	public static By ApartmentAdd = By.xpath("//input[@placeholder='Apartment, suite, etc. (optional)']");
	public static By City = By.xpath("//input[@placeholder='City']");
	public static By State = By.xpath("//select[@name='zone']");
	public static By PinCode = By.xpath("//input[@placeholder='PIN code']");
	public static By CreditCard = By.cssSelector(".yyi4ny1i.yyi4ny1h._1fragemmi._1fragem28._1fragem5k");
	public static By CodOrder = By.xpath("//span[text()='Cash on Delivery (COD)']");
	public static By CompleteOrder = By.xpath("//span[text()='Complete order']");
	public static By CompleteO = By.xpath("//button[@id='checkout-pay-button']");
	
}
