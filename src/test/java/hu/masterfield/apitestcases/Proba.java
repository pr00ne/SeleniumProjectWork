package hu.masterfield.apitestcases;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;

public class Proba extends BaseAPITest {
    @Test
    public void TC_Proba() {
        ValidatableResponse response = given()
                .headers(AUTH_HEADER, "Bearer " + authToken)
                .contentType(JSON)
                .when()
                .get("/api/v1/user")
                .then()
                .statusCode(200)
                .body("username", equalTo("admin@demo.io"));

       // response.prettyPrint();
    }
}
