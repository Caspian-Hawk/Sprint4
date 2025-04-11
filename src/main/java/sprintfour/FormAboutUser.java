package sprintfour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormAboutUser {
    private final WebDriver driver;

    private final By fieldName = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    private final By fieldSurname = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    private final By fieldAddress = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    private final By fieldStation = By.className("select-search__input");
    private final By listStation = By.className("select-search__select");
    private final By fieldTelephone = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    private final By buttonNext = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");

    public FormAboutUser(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFieldName(String name) {
        driver.findElement(fieldName).sendKeys(name);
    }

    public void inputFieldSurname(String surname) {
        driver.findElement(fieldSurname).sendKeys(surname);
    }

    public void inputFieldAddress(String address) {
        driver.findElement(fieldAddress).sendKeys(address);
    }

    public void selectStation() {
        driver.findElement(fieldStation).click();
        driver.findElement(listStation).click();
    }

    public void inputFieldTelephone(String telephone) {
        driver.findElement(fieldTelephone).sendKeys(telephone);
    }

    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }
}