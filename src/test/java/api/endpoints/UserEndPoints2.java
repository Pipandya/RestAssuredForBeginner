package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class UserEndPoints2 {

    static Properties getURL(){
        try {
            FileInputStream fis = new FileInputStream("./src/test/resources/routes.Properties");
            Properties prop = new Properties();
            prop.load(fis);
            return prop;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
       // ResourceBundle routes = ResourceBundle.getBundle("routes");
    }

    public static Response cretaeUser(User payload){

        String post_url = getURL().getProperty("post_url");

        Response response = given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(payload)
                .when()
                        .post(post_url);

        return response;
    }

    public static Response readUser(String userName){
        String get_url = getURL().getProperty("get_url");

        Response response = given()
                    .pathParam("username",userName)
                .when()
                    .get(get_url);
        return response;
    }

    public static Response updateUser(String userName, User payload){
        String update_url = getURL().getProperty("update_url");

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .pathParam("username",userName)
                .when()
                .put(update_url);
        return response;
    }

    public static Response deleteUser(String userName){
        String delete_url = getURL().getProperty("delete_url");

        Response response = given()
                .pathParam("username",userName)
                .when()
                .delete(delete_url);
        return response;
    }
}

