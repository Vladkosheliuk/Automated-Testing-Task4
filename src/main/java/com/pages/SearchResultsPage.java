package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;

    private By results = By.cssSelector(".productList li");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean resultsAreDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Ожидаем хотя бы одно изображение товара с классом rtimg
            By resultImage = By.cssSelector("img.rtimg");

            wait.until(ExpectedConditions.visibilityOfElementLocated(resultImage));

            List<WebElement> results = driver.findElements(resultImage);
            return results.size() > 0;

        } catch (TimeoutException e) {
            System.out.println("Не найдено изображений товаров после поиска.");
            return false;
        }
    }
}

