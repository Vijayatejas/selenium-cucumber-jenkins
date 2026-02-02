package stepdefinitions;

import driver.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("user is on login page")
    public void user_is_on_login_page() throws InterruptedException {
        driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        Thread.sleep(3000);
        System.out.println("url is entered");
    }

    @When("user enters email {string} and password {string}")
    public void user_enters_email_and_password(String userName, String password) throws InterruptedException {
        loginPage.enterUserName(userName);
        Thread.sleep(3000);
        System.out.println("username is entered");
        loginPage.enterPassword(password);
        Thread.sleep(3000);
        System.out.println("password is entered");

    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {
        loginPage.clickLogin();
        Thread.sleep(3000);
        System.out.println("login button clicked");
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() throws InterruptedException {
        Assert.assertTrue(loginPage.isDashboardDisplayed(),
                "Login failed: Dashboard not visible");
        Thread.sleep(3000);
        System.out.println("Assertion done");
    }
}
