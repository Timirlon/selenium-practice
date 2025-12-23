package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Required fields
    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By genderMale = By.xpath("//label[text()='Male']");
    private final By mobile = By.id("userNumber");

    // Optional fields
    private final By email = By.id("userEmail");
    private final By subjects = By.id("subjectsInput");
    private final By hobbiesSports = By.xpath("//label[text()='Sports']");
    private final By uploadPicture = By.id("uploadPicture");
    private final By address = By.id("currentAddress");

    private final By state = By.id("react-select-3-input");
    private final By city = By.id("react-select-4-input");

    private final By submitButton = By.id("submit");
    private final By modalTitle = By.id("example-modal-sizes-title-lg");

    // Actions
    public void enterFirstName(String value) {
        driver.findElement(firstName).sendKeys(value);
    }

    public void enterLastName(String value) {
        driver.findElement(lastName).sendKeys(value);
    }

    public void selectMaleGender() {
        jsClick(genderMale);
    }

    public void selectHobbySports() {
        jsClick(hobbiesSports);
    }

    public void submitForm() {
        jsClick(submitButton);
    }


    public void enterMobile(String value) {
        driver.findElement(mobile).sendKeys(value);
    }

    public void enterEmail(String value) {
        driver.findElement(email).sendKeys(value);
    }

    public void enterSubject(String value) {
        WebElement subjectInput = driver.findElement(subjects);
        subjectInput.sendKeys(value);
        subjectInput.sendKeys("\n");
    }

    public void uploadPicture(String filePath) {
        driver.findElement(uploadPicture).sendKeys(filePath);
    }

    public void enterAddress(String value) {
        driver.findElement(address).sendKeys(value);
    }

    public void selectStateAndCity(String stateValue, String cityValue) {
        driver.findElement(state).sendKeys(stateValue + "\n");
        driver.findElement(city).sendKeys(cityValue + "\n");
    }

    public boolean isSubmissionSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions
                        .visibilityOfElementLocated(modalTitle))
                .getText()
                .contains("Thanks for submitting the form");
    }

    private void jsClick(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

}
