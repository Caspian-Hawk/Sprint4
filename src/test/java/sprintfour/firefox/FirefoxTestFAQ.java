package sprintfour.firefox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sprintfour.MainPage;

import java.time.Duration;

public class FirefoxTestFAQ {
    private WebDriver driver;

    @Before
    public void StartUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkQuestionFAQ() throws InterruptedException {
        var mainPage = new MainPage(driver);

        // открываем страницу
        mainPage.openMainPage();

        // принимаем куки
        mainPage.clickCookie();

        // ищем FAQ
        mainPage.scrollAndClickArrow();

        // проверяем ответ
        mainPage.checkFirstAnswer();

        driver.close();
    }

    public void tearDown() {
        driver.quit();
    }
}
