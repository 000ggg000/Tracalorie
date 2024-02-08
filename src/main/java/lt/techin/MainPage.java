package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class MainPage extends BasePage {


    @FindBy(id = "item-name")
    WebElement inputAddItem;

    @FindBy(id = "item-calories")
    WebElement inputAddCalories;

    @FindBy(xpath = "//button[@class='add-btn btn blue darken-3']")
    WebElement addMealButton;

    @FindBy(xpath = "//span[@class='total-calories']")
    WebElement totalCaloriesSum;

    @FindBy(xpath = "//a[@class='clear-btn btn blue lighten-3']")
    WebElement clearAllButton;

    @FindBy(xpath = "//li[@id='item-0']")
    WebElement firstItemInList;

    @FindBy(xpath = "//li[@class='collection-item']")
    List<WebElement> addedItemList;

    @FindBy(xpath = "//i[@class='edit-item fa fa-pencil']")
    WebElement editButton;

    @FindBy(xpath = "//button[@class='delete-btn btn red']")
    WebElement deleteMealButton;

    @FindBy(xpath = "//button[@class='update-btn btn orange']")
    WebElement updateMealButton;

    @FindBy(xpath = "//button[@class='back-btn btn grey pull-right']")
    WebElement backButton;

    @FindBy(xpath = "//li[@id='item-0']/strong[.='Butter: ']")
    WebElement itemNameInList;


    public MainPage(WebDriver driver) {

        super(driver);
    }

    public void waiting() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    public void addProduct(String item, int calories) {
        inputAddItem.sendKeys(item);
        inputAddCalories.sendKeys(calories + "");
        addMealButton.click();
    }

    public Integer sumCalories(List<WebElement> addedItemList) {
        List<Integer> caloriesList = new ArrayList<>();
        caloriesList = addedItemList.stream().map(e -> e.getText().replaceAll(" Calories", "")).map(i -> i.split(": ")[1]).map(Integer::valueOf).collect(Collectors.toList());
        int totalSumCalories = 0;
        for (Integer sumaCalories : caloriesList) {
            totalSumCalories = totalSumCalories + sumaCalories;
        }

        return totalSumCalories;
    }

    public Integer totalCalories() {
        String totalSum = totalCaloriesSum.getText();

        return parseInt(totalSum);
    }

    public void deleteItem() {
       editButton.click();
       deleteMealButton.click();
    }

    public void deleteItemFromManyItems(String item) {

        driver.findElement(By.xpath("//li[@class='collection-item']/strong[contains(text(), '" + item + "')]/../a/i")).click();
        deleteMealButton.click();
    }

    public void clearAll() {
        clearAllButton.click();

    }

    public void updateItem(String item, int calories) {
        editButton.click();
        inputAddItem.clear();
        inputAddItem.sendKeys(item);
        inputAddCalories.clear();
        inputAddCalories.sendKeys(String.valueOf(calories));
        updateMealButton.click();
    }

    public String itemNameFromList(){
       String itemName =  itemNameInList.getText().replace(":", "").trim();
        return itemName;
            }

    public void setBackButton() {
        editButton.click();
        backButton.click();
    }

    public String totalCaloriesSumText(){
        return totalCaloriesSum.getText();
    }

    public boolean isItemInTheList(String item) {
        return addedItemList.stream().anyMatch(i-> i.getText().contains(item));
    }
}
