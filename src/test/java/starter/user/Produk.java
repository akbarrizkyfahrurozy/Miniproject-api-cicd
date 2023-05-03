package starter.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.hasKey;

public class Produk {

    protected static String url = "https://altashop-api.fly.dev/api/";

    @Step("user set endpoint for product")
    public String userSetEndpointForProduct() {
        return url + "products";
    }

    @Step("user send POST HTTP request with valid data product")
    public void userSendPOSTHTTPRequestWithValidDataProduct() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "PS4");
        requestBody.put("description", "ps4 baru");
        requestBody.put("price", 3000);

        SerenityRest.given().header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw").body(requestBody.toJSONString()).post(userSetEndpointForProduct());
    }

    @Step("user see new detail product")
    public void userSeeNewDetailProduct() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }

    @Step("user send request")
    public void userSendRequest() {
        SerenityRest.given().header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw").get(userSetEndpointForProduct());
    }

    @Step("user see product")
    public void userSeeProduct() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }

    @Step("user set endpoint for delete product")
    public String userSetEndpointForDeleteProduct() {
        return url + "products/10002";
    }

    @Step("user send request for delete product")
    public void userSendRequestForDeleteProduct() {
        SerenityRest.given().header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw").delete(userSetEndpointForDeleteProduct());
    }

    @Step("user receive valid data for deleting product")
    public void userReceiveValidDataForDeletingProduct() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }

    @Step("user set endpoint for product comments")
    public String userSetEndpointForProductComments() {
        return url + "products/2/comments";
    }

    @Step("user send request for product comments")
    public void userSendRequestForProductComments() {
        SerenityRest.given().header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw").get(userSetEndpointForProductComments());
    }

    @Step("user receive valid data for product comments")
    public void userReceiveValidDataForProductComments() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }
}
