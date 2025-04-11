package sprintfour.firefox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sprintfour.FormAboutRent;
import sprintfour.FormAboutUser;
import sprintfour.MainPage;

import java.time.Duration;

@RunWith(Parameterized.class)
public class FirefoxTestButtonOrderDown { // флоу нижней кнопки "Заказать"
    private WebDriver driver;

    private final String name;
    private final String surname;
    private final String address;
    private final String telephone;

    public FirefoxTestButtonOrderDown(String name, String surname, String address, String telephone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephone = telephone;
    }

    @Parameterized.Parameters
    public static Object[][] userData() {
        return new Object[][] {
                {"Роман", "Карасев", "Калининская", "89001112233"},
                {"Алексей", "Петров", "Ленина", "89001234567"},
        };
    }

    @Before
    public void StartUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void checkButtonOrderDown() {
        var mainPage = new MainPage(driver);
        var formAboutUser = new FormAboutUser(driver);
        var formAboutRent = new FormAboutRent(driver);

        // открываем страницу
        mainPage.openMainPage();
        // принимаем куки
        mainPage.clickCookie();

        // кликаем по верхней кнопке Заказать
        mainPage.clickButtonOrderDown();

        // форма "Для кого самокат"

        // заполняем поле Имя
        formAboutUser.inputFieldName(name);
        // заполняем поле Фамилия
        formAboutUser.inputFieldSurname(surname);
        // заполняем поле Адрес
        formAboutUser.inputFieldAddress(address);
        // выбираем станцию
        formAboutUser.selectStation();
        // заполняем поле Телефон
        formAboutUser.inputFieldTelephone(telephone);
        // кликаем по кнопке Далее
        formAboutUser.clickButtonNext();

        // форма "Про аренду"

        // заполняем поле Дата
        formAboutRent.inputFieldDate();
        // заполняем поле Срок аренды
        formAboutRent.inputFieldRent();
        // кликаем по кнопке Заказать
        formAboutRent.clickButtonOrderForm();

        // диалоговое окно Хотите оформить заказ?

        // нажимаем на кнопку Да
        formAboutRent.clickButtonYes();

        formAboutRent.checkOrderComplete();

        // закрываем браузер
        driver.close();
    }

    public void tearDown() {
        driver.quit();
    }
}