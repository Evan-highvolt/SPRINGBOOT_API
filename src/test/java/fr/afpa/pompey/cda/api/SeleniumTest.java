package fr.afpa.pompey.cda.api;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testPageTitle(){
//        Accedez a une URL
        driver.get("http://www.afpa.com/");

//        Recuperez le titre de la page
        String title = driver.getTitle();

//        Verfiez si le titre est correct
        assertEquals("Afpa : formation professionelle, formation adulte, formtaion-continue, VAE // Afpa | Afpa", title);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
