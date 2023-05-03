package starter.user;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.hasKey;

public class Orders {

    protected static String url = "https://altashop-api.fly.dev/api/";
    protected static String token = "";

    @Step("user set endpoint for order")
    public String userSetEndpointForOrder() {
        return url + "orders";
    }
    @Step("user success login with valid account")
    public void userSuccessLoginWithValidAccount() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "someone@mail.com");
        requestBody.put("password", "123123");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(url+"auth/login");
        Response resp = SerenityRest.lastResponse();
        token = resp.getBody().jsonPath().get("data");
    }

    @Step("user input token in authorization")
    public void userInputTokenInAuthorization() {
        JSONObject requestBody = new JSONObject();
        requestBody.put( "product_id",1);
        requestBody.put( "quantity",3);

        JSONArray bodyArray = new JSONArray();
        bodyArray.add(requestBody);
        SerenityRest.given().header("Authorization", "Bearer "+token).body(bodyArray.toJSONString()).post(userSetEndpointForOrder());
    }

    @Step("user see new order response")
    public void userSeeNewOrderResponse() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }

    @Step("user send request to endpoint order")
    public void userSendRequestToEndpointOrder() {
        SerenityRest.given().header("Authorization", "Bearer "+token).get(userSetEndpointForOrder());
    }

    @Step("user show list of the order")
    public void userShowListOfTheOrder() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }

}
