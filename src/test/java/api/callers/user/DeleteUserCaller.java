package api.callers.user;

import api.requests.user.DeleteUserRequest;
import globals.User;
import io.restassured.response.ValidatableResponse;

public class DeleteUserCaller extends DeleteUserRequest {
    DeleteUserRequest deleteUserRequest = new DeleteUserRequest();
    User user = User.getInstance();

    public ValidatableResponse deleteUser() {
        ValidatableResponse response = deleteUserRequest.deleteUser();
        user.setResponse(response.extract().response());
        return response;
    }
}
