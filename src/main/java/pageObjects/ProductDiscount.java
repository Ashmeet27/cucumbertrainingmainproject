package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.Base;

public class ProductDiscount extends Base{
	public String productName;
	public int discount;
	

	
	
	public String getProductName() {
		return productName;
	}




	public void setProductName(String productName) {
		this.productName = productName;
	}




	public int getDiscount() {
		return discount;
	}




	public void setDiscount(int discount) {
		this.discount = discount;
	}




	public ProductDiscount(String productName,int discount) {
		this.productName=productName;
		this.discount=discount;
	}




	public ProductDiscount(WebElement element, String discountText, int discountValueInt) {
		this.productName=productName;
		this.discount=discount;
		// TODO Auto-generated constructor stub
	}

	

	
}
