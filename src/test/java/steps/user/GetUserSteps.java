package steps.user;

import api.callers.user.GetUserCaller;
import globals.User;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetUserSteps {

    GetUserCaller getUserCaller = new GetUserCaller();
    User user = User.getInstance();

    @When("get user by id")
    public void getUserById() {
        getUserCaller.getUserById();
    }

    @Then("verify user listed")
    public void verifyUserListed() {
        Assertions.assertAll(
                () -> assertTrue(getUserCaller.isUserListed(), "User not listed"),
                () -> assertEquals(user.getId(), user.getResponse().path("id"), "Response id incorrect"),
                () -> assertEquals(user.getNumber(), user.getResponse().path("number"), "Response number incorrect"),
                () -> assertEquals(user.getName(), user.getResponse().path("name"), "Response name incorrect")
        );
    }
}
