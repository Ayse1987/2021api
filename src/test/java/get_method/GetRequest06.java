package get_method;

import base_url.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class GetRequest06 extends HerokuappBaseUrl {
    /*
    When
	  		I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/5
	  Then
		  HTTP Status Code should be 200
		  And response content type is “application/JSON”
		  And response body should be like;
		  { “firstname”: “Sally”,
		    “lastname”: “Ericsson”,
		    “totalprice”: 111,
		    “depositpaid”: false,
		    “bookingdates”: { “checkin”: “2017-05-23",
		                      “checkout”:“2019-07-02" }
		  }
     */
    @Test
    public void get01(){
        //1-Set the Url
        spec.pathParams("first","booking","second",5);
        //2- Set the expected data
        Response response= given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //Assert the output
//        response.
//                then().
//                assertThat().
//                statusCode(200).
//                contentType(ContentType.JSON).
//                body("firstname", equalTo("Sally"),
//                        "lastname", equalTo("Jackson"),"totalprice",equalTo(809),
//                        "depositpaid",equalTo(true),
//                        "bookingdates.checkin",equalTo("2016-12-02"),
//                        "bookingdates.checkout",equalTo("2021-03-09"));
        //JsonPath is used to navigate inside Json data
        JsonPath json= response.jsonPath();

        //2.way
//        assertEquals("Status code is not matching", 200,response.getStatusCode());
//        assertEquals("Content type is not Json","application/json; charset=utf-8",response.contentType());
//        assertEquals("First name is not matching","Jim",json.getString("firstname"));
//        assertTrue("Lat name is not matching",json.getString("lastname").equals("Smith"));
        //assertTrue("Totalprice is not matching",json.getInt("totalprice")==916);
        //assertTrue("Deposit paid is not matching",json.getBoolean("depositpaid")==true);
        //assertEquals("Checkin date is not matching", "2020-06-30",json.getString("bookingdates.checkin"));
        //assertTrue("Checkout date is not matching",json.getString("bookingdates.checkout").equals("2021-02-05"));

        //3.way
        /*
        Soft Assertion(Verification): Execution is not stopped in failure
        to use soft assertion we have 3 steps:
        1-Create an object from SoftAssert Class
        2- By using the object, use assertEquals(), assertTrue(),assertFalse()
        3-DO NOT FORGET to use "assertAll() method at the end

         */
        //1-Create an object from SoftAssertClass
        SoftAssert softAssert=new SoftAssert();
       // 2-
        softAssert.assertEquals(json.getString("firstname"),"Mark","Firtname is not matching");
        softAssert.assertEquals(json.getString("lastname"),"Jones","Lastname is not matching");
        softAssert.assertEquals(json.getInt("totalprice"),350,"Totalprice is not matching");
        softAssert.assertEquals(json.getString("bookingdates.checkout"),"2020-12-20","Checkout date  is not matching");

        //3-DO NOT FORGET to use "assertAll() method at the end
        softAssert.assertAll();








    }
}
