package api.requests.user;

import configs.BaseConfig;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import utils.DataGenerator;
import utils.LoggingUtil;
import utils.Requests;
import utils.ResourceFileReader;

import java.util.HashMap;
import java.util.Map;

public class CreateUserRequest {
    private final BaseConfig baseConfig = new BaseConfig();
    private final ResourceFileReader resourcesData = new ResourceFileReader();
    private JSONObject body = new JSONObject();
    private Map<String, String> requestHeaders = new HashMap<>();
    private ValidatableResponse response = null;

    public JSONObject getRequestModel(String key) {
        return resourcesData.getApiModel("user", "createUser", key);
    }

    private void setHeaders() {
        requestHeaders.put("Content-Type", "application/json");
    }

    public ValidatableResponse createUser(String userName) {
        setHeaders();
        body = getRequestModel("request");
        body.put("name", userName);
        body.put("number", DataGenerator.generateRandomIntegerSpecificRange(10,9999999));
        response = Requests.postRequest(baseConfig.baseUrl(), "/create-user", body.toString(), requestHeaders);
        Assertions.assertEquals(response.extract().statusCode(), 201, "Expected status code 201 but found " + response.extract().statusCode());
        LoggingUtil.logInfo("User => " + response.extract().response().asString());
        return response;
    }
}
