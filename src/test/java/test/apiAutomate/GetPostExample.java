package test.apiAutomate;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class GetPostExample {

    @Test(priority = 1)
    public void getReq() {
        baseURI = "https://reqres.in/api";

        given()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data[4].first_name", equalTo("George"))
                .body("data.first_name", hasItems("George", "Rachel"))
                .log().all();
    }

    @Test(priority = 2)
    public void postReq() {
        JSONObject req = new JSONObject();
        req.put("name", "Viaan");
        req.put("Job", "PlaySchool");
        System.out.println(req.toJSONString());

        baseURI = "https://reqres.in/api";

                given()
                    .header("Content-Type", "application/json")
                    .header("x-api-key", "reqres-free-v1")
                    .body(req.toJSONString())
                .when()
                    .post("/users")
                .then()
                    .statusCode(201).log().all();

    }
}
