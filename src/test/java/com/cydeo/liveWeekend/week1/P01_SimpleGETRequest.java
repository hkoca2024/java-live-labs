package com.cydeo.liveWeekend.week1;

import com.cydeo.utilities.HrTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class P01_SimpleGETRequest extends HrTestBase {
    /**
     * Requirements:
     * - Given accept type is Json
     * - And base URI: http://34.226.136.145:1000/ords/hr
     * - When user sends GET request to endpoints:/regions
     * - Store the response in Response Object that comes from GET Request
     * - Print out followings:
         - Headers
         - Content-Type
         - Status Code
         - Response
         - Date
     * - Then verify followings:
         - Response body has "Europe"
         - Response headers has "Date"
     */

    @Test
    public void task1() {

        //Given--> condition that you have currently
        //When--> action that you will do
        //Then--> verification that you will verify


//* - Given accept type is Json
//* - And base URI: http://34.226.136.145:1000/ords/hr
//* - When user sends GET request to endpoints:/regions
//* - Store the response in Response Object that comes from GET Request

Response response = given()
                        .log().uri()
                        .accept(ContentType.JSON)
                    .when()
                        .get("/regions");

//* - Print out followings:
        //- Headers
        System.out.println("--------HEADERS-----------");
        //System.out.println(response.getHeaders());
        System.out.println(response.headers());

        //- Content-Type
        System.out.println("-----------CONTENT TYPE--------");
        System.out.println(response.getContentType());

        //- Status Code
        System.out.println("---------STATUS CODE----------");
        System.out.println(response.statusCode());

        //- Response
        System.out.println("---------RESPONSE----------");
        System.out.println("-----------response.prettyPrint()---------");
        response.prettyPrint();
        System.out.println("-----------response.prettyPeek()---------");
        response.prettyPeek();


        //- Date
        System.out.println("---------DATE----------");
        System.out.println(response.header("Date"));


//* - Then verify followings:
        //- Response headers has "Date"

        boolean hasDate = response.headers().hasHeaderWithName("Date");
        System.out.println("hasDate = " + hasDate);
        assertTrue(hasDate);

        //- Response body has "Europe"
        boolean hasEurope = response.asString().contains("Europe");
        System.out.println("hasEurope = " + hasEurope);
        assertTrue(hasEurope);



    }
}
