package com.cydeo.liveWeekend.week2;

import com.cydeo.utilities.FakeStoreTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class P02_QueryParam extends FakeStoreTestBase {

    /*
    OFFSET & LIMIT

    limit:500  offset:0   total:2400

    request   limit   offset              bookAtEachPage  bookTotal
        1       500     0                   500             500
        2       500     500(offset+limit)   500             1000
        3       500     1000(offset+limit)  500             1500
        4       500     1500(offset+limit)  500             2000
        5       500     2000(offset+limit)  500             2400
        6       500     2500  XXXXXXXXXXXXXXXXXXXXXXXXXXXXX 2400

    while(offset<total) {
        request
    }
     */

 /**
     * Requirements:
     * - Given accept type is Json
     * - And base URI: https://api.escuelajs.co/api/v1
     * - And query parameters are limit=10 and offset=0
     * - When user sends GET request to endpoints:/products
     * - And print response
     * - Then verify status code should be 200
     * - And verify content Type is application/json; charset=utf-8
     * - And verify each product has id
     * - And verify each category has id
     * - And verify each category has names
     * - And print the total number of titles
     */

 @Test
 public void queryParam() {

     Map<String,Integer> queryMap= new HashMap<>();
     queryMap.put("limit", 10);
     queryMap.put("offset", 0);

     //     * - Given accept type is Json
     //     * - And base URI: https://api.escuelajs.co/api/v1
     //     * - And query parameters are limit=10 and offset=0
     //     * - When user sends GET request to endpoints:/products
     Response response = given().accept(ContentType.JSON)
                                 //.queryParam("limit", 10)
                                 //.queryParam("offset", 0)
                                 .queryParams(queryMap)
                        .when().get("/products");

     //     * - And print response
            response.prettyPrint();

     //     * - Then verify status code should be 200
     int actualStatusCode = response.statusCode();
     assertEquals(200, actualStatusCode);

     //     * - And verify content Type is application/json; charset=utf-8
     assertEquals("application/json; charset=utf-8", response.contentType());

     //     * - And verify each product has id
     List<Integer> allIDs = response.path("id");
     System.out.println("allIDs = " + allIDs);

     for (Integer eachID : allIDs) {
         assertNotNull(eachID);
     }

     //     * - And verify each category has id


     //     * - And verify each category has names
     //     * - And print the total number of titles




 }
}
