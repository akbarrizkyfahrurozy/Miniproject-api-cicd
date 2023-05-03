package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.hasKey;

public class ProdukKategori {

    protected static String url = "https://altashop-api.fly.dev/api/";
    @Step("user set endpoint for kategori")
    public String userSetEndpointForKategori() {
        return url + "categories";
    }

    @Step("user send request to endpoint kategori")
    public void userSendRequestToEndpointKategori() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Akbar Rizky Fahrurozy");
        requestBody.put("description", "mini project");

        SerenityRest.given().header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw").body(requestBody.toJSONString()).post(userSetEndpointForKategori());
    }

    @Step("user see new kategori response")
    public void userSeeNewKategoriResponse() {
        restAssuredThat(response -> response.body("$", hasKey("data")));

    }

    @Step("user send request kategori")
    public void userSendRequestKategori() {
        SerenityRest.given().header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw").get(userSetEndpointForKategori());
    }

    @Step("user see all kategori")
    public void userSeeAllKategori() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }
}
