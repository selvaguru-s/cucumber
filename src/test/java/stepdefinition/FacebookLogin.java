package stepdefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

    WebDriver driver;

    @Given("user opens the login page")
    public void user_opens_the_login_page() {

        // Launch Chrome
        driver = new ChromeDriver();

        // Maximize browser
        driver.manage().window().maximize();

        // Open login page
        driver.get("https://www.instagram.com/");
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {

        // Find username field and enter username
        driver.findElement(By.name("email")).sendKeys(username);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {

        // Find password field and enter password
        driver.findElement(By.name("pass")).sendKeys(password);
    }

    @When("user clicks login")
    public void user_clicks_login() {

        // Find Login button and click
        driver.findElement(By.xpath("//span[text()='Log in']")).click();
    }

    @Then("user should see home page")
    public void user_should_see_home_page() {

        System.out.println("Home page displayed");

        // Close browser
        driver.quit();
    }

    @Then("user should see error message")
    public void user_should_see_error_message() {

        System.out.println("Error message displayed");

        // Close browser
        driver.quit();
    }
}