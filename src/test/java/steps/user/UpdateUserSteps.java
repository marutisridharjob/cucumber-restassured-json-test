package steps.user;

import api.callers.user.UpdateUserCaller;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class UpdateUserSteps {

    UpdateUserCaller updateUserCaller = new UpdateUserCaller();

    @When("^update user name( is (.+)?)?$")
    public void updateUser(String userName) {
        updateUserCaller.updateUserName(userName);
    }

    @Then("verify user updated")
    public void verifyUserUpdated() {
        Assertions.assertTrue(updateUserCaller.isUserUpdated(), "User not created");
    }
}
