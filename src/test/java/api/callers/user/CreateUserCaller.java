package api.callers.user;

import globals.User;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import api.requests.user.CreateUserRequest;
import utils.DataGenerator;
import utils.UtilsMethod;

public class CreateUserCaller extends CreateUserRequest {
    CreateUserRequest createUserRequest = new CreateUserRequest();
    User user = User.getInstance();

    public ValidatableResponse createUser(String userName) {
        userName = (userName == null || userName.equals("valid")) ? DataGenerator.generateRandomName() : userName;
        ValidatableResponse response = createUserRequest.createUser(userName);
        Response extractResponse = response.extract().response();
        user.setId(extractResponse.path("id"));
        user.setName(extractResponse.path("name"));
        user.setNumber(extractResponse.path("number"));
        user.setResponse(extractResponse);
        return response;
    }

    public Boolean isUserCreated() {
        UtilsMethod utilsMethod = new UtilsMethod();
        return utilsMethod.responseMatch(user.getResponse(), createUserRequest.getRequestModel("successResponseSchema"));
    }
}
