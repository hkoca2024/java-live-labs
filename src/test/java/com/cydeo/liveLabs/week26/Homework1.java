package com.cydeo.liveLabs.week26;

import com.cydeo.utilities.HrTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.sql.ResultSet;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Homework1 extends HrTestBase {




/*
     * Task 2 : NEGATIVE TESTS
     * -
     * -


     * Task 3 :
     * -
     * -
     * -
     * -
     * -
     * -


     */
    @Test
    public void test1(){
        /*
        Given accept type is Json
     * - And base URI: http://34.226.136.145:1000/ords/hr
     * - When users sends GET request to endpoints:/countries/US
         */
        Response response= RestAssured.given()
                .baseUri("http://34.226.136.145:1000/ords/hr")
                .accept(ContentType.JSON)
                .get("/countries/US");
        // Then status code is 200
        assertEquals(200,response.statusCode());
        //And Content - Type is application/json
        assertEquals("application/json",response.getContentType());
        // And response contains United States of America
        assertTrue(response.body().asString().contains("United States of America"));



    }
    @Test
    public void test2(){
        /*
        Given accept type is Json
     * - And base URI: http://34.226.136.145:1000/ords/hr
     * - When users sends GET request to endpoints: /employees/1
         */
        Locale.setDefault(Locale.US);
        Response response= RestAssured.given()
                .baseUri("http://34.226.136.145:1000/ords/hr")
                .accept(ContentType.JSON)
                .when()
                .get("/employees/1");

        //Then status code is 404
        assertEquals(404,response.statusCode());

    }
     @Test
    public void test3(){
        /*
        Given Accept type  is Json
     * - And base URI: http://34.226.136.145:1000/ords/hr
     * - When users sends GET request to endpoints:/regions/1
         */
        Response response=RestAssured.given()
                .baseUri("http://34.226.136.145:1000/ords/hr")
                .accept(ContentType.JSON)
                .get("/regions/1");
        //Then status code is 200
         assertEquals(200,response.getStatusCode());
         //And Content - Type is application/json
         assertEquals("application/json",response.getContentType());
         //And response contains Europe
         assertTrue(response.body().asString().contains("Europe"));
         //And header should contains Date
         assertTrue(response.headers().hasHeaderWithName("Date"));
         //And "Transfer-Encoding" should be "chunked"
         assertEquals("chunked",response.header("Transfer-Encoding"));

     }



}
