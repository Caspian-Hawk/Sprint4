package sprintfour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class FormAboutRent {
    private final WebDriver driver;

    private final By fieldDate = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input");
    private final By deskDate = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[4]");
    private final By fieldRent = By.className("Dropdown-placeholder");
    private final By listRent = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]");
    private final By buttonOrderForm = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    private final By buttonYes = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");

    public FormAboutRent(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFieldDate() {
        driver.findElement(fieldDate).click();
        driver.findElement(deskDate).click();
    }

    public void inputFieldRent() {
        driver.findElement(fieldRent).click();
        driver.findElement(listRent).click();
    }

    public void clickButtonOrderForm() {
        driver.findElement(buttonOrderForm).click();
    }

    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }

    public void checkOrderComplete() {
        By orderComplete = By.xpath("/html/body/div/div/div[2]/div[5]");
        // ждем, на всякий случай
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(orderComplete));
        // проверяем окно Заказ оформлен
        assertTrue(driver.findElement(orderComplete).isDisplayed());
    }
}
