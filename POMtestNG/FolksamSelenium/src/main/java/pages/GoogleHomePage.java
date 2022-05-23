package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {
	WebDriver driver;
	
	public GoogleHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By searchInput = By.xpath("//input[@name='q']");
	By acceptCookies = By.xpath("//*[@id=\"L2AGLb\"]/div");
	
	public void goToHomePage() {
		driver.get("https://www.google.com");
	}
	
	public void acceptCookies() {
		driver.findElement(acceptCookies).click();
	}
	
	public void searchKeyword(String keyword) {
		driver.findElement(searchInput).sendKeys(keyword, Keys.ENTER);
	}
}
