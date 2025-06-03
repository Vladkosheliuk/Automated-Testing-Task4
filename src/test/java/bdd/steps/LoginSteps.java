package bdd.steps;

import com.pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("I am on the login page")
    public void openLoginPage() {
        driver = new ChromeDriver();
        driver.get("https://www.wiggle.com/");
        loginPage = new LoginPage(driver);
        loginPage.openLoginForm();
    }

    @When("I login with email {string} and password {string}")
    public void loginWithCredentials(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("I should be logged in")
    public void validateLogin() {
        driver.quit();
    }
}
