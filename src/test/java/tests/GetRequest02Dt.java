package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class GetRequest02Dt {
    /*
        When I send a GET request to REST API URL
        "https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367"
        And Accept type is “application/JSON”
        Then
        HTTP Status Code should be 200
        And Response format should be "application/JSON"
           for the course whose id is "608bb976c9e4a800151ab367"
        And "code" should be "WP100"
        And "image" should be "wordpress.jpg"
        And English "title" should be "Wordpress"
        And Turkish "shortDescription"  should be "Wordpress in nasıl kullanılacağını öğreneceğiz"
   */
    @Test
    public void get01(){
        //1.Set the url
        String url = "https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367";
        //2.Set the expected data (we will learn it later)
        //3.Send the request
        Response response = given().
                accept(ContentType.JSON).
                when().
                get(url);
        response.prettyPrint();
        //4.Assert the things which are given in the test case
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("code", equalTo("WP100")).
                body("image",equalTo("wordpress.jpg")).
                body("title.en", equalTo("Wordpress"));



    }
}
