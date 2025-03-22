package com.cydeo.liveWeekend.week1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class P01_SimpleGETRequest {
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

Response response = RestAssured.given()
                                    .log().uri()
                                    .accept(ContentType.JSON)
                                .when()
                                    .get("/regions");


//* - Store the response in Response Object that comes from GET Request
//* - Print out followings:
        //- Headers
        //- Content-Type
        //- Status Code
        //- Response
        //- Date
//* - Then verify followings:
        //- Response body has "Europe"
        //- Response headers has "Date"

    }
}
