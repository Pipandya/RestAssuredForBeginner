package test.apiAutomate;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import org.json.JSONObject;
import org.json.JSONException;




public class GetPostExample {

   // @Test(priority = 1)
    public void getReq() {
        baseURI = "https://reqres.in/api";

        given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data[4].first_name", equalTo("George"))
                .body("data.first_name", hasItems("George", "Rachel"))
                .log().all();
    }

   // @Test(priority = 2)
    public void postReq() {
        JSONObject req = new JSONObject();
        req.put("name", "Viaan");
        req.put("Job", "PlaySchool");
       // System.out.println(req.toJSONString());

        baseURI = "https://reqres.in/api";

                given()
                    .header("Content-Type", "application/json")
                    .header("x-api-key", "reqres-free-v1")
                   // .body(req.toJSONString())
                .when()
                    .post("/users")
                .then()
                    .statusCode(201).log().all();

    }

  //  @Test(priority = 3)
    public void getReq1() {
        baseURI = "https://reqres.in/api";

        Response res = given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .get("/users?page=2");
        System.out.println(res.asPrettyString());

        //only get String data
        String email1 = res.jsonPath().get("data[2].email").toString();
        System.out.println(email1);

        //get list of data
        JsonPath jsonPath = res.jsonPath();
        List<String> list1 = jsonPath.getList("data");
        System.out.println(list1);
        Assert.assertEquals(list1.size(),6);

        //get all emailId
        List<String> email = jsonPath.getList("data.email");
        for (String emailID : email){
            System.out.println(emailID);
        }
    }

    @Test(priority = 4)
    public void getReqwithJsonObject() {
        baseURI = "https://reqres.in/api";

        Response res = given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .get("/users?page=2");
        System.out.println(res.asPrettyString());

        //converting response to jsonObject type
        JSONObject jo = new JSONObject(res.asString());
        for (int i=0;i<jo.getJSONArray("data").length();i++){
            String emeil = jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
            System.out.println(emeil);
        }
    }
}
