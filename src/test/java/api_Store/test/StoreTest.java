package api_Store.test;

import api_Store.endPoints.storeEndPoint;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class StoreTest {

    @Test(priority = 1)
    public void testGetStoreInventory() {
        Response response = storeEndPoint.readUserStore();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void testPostStoreOrder() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("id", 0);
        jsonObj.put("petId", 0);
        jsonObj.put("quantity", 0);
        jsonObj.put("shipDate", "2025-07-30T04:09:36.863+0000");
        jsonObj.put("status", "Placed");
        jsonObj.put("complete", true);

        System.out.println(jsonObj.toJSONString());

        Response response = storeEndPoint.creteOrder(jsonObj.toJSONString());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void testGetStoreOrderID() {
        int orderId = 5;
        Response response = storeEndPoint.storeOrderID(orderId);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
