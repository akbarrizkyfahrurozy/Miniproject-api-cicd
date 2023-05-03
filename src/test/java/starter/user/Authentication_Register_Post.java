package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import com.github.javafaker.Faker;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;


public class Authentication_Register_Post {

    protected static String url = "https://altashop-api.fly.dev/api/";
    public static String email="";

    @Step("user set endpoint for register")
    public String userSetEndpointForRegister() {
        return url + "auth/register";
    }

    @Step("user send create account with valid data")
    public void userSendCreateAccountWithValidData() {
        Faker faker = new Faker();
        email = faker.internet().emailAddress();
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", email);
        requestBody.put("password", "akbarrizkyfahrurozy");
        requestBody.put("fullname", "Akbar Rizky Fahrurozy");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userSetEndpointForRegister());
    }

    @Step("user see status code 200 after send register")
    public void userSeeStatusCodeAfterSendRegister() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("user see new detail account")
    public void userSeeNewDetailAccount() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }

    @Step("user send POST HTTP request with empty password data register")
    public void userSendPOSTHTTPRequestWithEmptyPasswordDataRegister() {
        Faker faker = new Faker();
        email = faker.internet().emailAddress();
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", email);
        requestBody.put("password", "");
        requestBody.put("fullname", "Akbar Rizky Fahrurozy");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userSetEndpointForRegister());
    }

    @Step("user see status code 400 and fail to create account")
    public void userSeeStatusCodeAndFailToCreateAccount() {
        restAssuredThat(response -> response.statusCode(400));
    }

}
