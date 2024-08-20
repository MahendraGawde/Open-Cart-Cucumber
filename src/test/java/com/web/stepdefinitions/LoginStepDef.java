package com.web.stepdefinitions;

import com.web.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginStepDef {


    private WebDriver driver;
    private LoginPage loginPage;


    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    @Given("I am on the OpenCart login page.")
    public void i_am_on_the_open_cart_login_page() {
         driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
         loginPage = new LoginPage(driver);
    }

    @Given("I have entered valid username and password")
    public void i_have_entered_valid_username_password() {
        loginPage.enterEmail("qatestertest@gmail.com");
        loginPage.enterPassword("Test@123");
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
         loginPage.clickLoginButton();
        
    }

    @Then("I should logged in successfully")
    public void i_should_logged_in_successfully() {
        Assert.assertEquals(loginPage.chkLogoutLink(),true);

    }

    @Given("I have entered Invalid {string} and {string}")
    public void i_have_entered_invalid_username_password(String username, String password) {
         loginPage.enterEmail(username);
         loginPage.enterPassword(password);
        
    }

    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message(String errorMessage) {
        Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);


    }

    @Given("Forgot Password link is present on Account Login page")
    public void forgotPasswordLinkIsPresentOnAccountLoginPage() {
        Assert.assertTrue(loginPage.chkForgotPwdLink());
    }

    @When("I click on the {string} link")
    public void i_click_on_the_forgot_password_link(String forgotPassword) {
         
            loginPage.clkForgotPasswordLink();
    }

    @Then("I should be redirected to password reset page")
    public void i_should_be_redirected_to_password_reset_page() {
        Assert.assertTrue(loginPage.getForgotPwdPageUrl().contains("account/forgotten"));
        
    }


}
