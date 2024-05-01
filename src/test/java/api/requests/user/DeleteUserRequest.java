package api.requests.user;

import configs.BaseConfig;
import globals.User;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import utils.LoggingUtil;
import utils.Requests;

import java.util.HashMap;
import java.util.Map;

public class DeleteUserRequest {
    private final BaseConfig baseConfig = new BaseConfig();
    private Map<String, String> requestHeaders = new HashMap<>();
    private ValidatableResponse response = null;

    private void setHeaders() {
        requestHeaders.put("Content-Type", "application/json");
    }

    public ValidatableResponse deleteUser() {
        setHeaders();
        String userId = User.getInstance().getId();
        response = Requests.deleteRequest(baseConfig.baseUrl(), "/delete-user/" + userId, requestHeaders);
        Assertions.assertEquals(response.extract().statusCode(), 200, "Expected status code 200 but found " + response.extract().statusCode());
        LoggingUtil.logInfo(userId + " user deleted");
        return response;
    }
}
