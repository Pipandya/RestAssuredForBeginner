package api_Store.endPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.io.FileInputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class storeEndPoint {

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
    }

    public static Response readUserStore(){
        String get_url_store = getURL().getProperty("get_url_store");
        Response response = given()
                .when()
                .get(get_url_store);
        return response;
    }


    public static Response creteOrder(String storePayload){
        String post_url_store = getURL().getProperty("post_url_store");

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(storePayload)
                .when()
                .post(post_url_store);

        return response;
    }

    public static Response storeOrderID(int orderId){
        String get_url_storeOrderId = getURL().getProperty("get_url_store_orderId");

        Response response = given()
                .pathParam("orderId",orderId)
                .when()
                .get(get_url_storeOrderId);

        return response;
    }
}
