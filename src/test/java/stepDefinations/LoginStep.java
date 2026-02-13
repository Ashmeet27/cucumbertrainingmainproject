package stepDefinations;



import java.time.Duration;
import java.util.*;
import java.util.OptionalInt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import base.Base;
import io.cucumber.java.en.*;
import pageObjects.PriceFilterPage;
import pageObjects.ProductDiscount;

public class LoginStep extends Base{
	
	Select select;
	String string;
	PriceFilterPage priceFilterPage;
	JavascriptExecutor js=(JavascriptExecutor)driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	
	private static final Logger logger= (Logger) LogManager.getLogger(LoginStep.class);
	@Given("user is on Amazon home page")
	public void user_is_on_amazon_home_page() {
		try {
			logger.debug("Code has reached given method");
			driver.get(this.getUrl());
			logger.debug("URL is launched");
		driver.manage().window().maximize();
		logger.debug("Maximized happened");
		priceFilterPage=new PriceFilterPage(driver);
		Thread.sleep(5000);
		this.priceFilterPage.getbestseller().clear();
		this.priceFilterPage.getbestseller().sendKeys(string);;
		
		
//		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		}
		catch(Exception ex) {
			logger.fatal("Exception in given:"+ex.getMessage());
		}
		}
	
	@When("user searches for {string}")
	public void user_searches_for(String string) throws Exception {
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
////		WebDriverwait wait.until(ExpectedConditions.elementToBeClickable
//				(select=new Select(this.priceFilterPage.getbestseller())));
		WebElement searchBox= this.priceFilterPage.getbestseller();
		wait.until(ExpectedConditions.elementToBeClickable(searchBox));
		        searchBox.clear();
				searchBox.sendKeys(string);
				searchBox.sendKeys(Keys.ENTER);
				
		
    logger.debug("Price filter is selected");
    Thread.sleep(3000);
//    return wait.until((ExpectedConditions.visibilityOfElementLocated((By) searchBox));
	}
    catch(Exception ex) {
    	logger.fatal("Exception in when:"+ex.getMessage());
    	throw ex;
		
	}

	}
	@Then("limitedtimedeal search results should be displayed on Amazon")
	public void limitedtimedeal_search_results_should_be_displayed_on_amazon() {
try {
			
			List<WebElement>priceList= this.priceFilterPage.getPriceList();
			
			if(priceList.size()==0){
				 throw new AssertionError("No limited time deal laptops found");
				
				 }
//			System.out.println(" Limited time deal laptops found:"+priceList.size());
			priceList.get(0).click();
			this.priceFilterPage.getcheckbox1().click();
			this.priceFilterPage.getcheckbox2().click();
			Thread.sleep(5000);
			this.priceFilterPage.getcheckbox3().click();
//			Thread.sleep(4000);
//			this.priceFilterPage.getaddtocart().click();
			 logger.debug("limitedtimedeal laptops shown");
		}
		catch(Exception ex) {
			logger.fatal("Exception in :"+ex.getMessage());
			
		}
	}
	@Then("top {int} laptops with limited time deal")
	public void top_laptops_with_limited_time_deal(Integer int1) throws InterruptedException {
         Thread.sleep(5000);
//		wait.until(ExpectedConditions.visibilityOfAllElements(null));
			js.executeScript("window.scrollBy(0,300);");
			List<WebElement>limitedtimedeallaptops= this.priceFilterPage.getlimitedtimedeallaptops();
	
			List<ProductDiscount> productList=new ArrayList<ProductDiscount>();
			System.out.println("SIZE "+limitedtimedeallaptops.size());
			for(WebElement element:limitedtimedeallaptops)
			{
				Thread.sleep(3000);
				String discountValue=element.findElement(By.xpath(".//*[contains(@class,'a-size-mini')]")).getText();
			//	System.out.println(discountText);
				String numeric = discountValue.replaceAll("\\D+", "").trim();
				String discountText=element.findElement(By.xpath(".//*[contains(@style,'height: 2.6em;')]")).getText(); 
				if (numeric.isEmpty()) {
				    System.out.println("No discount found for: " + discountText);
				    continue;   // skip this product
				}
				 
				int discountValueInt = Integer.parseInt(numeric);
				
				
				productList.add(new ProductDiscount(discountText,discountValueInt));
				//System.out.println(discountValue);

			}
			for(ProductDiscount product:productList)
			{
//				System.out.println(product.getProductName()+"-"+product.getDiscount()+ "% off");
			}
			
			Collections.sort(productList,Comparator.comparingInt(ProductDiscount::getDiscount).reversed());
    System.out.println("Top 10 Laptops with maximum discount:");
    for(int i=0;i<Math.min(10,productList.size());i++){
    		
    	Thread.sleep(5000);
    	logger.debug("only 10 limitedtimedeal laptops are shown");
    		int discount=productList.get(i).getDiscount();
    		String discountname=productList.get(i).getProductName();
    		System.out.println((i+1)+"."+discountname+"-"+discount+"% OFF");
    		wait.until(ExpectedConditions.visibilityOfAllElements(limitedtimedeallaptops));
    }	
    		

    Actions actions = new Actions(driver);
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    List<WebElement> plusButtons=priceFilterPage.getallplusButtons();
    int count=Math.min(4,plusButtons.size());
    for (int i1 = 0; i1 < count; i1++) {
     if(i1==4) {
    	 ((JavascriptExecutor) driver)
         .executeScript("window.scrollBy(0,300);");
    	 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//button[contains(@aria-label,'Add to cart')]")));
    	 
     }
     if(i1>=plusButtons.size()) {
    	 break;
     }
        WebElement plus = plusButtons.get(i1);
      wait.until(ExpectedConditions.elementToBeClickable(plus));
        
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", plus);
     
        
       
        ((JavascriptExecutor) driver)
        .executeScript("arguments[0].click();", plus);
        System.out.println("Clicked product:"+i1);
          try {
        	WebElement closeBtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='a-button-text']"))
        			);
        closeBtn.click();
       wait.until(ExpectedConditions.invisibilityOf(closeBtn));
//        actions.moveToElement(plus).perform(); 
    System.out.println("closed");

		
    
    }
    
	
		catch(Exception ex) {
			logger.fatal("Exception in :"+ex.getMessage());
			continue;
		}}}}
