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


    public void openLoginForm() {

        driver.get("https://www.wiggle.com/login");
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
