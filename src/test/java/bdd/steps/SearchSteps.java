package bdd.steps;

import com.pages.HomePage;
import com.pages.SearchResultsPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class SearchSteps {

    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;

    @Given("I am on the Wiggle homepage")
    public void openHomePage() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        homePage.open();

    }

    @When("I search for {string}")
    public void searchForProduct(String query) {
        homePage.search(query);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @Then("I should see search results")
    public void validateResults() {
        assertTrue(searchResultsPage.resultsAreDisplayed());
        driver.quit();
    }
}
