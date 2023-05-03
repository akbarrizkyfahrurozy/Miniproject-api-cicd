package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.*;

public class UserSteps {

    @Steps
    Authentication_Login_Post post;

    @Steps
    Authentication_Register_Post registerPost;

    @Steps
    Hello_Hello helloHello;

    @Steps
    Orders ordersCreateNewOrder;

    @Steps
    ProdukKategori produkKategori;

    @Steps
    Produk produk;

    //scenario 1 Authentication_Login
    @Given("user set endpoint for login")
    public void userSetEndpointForLogin() {
        post.userSetEndpointForLogin();
    }

    @When("user send POST HTTP request with valid data")
    public void userSendPOSTHTTPRequestWithValidData() {
        post.userSendPOSTHTTPRequestWithValidData();
    }

    @Then("user see status code 200")
    public void userSeeStatusCode() {
        post.userSeeStatusCode200();
    }

    @And("get valid data")
    public void getValidData() {
        post.getValidData();
    }
    //scenario 2 Authentication_Login
    @When("user send POST HTTP request with invalid data")
    public void userSendPOSTHTTPRequestWithInvalidData() {
        post.userSendPOSTHTTPRequestWithInvalidData();
    }

    @Then("user see status code 400")
    public void userSeeStatusCode400() {
        post.userSeeStatusCode400();
    }

    @And("user get error message")
    public void userGetErrorMessage() {
        post.userGetErrorMessage();
    }

    //scenario 1 Authentication_Register
    @Given("user set endpoint for register")
    public void userSetEndpointForRegister() {
        registerPost.userSetEndpointForRegister();
    }

    @When("user send create account with valid data")
    public void userSendCreateAccountWithValidData() {
        registerPost.userSendCreateAccountWithValidData();
    }

    @Then("user see status code 200 after send register")
    public void userSeeStatusCodeAfterSendRegister() {
        registerPost.userSeeStatusCodeAfterSendRegister();
    }

    @And("user see new detail account")
    public void userSeeNewDetailAccount() {
        registerPost.userSeeNewDetailAccount();
    }

    //scenario 2 Authentication_Register
    @When("user send POST HTTP request with empty password data register")
    public void userSendPOSTHTTPRequestWithEmptyPasswordDataRegister() {
        registerPost.userSendPOSTHTTPRequestWithEmptyPasswordDataRegister();
    }

    @Then("user see status code 400 and fail to create account")
    public void userSeeStatusCodeAndFailToCreateAccount() {
        registerPost.userSeeStatusCodeAndFailToCreateAccount();
    }

    @Given("user set endpoint for hello")
    public void userSetEndpointForHello() {
        helloHello.userSetEndpointForHello();
    }

    @When("user send request to endpoint")
    public void userSendRequestToEndpoint() {
        helloHello.userSendRequestToEndpoint();
    }

    @Then("user show hello message")
    public void userShowHelloMessage() {
        helloHello.userShowHelloMessage();
    }

    @Given("user set endpoint for order")
    public void userSetEndpointForOrder() {
        ordersCreateNewOrder.userSetEndpointForOrder();
    }
    @And("user success login with valid account")
    public void userSuccessLoginWithValidAccount() {
        ordersCreateNewOrder.userSuccessLoginWithValidAccount();
    }

    @When("user input token in authorization")
    public void userInputTokenInAuthorization() {
        ordersCreateNewOrder.userInputTokenInAuthorization();
    }

    @And("user see new order response")
    public void userSeeNewOrderResponse() {
        ordersCreateNewOrder.userSeeNewOrderResponse();
    }

    @When("user send request to endpoint order")
    public void userSendRequestToEndpointOrder() {
        ordersCreateNewOrder.userSendRequestToEndpointOrder();
    }

    @Then("user show list of the order")
    public void userShowListOfTheOrder() {
        ordersCreateNewOrder.userShowListOfTheOrder();
    }

    @Given("user set endpoint for kategori")
    public void userSetEndpointForKategori() {
        produkKategori.userSetEndpointForKategori();
    }

    @And("user send request to endpoint kategori")
    public void userSendRequestToEndpointKategori() {
        produkKategori.userSendRequestToEndpointKategori();
    }

    @And("user see new kategori response")
    public void userSeeNewKategoriResponse() {
        produkKategori.userSeeNewKategoriResponse();
    }

    @When("user send request kategori")
    public void userSendRequestKategori() {
        produkKategori.userSendRequestKategori();
    }

    @And("user see all kategori")
    public void userSeeAllKategori() {
        produkKategori.userSeeAllKategori();
    }

    @Given("user set endpoint for product")
    public void userSetEndpointForProduct() {
        produk.userSetEndpointForProduct();
    }

    @When("user send POST HTTP request with valid data product")
    public void userSendPOSTHTTPRequestWithValidDataProduct() {
        produk.userSendPOSTHTTPRequestWithValidDataProduct();
    }

    @And("user see new detail product")
    public void userSeeNewDetailProduct() {
        produk.userSeeNewDetailProduct();
    }

    @When("user send request")
    public void userSendRequest() {
        produk.userSendRequest();
    }

    @And("user see product")
    public void userSeeProduct() {
        produk.userSeeProduct();
    }

    @Given("user set endpoint for delete product")
    public void userSetEndpointForDeleteProduct() {
        produk.userSetEndpointForDeleteProduct();
    }

    @When("user send request for delete product")
    public void userSendRequestForDeleteProduct() {
        produk.userSendRequestForDeleteProduct();
    }

    @And("user receive valid data for deleting product")
    public void userReceiveValidDataForDeletingProduct() {
        produk.userReceiveValidDataForDeletingProduct();
    }

    @Given("user set endpoint for product comments")
    public void userSetEndpointForProductComments() {
        produk.userSetEndpointForProductComments();
    }

    @When("user send request for product comments")
    public void userSendRequestForProductComments() {
        produk.userSendRequestForProductComments();
    }

    @And("user receive valid data for product comments")
    public void userReceiveValidDataForProductComments() {
        produk.userReceiveValidDataForProductComments();
    }
}
