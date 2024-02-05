package hu.masterfield.apitestcases;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HealthCheckTest extends BaseAPITest {
    /**
     * Ez a teszt ellenőrzi, hogy az alkalmazás elérhető-e
     * GET /api/v1/health
     */
    @Test
    public void testHelathCheck() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/v1/health");
        response.prettyPrint();
        response.then()
                .statusCode(200);
        assertEquals(response.prettyPrint(), "Application Available");
    }
}
