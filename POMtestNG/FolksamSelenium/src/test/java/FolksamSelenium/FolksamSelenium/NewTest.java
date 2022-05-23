package FolksamSelenium.FolksamSelenium;

import org.testng.annotations.Test;

import pages.FolksamHomeInsurance;
import pages.FolksamHomePage;
import pages.GoogleHomePage;
import pages.GoogleResultPage;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver;
	
	GoogleHomePage 		 googleHome;
	GoogleResultPage 	 googleResult;
	FolksamHomePage 	 folksamHome;
	FolksamHomeInsurance folksamInsurance;
	
	String keyword = "Folksam";
	
  @Test
  public void validateText() {
  	googleHome = new GoogleHomePage(driver);
  	// Navigerar till Googles startsida
  	googleHome.goToHomePage();
  	// Accepterar googles cookies
  	googleHome.acceptCookies();
  	//Söker på vårat keyword, som i det här fallet var Folksam
  	googleHome.searchKeyword(keyword);
  	
  	// Deklarerar sidan för sökresultaten
  	googleResult = new GoogleResultPage(driver);
  	// klickar på första sökresultatet
  	googleResult.goToFirstResult();
  	
  	//Deklarerar FolksamsHemsida vilket är första resultatet
  	folksamHome = new FolksamHomePage(driver);
  	//Accepterar Folksams cookies
  	folksamHome.acceptCookies();
  	// Klickar på hemförsäkringsbilden
  	folksamHome.goToHomeInsurance();
  	
  	//Deklarerar hemförsäkringsidan
  	folksamInsurance = new FolksamHomeInsurance(driver);
  	// Hämtar texten ifrån textrutan
  	String insuranceText = folksamInsurance.findInsuranceText();
  	
  	// Texten som den förväntar sig/ jämför sig med, så vi vet att vi har fått rätt text
  	String expectedText = "Sveriges populäraste hemförsäkring\n"
  			+ "För dig och dina saker – därför väljer du oss:\n"
  			+ "\n"
  			+ "Alla våra hemförsäkringar är märkta med Naturskyddsföreningens Bra Miljöval – en av världens tuffaste miljömärkningar.\n"
  			+ "Vi försäkrar 1,8 miljoner hushåll och flest hem i Sverige visar branschstatistik från Svensk Försäkring 2021.\n"
  			+ "Skadehantering och kundservice med betyg i toppklass enligt Svensk Kvalitetsindex 2020.\n"
  			+ "Både vår hem- och villaförsäkring får högsta betyg hos Konsumenternas Försäkringsbyrå.";
  	
  	// Här jämförs strängarna
  	Assert.assertEquals(insuranceText, expectedText);
  }
  @BeforeTest
  public void setup()
  {
  		String os = System.getProperty("os.name");;
		
		if (os.startsWith("Windows")) {
			System.setProperty("webdriver.chrome.driver", String.format("%s/resources/chromedriver.exe", System.getProperty("user.dir")));
		} else {
			System.setProperty("webdriver.chrome.driver", String.format("%s/resources/chromedriver", System.getProperty("user.dir")));
		}
		
		// Deklarerar en webdriver som ska användas till att slutföra uppgiften
		driver = new ChromeDriver();
		// Lägger till att webbläsaren ska vänta i 10 sekunder ifall att elementet inte har hunnit renderat
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterTest
  public void afterTest() {
	  // Stänger av/ned webbläsaren
	  driver.close();
  }

}
