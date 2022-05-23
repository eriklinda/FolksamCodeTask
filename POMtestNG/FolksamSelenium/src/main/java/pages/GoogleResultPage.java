package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleResultPage {
	WebDriver driver;

	By firstResult= By.xpath("//div[@class='g']//h3");
	
	public GoogleResultPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public  void goToFirstResult() {
		driver.findElement(firstResult).click();
	}
	
}
