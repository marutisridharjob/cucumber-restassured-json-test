package steps.user;

import api.callers.user.DeleteUserCaller;
import globals.User;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class DeleteUserSteps {

    DeleteUserCaller deleteUserCaller = new DeleteUserCaller();

    @When("delete user")
    public void deleteUser() {
        deleteUserCaller.deleteUser();
    }

    @Then("verify user deleted")
    public void verifyUserDeleted() {
        Assertions.assertTrue(User.getInstance().getResponse().asString().equals("{}"), "User deleted response incorrect");
    }
}
