package test.apiAutomate;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class xmlParsing {

    @Test
    void testXMLResponse(){
        given()
                .when()
                .get("http://restapi.adequateshop.com/api/Traveler?page=1")
                .then()
                .statusCode(200)
                .header("Content-Type","application/xml; charset=utf-8")
                .body("TravelerinformationResponse.page",equalTo("1"));
    }
}
