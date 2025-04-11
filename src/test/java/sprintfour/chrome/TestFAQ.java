package sprintfour.chrome;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sprintfour.MainPage;

import java.time.Duration;

public class TestFAQ {
    private WebDriver driver;

    @Before
    public void StartUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkQuestionFAQ() throws InterruptedException {
        var mainPage = new MainPage(driver);

        // открываем страницу
        mainPage.openMainPage();

        // нажимаем куки
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
