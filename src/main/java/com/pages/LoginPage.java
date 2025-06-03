package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Если у тебя есть отдельный метод для открытия формы логина — добавь сюда
    public void openLoginForm() {
        // Если логин открывается кликом на accountLink, то возможно:
        driver.get("https://www.wiggle.com/login"); // прямой URL на страницу логина
    }

    public void login(String email, String password) {
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("Input_EmailAddress"))
        );
        emailField.clear();
        emailField.sendKeys(email);



        WebElement signInButton = driver.findElement(
                By.xpath("//button[contains(text(),'Continue Securely')]")
        );
        signInButton.click();
    }
}
