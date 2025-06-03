package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://www.wiggle.com/");
    }

    public void acceptCookiesIfPresent() {
        try {
            WebElement acceptCookiesButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Allow all')]"))
            );
            acceptCookiesButton.click();
        } catch (TimeoutException e) {
            // ignore if no cookie popup
        }
    }

    public void goToLoginPage() {
        WebElement accountLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-testid='header-account-link']"))
        );
        accountLink.click();
    }

    public void search(String query) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Ждём появления кнопки "ALLOW ALL"
            WebElement allowAllButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler"))
            );

            // Кликаем по кнопке
            allowAllButton.click();

            // Дополнительно ждём, пока баннер исчезнет
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("onetrust-accept-btn-handler")));

            System.out.println("Cookie баннер успешно закрыт.");

        } catch (TimeoutException e) {
            System.out.println("Cookie баннер не появился — продолжаем.");
        }


        // 🔍 Поиск
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtSearch")));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(query);
        searchInput.sendKeys(Keys.ENTER);
    }
}