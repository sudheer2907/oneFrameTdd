package com.oneframe.helper;

import static io.restassured.RestAssured.given;

import org.json.JSONException;
import org.json.JSONObject;

import com.oneframe.utils.Utilities;

import io.restassured.response.Response;

public class ReqResHelper {

  private static Response response = null;
  private static String errorMessage = null;

  public static JSONObject getUserDetails() throws JSONException {
    String apiUrl = Utilities.getEnvironmentProperties("reqResBaseUrl") + "/api/users";
    response = given().when().relaxedHTTPSValidation().header("Content-Type", "application/json")
        .basePath("/api/users").queryParam("page", "2").get(apiUrl);
    if (response.statusCode() != 200) {
      errorMessage = response.then().extract().asString();
      throw new JSONException("Service to get uder details is not working " + errorMessage);
    } else {
      System.out.println("Get user details APIs is working fine.");
    }
    JSONObject getUserDetailsJson = new JSONObject(response.asString());
    return getUserDetailsJson;
  }

}
