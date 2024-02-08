package hu.masterfield.apitestcases;

import static io.restassured.RestAssured.given;

import hu.masterfield.utils.Consts;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

public class Gyakorlas extends BaseAPITest {
    @Test
    public void getUser() {
        Response response = given()
                .contentType(ContentType.JSON)
                .header(AUTH_HEADER, "Bearer " + authToken)
                .when()
                .get("/api/v1/user");
        response.prettyPrint();
        response.then()
                .statusCode(200)
                .body("id", is(4))
                .body("userProfile.id", is(5))
                .body("userProfile.firstName", is("Darnell"));
    }

    @Test
    public void getUserProfile() {
        String userID = globalTestData.getProperty(Consts.USER_ID);
        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .header(AUTH_HEADER, "Bearer " + authToken)
                .pathParam("userId", userID)
                .when()
                .get("/api/v1/user/{userId}/profile");
        response.prettyPrint();
        response.then()
                .body("id", is(76))
                .body("firstName", is("Nicole"))
                .body("lastName", is("Smith"))
                .body("title", is("Mrs."))
                .body("gender", is("F"))
                .body("ssn", is("573-51-2195"))
                .body("dob", is("04/05/2005"))
                .body("dom", is("02/03/2024"))
                .body("emailAddress", is("nsmith@masterfield.hu"))
                .body("homePhone", is("540-714-4114"));
    }

    @Test
    public void getUserByUsername() {
        String userName = globalTestData.getProperty(Consts.USER_NAME);
        Response response = given().log().params()
                .contentType(ContentType.JSON)
                .header(AUTH_HEADER, "Bearer " + authToken)
                .queryParam("username", userName)
                .when()
                .get("/api/v1/user/find");
        response.prettyPrint();
        response.then()
                .body("userProfile. emailAddress", is(userName));
    }

    @Test
    public void getAllAccounts() {
        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .header(AUTH_HEADER, "Bearer " + authToken)
                .when()
                .get("/api/v1/account");
        response.prettyPrint();
        response.then()
                .body("accountType.id[0]", is(11))
                .body("accountType.id[1]", is(8))
                .body("accountType.id[2]", is(10))
                .body("accountType.id[3]", is(11));
    }
}