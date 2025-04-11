package sprintfour;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class MainPage {
    private final WebDriver driver;

    private final By buttonCookie = By.className("App_CookieButton__3cvqF");
    private final By buttonOrderUp = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void clickCookie() {
        driver.findElement(buttonCookie).click();
    }

    public void clickOrderButtonUp() {
        driver.findElement(buttonOrderUp).click();
    }

    public void clickButtonOrderDown() {
        WebElement buttonOrderDown = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button"));
        // скролим вниз, ищем кнопку Заказать
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", buttonOrderDown);
        // кликаем
        buttonOrderDown.click();
    }

    public void scrollAndClickArrow() {
        WebElement firstQuestion = driver.findElement(By.xpath("//*[@id=\"accordion__heading-0\"]"));
        // скролим вниз, ищем стрелку FAQ
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", firstQuestion);
        // кликаем
        firstQuestion.click();
    }

    public void checkFirstAnswer() {
        By firstAnswer = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[1]/div[2]/p");
        assertTrue(driver.findElement(firstAnswer).isDisplayed());
    }
}