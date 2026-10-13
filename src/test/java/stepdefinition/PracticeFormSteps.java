
package stepdefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PracticeFormSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("user opens the practice form")
    public void user_opens_the_practice_form() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.qapractice.com/practice-forms");

        wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.id("forms-country")
            )
        );
    }

    @When("user enters the following details")
    public void user_enters_the_following_details(DataTable dataTable) {

        // Convert single-column DataTable into List
        List<String> data = dataTable.asList();

        // 1. Country
        WebElement countryElement = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.id("forms-country")
            )
        );

        Select country = new Select(countryElement);
        country.selectByVisibleText(data.get(0));


        // 2. Title
        WebElement titleElement = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.id("forms-title")
            )
        );

        Select title = new Select(titleElement);
        title.selectByVisibleText(data.get(1));


        // 3. First Name
        WebElement firstName = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("forms-first-name")
            )
        );

        firstName.sendKeys(data.get(2));


        // 4. Last Name
        WebElement lastName = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("forms-last-name")
            )
        );

        lastName.sendKeys(data.get(3));


        // 5. Date of Birth
        WebElement dob = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("forms-dob")
            )
        );

        dob.sendKeys(data.get(4));


        // 6. Date of Joining
        WebElement doj = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("forms-doj")
            )
        );

        doj.sendKeys(data.get(5));


        // 7. Email
        WebElement email = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("forms-email")
            )
        );

        email.sendKeys(data.get(6));


        // 8. Phone Country Code
        WebElement phoneCodeElement = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.id("forms-phone-code")
            )
        );

        Select phoneCode = new Select(phoneCodeElement);
        phoneCode.selectByVisibleText(data.get(7));


        // 9. Phone Number
        WebElement phone = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("forms-phone-number")
            )
        );

        phone.sendKeys(data.get(8));


        // 10. Communication
        String communication = data.get(9);

        if (communication.equalsIgnoreCase("Email")) {

            WebElement emailRadio = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                    By.id("forms-comm-email")
                )
            );

            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                emailRadio
            );

        } else if (communication.equalsIgnoreCase("Phone")) {

            WebElement phoneRadio = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                    By.id("forms-comm-phone")
                )
            );

            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                phoneRadio
            );
        }
    }


    @When("user clicks submit")
    public void user_clicks_submit() {

        WebElement submit = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.id("forms-submit")
            )
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            submit
        );

        wait.until(
            ExpectedConditions.visibilityOf(submit)
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();",
            submit
        );
    }
}