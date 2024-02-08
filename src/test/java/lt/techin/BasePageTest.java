package lt.techin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BasePageTest {
    WebDriver driver;

    public BasePageTest() {
    }

    @BeforeEach
    void setup() {
        this.driver = new ChromeDriver();
        this.driver.get("https://practice.expandtesting.com/tracalorie/");
        this.driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void closeDown() {

        this.driver.quit();
    }


}
