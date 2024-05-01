package utils;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import java.util.Map;

public class Requests {

    public static ValidatableResponse deleteRequest(String uri, String path, Map<String, String> header) {
        return RestAssured.given().relaxedHTTPSValidation().headers(header).delete(uri + path).then();
    }

    public static ValidatableResponse getRequest(String uri, String path) {
        return RestAssured.get(uri + path).then();
    }

    public static ValidatableResponse getRequest(String uri, String path, Map<String, String> header) {
        return RestAssured.given().relaxedHTTPSValidation().headers(header).get(uri + path).then();
    }

    public static ValidatableResponse getRequestWithAllResponse(String uri, String path, Map<String, String> options) {
        return RestAssured.given().relaxedHTTPSValidation().headers(options).get(uri + path).then();
    }

    public static ValidatableResponse getRequestWithQuery(String uri, String path, String query, Map<String, String> header) {
        return RestAssured.given().relaxedHTTPSValidation().headers(header).queryParam(query).get(uri + path).then();
    }

    public static ValidatableResponse postRequest(String uri, String path, String body, Map<String, String> options) {
        return RestAssured.given().relaxedHTTPSValidation().headers(options).body(body).post(uri + path).then();
    }

    public static ValidatableResponse putRequest(String uri, String path, String body, Map<String, String> options) {
        return RestAssured.given().relaxedHTTPSValidation().headers(options).body(body).put(uri + path).then();
    }
}