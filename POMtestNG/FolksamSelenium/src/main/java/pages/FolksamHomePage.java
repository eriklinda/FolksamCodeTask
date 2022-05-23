package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FolksamHomePage {
	WebDriver driver;
	
	By acceptCookies = By.id("onetrust-accept-btn-handler");
	By homeInsurance = By.xpath("//*[@id=\"main\"]/section[1]/div[1]/div/div/div/ul/li[2]/a");
		
	public FolksamHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void acceptCookies() {
		driver.findElement(acceptCookies).click();
	}
	
	public void goToHomeInsurance() {
		driver.findElement(homeInsurance).click();
	}
}
