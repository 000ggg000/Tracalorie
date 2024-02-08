package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest extends BasePageTest {


    @Test
    void addTheProductAndCheckIfItIs() {
        MainPage mainPage = new MainPage(driver);
        mainPage.addProduct("Butter", 250);
        mainPage.addProduct("Milk", 100);
        System.out.println("text: " + mainPage.itemNameFromList());
        assertEquals(mainPage.sumCalories(mainPage.addedItemList), mainPage.totalCalories(), "The sum wrong calculated.");
        assertTrue( mainPage.isItemInTheList("Butter"), "The item did not added.");
        assertTrue( mainPage.isItemInTheList("Milk"), "The item did not added.");
        System.out.println("sum calories " + mainPage.sumCalories(mainPage.addedItemList));
    }
    @Test
    void addTheProductAndCheckTheTotalCalories() {
        MainPage mainPage = new MainPage(driver);
        mainPage.addProduct("Butter", 250);
        mainPage.addProduct("Butter", 250);
        mainPage.addProduct("Butter", 250);
        mainPage.addProduct("Milk", 100);
        mainPage.addProduct("Bread", 150);
        mainPage.addProduct("Candies", 1050);
        assertEquals(mainPage.sumCalories(mainPage.addedItemList), mainPage.totalCalories(), "The sum wrong calculated.");
        System.out.println("sum calories " + mainPage.sumCalories(mainPage.addedItemList));
    }

    @Test
    void clearAll() {
        MainPage mainPage = new MainPage(driver);
        mainPage.addProduct("Butter", 250);
        mainPage.addProduct("Butter", 250);
        mainPage.addProduct("Milk", 100);
        mainPage.addProduct("Bread", 150);
        mainPage.addProduct("Candies", 1050);
        mainPage.clearAll();
        assertEquals("0", mainPage.totalCaloriesSumText(), "The items were not cleared. ");

    }

    @Test
    void deleteItem() {
        MainPage mainPage = new MainPage(driver);
        mainPage.addProduct("Butter", 250);
        mainPage.deleteItem();
        assertEquals("0", mainPage.totalCaloriesSumText(), "The items were not cleared. ");
    }

    @Test
    void deleteItemChooseFromMany() {
        MainPage mainPage = new MainPage(driver);
        mainPage.addProduct("Butter", 250);
        mainPage.addProduct("Milk", 100);
        mainPage.addProduct("Bread", 150);
        mainPage.addProduct("Candies", 1050);
        mainPage.deleteItemFromManyItems("Bread");
        assertFalse( mainPage.isItemInTheList("Bread"), "The item was not deleted.");
    }

    @Test
    void updateItem() {
        MainPage mainPage = new MainPage(driver);
        mainPage.addProduct("Butter", 250);
        mainPage.updateItem("Butter", 350);
        assertEquals("350", mainPage.totalCaloriesSumText(), "The items were not updated. ");
    }

    @Test
    void backButtonValidation() {
        MainPage mainPage = new MainPage(driver);
        mainPage.addProduct("Butter", 250);
        mainPage.setBackButton();
        assertEquals("", mainPage.inputAddItem.getText(), "The items were not canceled. ");
    }
}
