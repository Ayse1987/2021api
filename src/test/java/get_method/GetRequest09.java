package get_method;

import base_url.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class GetRequest09 extends HerokuappBaseUrl {
    /*
    When
	 		I send GET Request to https://restful-booker.herokuapp.com/booking/1
	 	Then
	 		Response body should be like that;
	 		{
			    “firstname”: “Eric”,
			    “lastname”: “Smith”,
			    “totalprice”: 555,
			    “depositpaid”: false,
			    “bookingdates”: {
			        “checkin”: “2016-09-09”,
			        “checkout”: “2017-09-21”
			     }
			}
     */
    @Test
    public void get01(){
        //1-Set the url
        spec.pathParams("first","booking","second",1);
        //Set the expected Data
        Map<String,String>bookingdates= new HashMap<>();
        bookingdates.put("checkin","2016-09-09");
        bookingdates.put("checkout","2017-09-21");

        Map<String,Object>expectedDataMap=new HashMap<>();
        expectedDataMap.put("firstname","Eric");
        expectedDataMap.put("lastname","Smith");
        expectedDataMap.put("totalprice",555);
        expectedDataMap.put("depositpaid",false);
        expectedDataMap.put("bookingdates",bookingdates);
        //3 Send the request
        Response response= given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Use GSON for De-Serialization
        Map<String,Object>actualDataMap=response.as(HashMap.class);
        System.out.println(actualDataMap);

        assertEquals(expectedDataMap.get("firstname"),actualDataMap.get("firstname"));
        assertEquals(expectedDataMap.get("lastname"),actualDataMap.get("laststname"));
        assertEquals(expectedDataMap.get("totalprice"),actualDataMap.get("totalprice"));
        assertEquals(expectedDataMap.get("depositpaid"),actualDataMap.get("depositpaid"));
        assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkin"), ((Map)actualDataMap.get("bookingdates")).get("checkin"));
        assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkout"), ((Map)actualDataMap.get("bookingdates")).get("checkout"));



    }
}
