package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Base;

public class PriceFilterPage extends Base{
	public PriceFilterPage(WebDriver driver){
		this.driver=driver;
	}
    
	By bestseller=By.cssSelector("input[name='field-keywords']");
	By priceList=By.xpath("//span[@class='a-badge-text']");
    By checkbox1=By.xpath("(//a[@aria-hidden='true'])[1]");
	By checkbox2=By.xpath("//span[text()=\"Computers & Accessories\"]");
	
	By checkbox3=By.xpath("//span[text()='Laptops']");
	
	By limitedtimedeallaptops=By.xpath("//a[@data-testid='product-card-link' and contains(@class,'a-spacing-mini')]");
	By product=By.xpath("//div[@role=\"presentation\" and .//span[contains(text(),\"%\")]]");
	By addtocart =By.xpath(".//button[contains(@aria-label,'Add to cart')]");
	By productname=By.xpath("//span[@style='height: 2.6em;']");
    By allplusButtons=By.xpath(".//button[contains(@aria-label,'Add to cart')]");
	

	public WebElement getbestseller() {
		return this.driver.findElement(bestseller);
	}
	public List<WebElement> getPriceList() {
		return this.driver.findElements(priceList);
	}
	public WebElement getcheckbox1() {
		return this.driver.findElement(checkbox1);
		
	}
	public WebElement getcheckbox2() {
		return this.driver.findElement(checkbox2);
		
	}
	public WebElement getcheckbox3() {
		return this.driver.findElement(checkbox3);
	}
	public List<WebElement> getlimitedtimedeallaptops() {
		return this.driver.findElements(limitedtimedeallaptops);
	}
		
		public WebElement getproduct() {
			// TODO Auto-generated method stub
			return this.driver.findElement(product);
		}
		public WebElement getaddtocart(WebElement product) {
			// TODO Auto-generated method stub
			
			return product.findElement(addtocart);
		}
		public List<WebElement> getallplusButtons() {
			return this.driver.findElements(allplusButtons);
		}
		public WebElement getproductname() {
			// TODO Auto-generated method stub
			return this.driver.findElement(productname);
		}
		
	

}

