package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FolksamHomeInsurance {
	WebDriver driver;
	
	By insuranceTextBox = By.xpath("//*[@id=\"main\"]/div[2]/div[1]/section/div/div");
		
	public FolksamHomeInsurance(WebDriver driver) {
		this.driver = driver;
	}
	
	public String findInsuranceText() {
		String insuranceText = driver.findElement(insuranceTextBox).getText();
		return insuranceText;
	}
}
