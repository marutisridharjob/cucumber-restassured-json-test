package api.callers.user;

import api.requests.user.GetUserRequest;
import globals.User;
import io.restassured.response.ValidatableResponse;
import utils.UtilsMethod;

public class GetUserCaller extends GetUserRequest {
    GetUserRequest getUserRequest = new GetUserRequest();
    User user = User.getInstance();

    public ValidatableResponse getUserById() {
        ValidatableResponse response = getUserRequest.getUserById();
        user.setResponse(response.extract().response());
        return response;
    }

    public Boolean isUserListed() {
        UtilsMethod utilsMethod = new UtilsMethod();
        return utilsMethod.responseMatch(user.getResponse(), getUserRequest.getRequestModel("successResponseSchema"));
    }
}
