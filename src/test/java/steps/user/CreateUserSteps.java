package steps.user;

import api.callers.user.CreateUserCaller;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CreateUserSteps {
    CreateUserCaller createUserCaller = new CreateUserCaller();

    @When("^create user( by name is (.+)?)?$")
    public void createUser(String userName) {
        createUserCaller.createUser(userName);
    }

    @Then("verify user created")
    public void verifyUserCreated() {
        Assertions.assertTrue(createUserCaller.isUserCreated(), "User not created");
    }
}
