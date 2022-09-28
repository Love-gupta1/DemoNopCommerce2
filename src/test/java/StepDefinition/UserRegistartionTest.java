package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class UserRegistartionTest extends BaseClass {

    @Given("User is on Register Page")
    public void user_is_on_Register_page() {
        setup();
    }
    @When("user enter the Details")
    public void user_enter_the_Details() throws IOException {
        pageFactory.getLogin().login();

    }
    @And("user click on Register button")
    public void user_click_on_Register_button() {
        pageFactory.getUserRegisteration().UserClickOnTheRegisterButton();
    }

    @Then("user navigate to Homepage")
    public void user_is_on_Homepage() {
        pageFactory.getUserRegisteration().UserIsOnHomepage();
    }
}

