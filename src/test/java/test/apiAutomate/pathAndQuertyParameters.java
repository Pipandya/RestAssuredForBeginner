package test.apiAutomate;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class pathAndQuertyParameters {

    @Test
    void testQueryAndPathParameters(){

                given()
                        .pathParam("mypath","users") //path param
                        .queryParam("page",2)//queryparm
                        .queryParam("id",5)
                        .header("Content-Type", "application/json")
                        .header("x-api-key", "reqres-free-v1")
                .when()
                        .get("https://reqres.in/api/{mypath}")
                .then()
                        .statusCode(200)
                        .log().all();
    }
}
