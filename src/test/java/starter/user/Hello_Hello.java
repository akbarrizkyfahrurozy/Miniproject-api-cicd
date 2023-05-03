package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Hello_Hello {

    protected static String url = "https://altashop-api.fly.dev/api/";

    @Step("user set endpoint for hello")
    public String userSetEndpointForHello() {
        return url + "hello";
    }

    @Step("user send request to endpoint")
    public void userSendRequestToEndpoint() {
        SerenityRest.given().get(userSetEndpointForHello());
    }

    @Step("user see status code {int} after send request")
    public void userSeeStatusCodeAfterSendRequest(int arg0) {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("user show hello message")
    public void userShowHelloMessage() {
        
    }
}
