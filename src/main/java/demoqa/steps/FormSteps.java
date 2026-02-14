package demoqa.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class FormSteps {

    WebDriver driver;

    @Given("user opens browser")
    public void openBrowser() {
        driver = new ChromeDriver();
    }

    @Given("user opens practice form page")
    public void openFormPage() {
        driver = new ChromeDriver();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
    }

    @When("user navigates to practice page")
    public void navigateToPage() {
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
    }

    @When("user enters first name {string}")
    public void enterFirstName(String name) {
        driver.findElement(By.name("firstname")).sendKeys(name);
    }

    @When("user enters last name {string}")
    public void enterLastName(String name) {
        driver.findElement(By.name("lastname")).sendKeys(name);
    }

    @When("user clicks submit")
    public void clickSubmit() {
        driver.findElement(By.id("submit")).click();
    }

    @When("user clicks submit without entering data")
    public void submitEmpty() {
        driver.findElement(By.id("submit")).click();
    }

    @Then("form should be submitted successfully")
    public void validateSuccess() {
        // Example: check URL or success element
        assertTrue(driver.getCurrentUrl().contains("form"));
        driver.quit();
    }

    @Then("error message should be displayed")
    public void validateError() {
        // Example validation (depends on site)
        assertTrue(driver.getPageSource().contains("error"));
        driver.quit();
    }

    @Then("page title should be displayed")
    public void validateTitle() {
        assertNotNull(driver.getTitle());
        driver.quit();
    }

    @Then("input field should contain {string}")
    public void validateInput(String value) {
        String text = driver.findElement(By.name("firstname")).getAttribute("value");
        assertEquals(value, text);
        driver.quit();
    }
}

