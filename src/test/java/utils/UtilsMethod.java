package utils;

import globals.User;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Map;

public class UtilsMethod {

    public void resetAllGlobal() {
        User.getInstance().reset();
    }

    public boolean responseMatch(Response response, Map<String, Object> schema) {
        JsonPath responseJson = response.jsonPath();
        for (String key : schema.keySet()) {
            if (!responseJson.get().toString().contains(key)) {
                return false;
            }
            Object responseValue = responseJson.get(key);
            Object schemaValue = schema.get(key);
            if (responseValue == null && schemaValue != null) {
                return false;
            }
            if (responseValue != null && !responseValue.getClass().getName().contains(schemaValue.toString())) {
                return false;
            }
        }
        return true;
    }
}