package demoqa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegistrationTest extends BaseTest {

    @Test
    void smokeTest_requiredFieldsOnly() {
        RegistrationPage page = new RegistrationPage(driver);

        page.enterFirstName("John");
        page.enterLastName("Doe");
        page.selectMaleGender();
        page.enterMobile("7700123456");
        page.submitForm();

        assertTrue(page.isSubmissionSuccessful());
    }

    @Test
    void registration_allFieldsFilled() {
        RegistrationPage page = new RegistrationPage(driver);

        page.enterFirstName("Anna");
        page.enterLastName("Smith");
        page.enterEmail("anna.smith@test.com");
        page.selectMaleGender();
        page.enterMobile("7012345678");
        page.enterSubject("Maths");
        page.selectHobbySports();
        page.enterAddress("Astana, Kazakhstan");
        page.selectStateAndCity("NCR", "Delhi");

        page.submitForm();

        assertTrue(page.isSubmissionSuccessful());
    }

    @Test
    void registration_missingFirstName_shouldFail() {
        RegistrationPage page = new RegistrationPage(driver);

        page.enterLastName("Doe");
        page.selectMaleGender();
        page.enterMobile("7700123456");
        page.submitForm();

        assertFalse(driver.getPageSource()
                .contains("Thanks for submitting the form"));
    }

    @Test
    void registration_invalidMobile_shouldFail() {
        RegistrationPage page = new RegistrationPage(driver);

        page.enterFirstName("Tom");
        page.enterLastName("Hardy");
        page.selectMaleGender();
        page.enterMobile("12345");
        page.submitForm();

        assertFalse(driver.getPageSource()
                .contains("Thanks for submitting the form"));
    }

    @Test
    void registration_pairwiseCombination() {
        RegistrationPage page = new RegistrationPage(driver);

        page.enterFirstName("Alex");
        page.enterLastName("");
        page.selectMaleGender();
        page.enterMobile("7700123456");
        page.submitForm();

        assertFalse(driver.getPageSource()
                .contains("Thanks for submitting the form"));
    }
}
