package basicTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.List;


public class GoogleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Setze den Pfad zum Chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\justi\\Documents\\Repositories\\eclipse-workspaces\\Selenium_CICD\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");

        // Erstelle eine Instanz von ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        // Öffne Google Chrome und navigiere zu google.com
        driver.get("https://www.google.com");
        
        // Versuche, das Cookie-Popup auszublenden
       WebElement CookieAccept = driver.findElement(By.xpath("//button[@id = \"L2AGLb\"]"));
       CookieAccept.click();

        // Finde das Suchfeld und gib "1337" ein
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        searchBox.sendKeys("1337");
        searchBox.submit();

        // Warte auf das Laden der Suchergebnisse
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Überprüfe, ob die Suchergebnisse "1337" enthalten
        List<WebElement> searchResults = driver.findElements(By.xpath("//textarea[@class='gLFyf']"));
        boolean found = false;
        for (WebElement result : searchResults) {
            if (result.getText().contains("1337")) {
                found = true;
                break;
            }
        }

        // Ausgabe des Ergebnisses
        if (found) {
            System.out.println("Die Suchergebnisse enthalten '1337'.");
        } else {
            System.out.println("Die Suchergebnisse enthalten kein '1337'.");
        }

        // Schließe den Browser
        driver.quit();
    }

	}
