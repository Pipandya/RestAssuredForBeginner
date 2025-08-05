package test.apiAutomate;

import api.payload.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class SerializationDeserialization {

    @Test(priority = 1)
    void convertPojotoJson() throws JsonProcessingException {    //serialization
        User userPojo = new User();

        userPojo.setFirstName("Scott");
        userPojo.setLastName("Katariya");
        userPojo.setEmail("scott@abc.com");
        userPojo.setId(10);
        userPojo.setUsername("Tya");
        userPojo.setPassword("try@123");
        userPojo.setPhone("4343434343");

        ObjectMapper objMapper = new ObjectMapper();
        String jsonData = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userPojo);
        System.out.println(jsonData);

    }

    @Test(priority = 2)
    void convertJsontoPojo() throws JsonProcessingException {      //Deseralization
        String jsondata = "{\n" +
                "  \"id\" : 10,\n" +
                "  \"username\" : \"Tya\",\n" +
                "  \"firstName\" : \"Scott\",\n" +
                "  \"lastName\" : \"Katariya\",\n" +
                "  \"email\" : \"scott@abc.com\",\n" +
                "  \"password\" : \"try@123\",\n" +
                "  \"phone\" : \"4343434343\",\n" +
                "  \"userStatus\" : 0\n" +
                "}";

        ObjectMapper objMapper = new ObjectMapper();
        User usrPojo = objMapper.readValue(jsondata,User.class);
        System.out.println(usrPojo.getId());
        System.out.println(usrPojo.getFirstName());
        System.out.println(usrPojo.getLastName());
        System.out.println(usrPojo.getEmail());
        System.out.println(usrPojo.getPassword());
        System.out.println(usrPojo.getUsername());
        System.out.println(usrPojo.getPhone());

    }
}
