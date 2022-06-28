package get_method;


import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest04 extends JsonPlaceHolderBaseUrl {
    /*When
    I send a GET request to REST API URL https://jsonplaceholder.typicode.com/todos
  And Accept type is "application/json"
  Then
  HTTP Status Code should be 200
  And Response format should be "application/json"
  And there should be 200 todos
  And "quis eius est sint explicabo" should be one of the todos
  And 2, 7, and 9 should be among the userIds

     */
    @Test
    public void get01(){
        //1-Set the url
        spec.pathParam("first","todos");
        //2-Set expected data
        //3- send the request
        Response response= given().spec(spec).when().get("{first}");
       // response.prettyPrint();
        System.out.println(response.getBody().asString().contains(""));
        //4-Assert the output
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id", hasSize(165)).
                        body("title",hasItem("quis eius est sint explicabo")).
                body("userId",hasItems(2,7,9));//Instead of "application/json" we can use ContentType/JSON as well-> recommended
    }

}
