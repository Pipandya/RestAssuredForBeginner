package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndPoints {

    public static Response cretaeUser(User payload){
        Response response = given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(payload)
                .when()
                        .post(Route.post_url);

        return response;
    }

    public static Response readUser(String userName){
        Response response = given()
                    .pathParam("username",userName)
                .when()
                    .get(Route.get_url);
        return response;
    }

    public static Response updateUser(String userName, User payload){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .pathParam("username",userName)
                .when()
                .put(Route.update_url);
        return response;
    }

    public static Response deleteUser(String userName){
        Response response = given()
                .pathParam("username",userName)
                .when()
                .delete(Route.delete_url);
        return response;
    }
}

