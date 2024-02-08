package lt.techin;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MainPage extends BasePage {




    public MainPage(WebDriver driver) {

        super(driver);
    }

    public void waiting() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }



}
