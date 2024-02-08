package lt.techin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePageTest {
    WebDriver driver;

    public BasePageTest() {
    }

    @BeforeEach
    void setup() {
        this.driver = new ChromeDriver();
        this.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        this.driver.manage().window().maximize();
    }

    @AfterEach
    void closeDown() {

//        this.driver.quit();
    }

    public static void waiting() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException var1) {
        }

    }
}
