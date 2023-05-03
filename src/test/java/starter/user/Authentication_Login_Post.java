package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class Authentication_Login_Post {

    protected static String url = "https://altashop-api.fly.dev/api/";

    @Step("user set endpoint for login")
    public String userSetEndpointForLogin() {
        return url + "auth/login";
    }

    @Step("user send POST HTTP request with valid data")
    public void userSendPOSTHTTPRequestWithValidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "someone@mail.com");
        requestBody.put("password", "123123");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userSetEndpointForLogin());
    }

    @Step("user see status code 200")
    public void userSeeStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("get valid data")
    public void getValidData() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }

    @Step("user send POST HTTP request with invalid data")
    public void userSendPOSTHTTPRequestWithInvalidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "someone@mail.com");
        requestBody.put("password", "passwordSalah");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userSetEndpointForLogin());
    }

    @Step("user see status code 400")
    public void userSeeStatusCode400() {
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("user get error message")
    public void userGetErrorMessage() {
        restAssuredThat(response -> response.body("'error'", equalTo("email or password is invalid")));
    }
}
