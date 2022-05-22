package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		// Specificerar vart chromerdriver finns, vill helst inte hårdkoda, så valde att lägga chromedriver i en mapp som finns i projektet
		// Filsökvägen hittas då med hjälp av ett anrop som talar om vilket "current workdirectory" vi är i, sedan lägger till sökvägen till chromedriver
		System.setProperty("webdriver.chrome.driver", String.format("%s/resources/chromedriver", System.getProperty("user.dir")));
		
		// Deklarerar en webdriver som ska användas till att slutföra uppgiften
		WebDriver driver = new ChromeDriver();
		// Lägger till att webbläsaren ska vänta i 10 sekunder ifall att elementet inte har hunnit renderat
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Sedan navigerar vi till Googles startsida!
		driver.navigate().to("https://www.google.com/");
		// Accepterar cookies ifrån Google
		driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
		
		// Skriver in Folksam i sökfältet och "trycker på" Enter-tangenten
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("folksam", Keys.ENTER);
		
		
		// Första h3-elementet som kommer upp är första "titeln" bland alla sökresultat
		// Det finns massor av sätt att välja första sökresultatet men eftersom uppgiften bara var att klicka på första resultatet fungerar det här sättet utmärkt
		driver.findElement(By.tagName("h3")).click();
		
		
		
		
		// I det här skedet ska vi ha hamnat på Folksams hemsida, vilket bör vara det första resultatet
		// Vi accepterar även Folksams cookies
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		
		// Valt att lägga in alla försäkringar som visas i en List
		// Sedan en for loop igenom listan för att kolla ifall "Hemförsäkring" finns i listan, om den gör det ska den trycka på den
		List<WebElement> insurances = driver.findElement(By.className("primary-pathways__list")).findElements(By.tagName("li"));
		for (int i = 0; i < insurances.size(); i++) {
			if (insurances.get(i).getText().equals("Hemförsäkring")) {
				insurances.get(i).click();
				// Om/när den har hittat hemförsäkringar och navigerat till den sidan
				// Så kommer programmet att printa ut texten i rutan som beskrevs i uppgiften
				System.out.println("Följande text finns står i rutan");
				System.out.println(driver.findElement(By.className("article__fragment")).getText());
			  }
			else {
				// Ifall den av någon mystisk anledning inte hittar hemförsäkring (vilket vi dock vet i det här scenariot) så skriver den ut att den inte fanns.
				System.out.println("Hittade inte hemförsäkringar bland alternativen");
			}
			}
		
	}

}
