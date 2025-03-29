package com.cydeo.liveWeekend.week2;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class P01_PathParam {

    /**
     * Requirements:
     * - Given accept type is Json
     * - And base URI: https://api.escuelajs.co/api/v1
     * - And path parameter  id is 52
     * - When user sends GET request to endpoints:/products/{id}
     * - And print response
     * - Then verify status code should be 200
     * - And verify content Type is application/json; charset=utf-8
     * - And verify id in the response is 52
     * - And verify title is "Crown"
     * - And verify category name is "Royal Items"
     */

    @Test
    public void responsePath() {
        //     * - Given accept type is Json
        //     * - And base URI: https://api.escuelajs.co/api/v1
        //     * - And path parameter  id is 52
        //     * - When user sends GET request to endpoints:/products/{id}

Response response = given().log().uri()
                            .accept(ContentType.JSON)
                            .baseUri("https://api.escuelajs.co/api/v1")
                            .pathParam("id", 52)
                    .when().get("/products/{id}");


        //     * - And print response
        //     * - Then verify status code should be 200
        //     * - And verify content Type is application/json; charset=utf-8
        //     * - And verify id in the response is 52
        //     * - And verify title is "Crown"
        //     * - And verify category name is "Royal Items"




    }
}
