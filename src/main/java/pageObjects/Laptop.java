package pageObjects;

import org.openqa.selenium.WebElement;

import base.Base;

public class Laptop extends Base{
	public String name;
	public int discount;
	public WebElement addToCartBtn;
	
	public Laptop(String name,int discount,WebElement addToCartBtn ) {
		this.name=name;
		this.discount=discount;
		this.addToCartBtn=addToCartBtn;
	}
	public int getDiscount() {
		return discount;
	}

}
