package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ResourceFileReader {
    JSONObject jsonObject;
    JSONParser parser = new JSONParser();
    String apiModelPath = "src/test/java/api/models/";

    public JSONObject getApiModel(String sectionName, String fileName, String key) {
        String filePath = apiModelPath + sectionName + "/" + fileName + ".json";
        try {
            Object obj = parser.parse(new FileReader(filePath));
            jsonObject = (JSONObject) ((JSONObject) obj).get(key);
        } catch (IOException | ParseException var3) {
            throw new RuntimeException(var3);
        }
        return jsonObject;
    }
}