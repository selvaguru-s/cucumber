
package stepdefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    @Given("User is on the Instagram login page")
    public void user_is_on_the_instagram_login_page() {

        driver.get("https://www.instagram.com/");
        driver.manage().window().maximize();
    }

    @When("User enters username {string}")
    public void user_enters_username(String username) {

      //  driver.findElement(By.name("email")).sendKeys(username);
        
        WebElement usernameField = wait.until(
        	    ExpectedConditions.visibilityOfElementLocated(
        	        By.name("email")
        	    )
        	);
        usernameField.sendKeys(username);
    }

    @When("User enters password {string}")
    public void user_enters_password(String password) {

        driver.findElement(By.name("pass")).sendKeys(password);
    }

    @When("User clicks login button")
    public void user_clicks_login_button() {

        driver.findElement(By.xpath("//span[text()='Log in']")).click();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {

        wait.until(driver -> driver.getCurrentUrl().contains("instagram.com"));

        Assert.assertTrue(driver.getCurrentUrl().contains("instagram.com"));

        driver.quit();
    }
}