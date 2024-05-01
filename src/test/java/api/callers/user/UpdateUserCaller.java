package api.callers.user;

import globals.User;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import api.requests.user.UpdateUserRequest;
import utils.DataGenerator;
import utils.UtilsMethod;

public class UpdateUserCaller extends UpdateUserRequest {
    UpdateUserRequest updateUserRequest = new UpdateUserRequest();
    User user = User.getInstance();

    public ValidatableResponse updateUserName(String userName) {
        userName = (userName == null || userName.equals("valid")) ? DataGenerator.generateRandomName() : userName;
        ValidatableResponse response = updateUserRequest.updateUserName(userName);
        Response extractResponse = response.extract().response();
        user.setId(extractResponse.path("id"));
        user.setName(extractResponse.path("name"));
        user.setNumber(extractResponse.path("number"));
        user.setResponse(extractResponse);
        return response;
    }

    public Boolean isUserUpdated() {
        UtilsMethod utilsMethod = new UtilsMethod();
        return utilsMethod.responseMatch(user.getResponse(), updateUserRequest.getRequestModel("successResponseSchema"));
    }
}
