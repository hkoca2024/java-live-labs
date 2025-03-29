package com.cydeo.liveWeekend.week2;

import com.cydeo.utilities.FakeStoreTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class P01_PathParam extends FakeStoreTestBase {

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
                            .pathParam("id", 52)
                    .when().get("/products/{id}");

        //     * - And print response
        //OPT1
        response.prettyPrint();
        //OPT2
        //response.prettyPeek();

        //     * - Then verify status code should be 200
        assertEquals(200,response.statusCode());

        //     * - And verify content Type is application/json; charset=utf-8
        assertEquals(ContentType.JSON.withCharset("utf-8"),response.contentType());

        //     * - And verify id in the response is 52

        //OPT1
       int id=response.path("id");
       assertEquals(52,id);
       //OPT2 needs casting
       //assertEquals(52,response.path("id"));

        //     * - And verify title is "Crown"
        assertEquals("Crown",response.path("title"));

        //     * - And verify category name is "Royal Items"
        assertEquals("Royal Items", response.path("category.name"));




    }
}
