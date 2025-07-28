package test.apiAutomate;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Authentication {
   // @Test(priority = 1)
    void testBasicAuthentication(){
        given()
                .auth().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .log().all();
    }

  //  @Test(priority = 2)
    void testDigestAuthentication(){
        given()
                .auth().digest("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .log().all();
    }

   // @Test(priority = 3)
    void testPreemotiveAuthentication(){
        given()
                .auth().preemptive().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }
   // @Test
    void testBarerTokenAuth(){
        String barerToken = "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";
        given()
                .header("Authorization","Bearer "+barerToken)
                .when()
                .get("https://api.github.com/user/repos")
                .then()
                .statusCode(200)
                .log().all();
    }

   // @Test
    void testOAuthAuthentication(){
        given()
                .auth().oauth("consumerKey" ,"consumerSecrate","accessToken","tokenSecrate")
                .when()
                .get("")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    void testOAuth2Authentication(){
        given()
                .auth().oauth2("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")
                .when()
                .get("https://api.github.com/user/repos")
                .then()
                .statusCode(200)
                .log().all();

    }

    void testAPIKeyAuthentication(){

    }
}
