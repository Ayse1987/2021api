package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;


public class GetRequest01Dt {
    /*
    ==Gherkin Language
    if you use "Given","When","Then","And" to create test scenarios, it means you are using Gherkin Language
    "Given" : it declared prerequisites
    "When": I t defines actions which user will perform
    "Then":wetalk about outcomes
    "And": In any part if you have multiple steps use "And" between them
     */

    /*
       When
           I send a GET Request to the URL https://api-techproed-test.herokuapp.com/courses
       Then
           HTTP Status Code should be 200
       And
           Content Type should be JSON
       And
           Status Line should be HTTP/1.1 200 OK
   */


    @Test //-->we imported from junit
    public void get01() {
        //we will follow these four steps for each test in API
        //1st step: Set the url
        String url="https://api-techproed-test.herokuapp.com/courses";
        //2nd step: Set the expected data(we will learn it later)
        //3rd step: Send the request(Like clicking on send button in the post man)
        Response response = given().
                                accept(ContentType.JSON).//parantez icine "application/json" da yazabilirsin hata verince
                            when().// it is not must to use accept() but sometimes it solves the problems
                                get(url);
        //To see response body on the console use prettyPrint()
        response.prettyPrint();
        //4th step: Assert the things which are given in the test case
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.XML).statusLine("HTTP/1.1 200 OK");

        //if execution stops after first error it is called hard assertion.
        // If execution doesnt stop for any error it is called soft assertion
        //You can take seperate reports for each error in soft assertion


        //How to print status_code, content type, statusline, time in the console
        System.out.println(response.getStatusLine());//HTTP/1.1 200 OK
        System.out.println(response.statusCode());//200
        System.out.println(response.getContentType());
        System.out.println(response.getTime());
        System.out.println(response.getHeaders());
        //Test anotation kullanmak zorundasin test methodu yazarken

    }






}