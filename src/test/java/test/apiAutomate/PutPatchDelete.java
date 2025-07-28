package test.apiAutomate;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PutPatchDelete {
    @Test(priority = 1)
    public void putRequest(){
        JSONObject req = new JSONObject();
        req.put("name", "Viaan");
        req.put("Job", "PlaySchool");

        baseURI = "https://reqres.in";

                given()
                    .header("Content-Type","application/json")
                    .header("x-api-key", "reqres-free-v1")
                    .body(req.toJSONString())
                .when()
                    .put("/api/users/2")
                .then()
                    .statusCode(200).log().all();

    }

    @Test(priority = 2)
    public void patchRequest(){
        JSONObject req = new JSONObject();
        req.put("name", "Viaan");
        req.put("Job", "PlaySchool");

        baseURI = "https://reqres.in";

                given()
                    .header("Content-Type","application/json")
                    .header("x-api-key", "reqres-free-v1")
                    .body(req.toJSONString())
                .when()
                    .patch("/api/users/2")
                .then()
                    .statusCode(200).log().all();

    }

    @Test(priority = 3)
    public void deleteUser(){
        baseURI = "https://reqres.in";

        given()
                .header("Content-Type","application/json")
                .header("x-api-key", "reqres-free-v1")
                .when()
                .delete("/api/users/2")
                .then()
                .statusCode(204).log().all();
    }
}
