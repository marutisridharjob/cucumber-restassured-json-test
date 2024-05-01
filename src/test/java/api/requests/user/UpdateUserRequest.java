package api.requests.user;

import configs.BaseConfig;
import globals.User;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import utils.LoggingUtil;
import utils.Requests;
import utils.ResourceFileReader;

import java.util.HashMap;
import java.util.Map;

public class UpdateUserRequest {
    private final BaseConfig baseConfig = new BaseConfig();
    private final ResourceFileReader resourcesData = new ResourceFileReader();
    private JSONObject body = new JSONObject();
    private Map<String, String> requestHeaders = new HashMap<>();
    private ValidatableResponse response = null;

    public JSONObject getRequestModel(String key) {
        return resourcesData.getApiModel("user", "updateUser", key);
    }

    private void setHeaders() {
        requestHeaders.put("Content-Type", "application/json");
    }

    public ValidatableResponse updateUserName(String userName) {
        setHeaders();
        body = getRequestModel("request");
        body.put("name", userName);
        body.put("number", User.getInstance().getNumber());
        response = Requests.putRequest(baseConfig.baseUrl(), "/update-user/" + User.getInstance().getId(), body.toString(), requestHeaders);
        Assertions.assertEquals(response.extract().statusCode(), 200, "Expected status code 200 but found " + response.extract().statusCode());
        LoggingUtil.logInfo("Updated User => " + response.extract().response().asString());
        return response;
    }
}
