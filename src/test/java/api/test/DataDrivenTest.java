package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataDrivenTest {

    @Test(priority = 1,dataProvider = "Data",dataProviderClass = DataProviders.class)
    public void testPostUser(String userID,String userName,String fname,String lname,String useremail,String pwd,String ph){

        User userPayload = new User();
        if(userID != null) {
            userPayload.setId(Integer.parseInt(userID));
            userPayload.setUsername(userName);
            userPayload.setFirstName(fname);
            userPayload.setLastName(lname);
            userPayload.setPassword(pwd);
            userPayload.setPhone(ph);
        }

        Response response = UserEndPoints.cretaeUser(userPayload);
        response.then().log().all();
    }

    @Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
    public void testDeleteUserByName(String userName){
        if(userName != null) {
            Response response = UserEndPoints.deleteUser(userName);
            Assert.assertEquals(response.getStatusCode(), 200);
        }
    }
}
