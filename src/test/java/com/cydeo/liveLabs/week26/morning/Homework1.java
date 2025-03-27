package com.cydeo.liveLabs.week26.morning;

import com.cydeo.utilities.HrTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class Homework1 extends HrTestBase {

    // * Task 1 :
    //     * - Given accept type is Json
    //     * - And base URI: http://34.226.136.145:1000/ords/hr
    //     * - When users sends GET request to endpoints:/countries/US
    //     * - Then status code is 200
    //     * - And Content - Type is application/json
    //     * - And response contains United States of America

    String url = "http://34.226.136.145:1000/ords/hr";

    @Test
    public void task1() {

        //     * - Given accept type is Json
        //     * - And base URI: http://34.226.136.145:1000/ords/hr
        //     * - When users sends GET request to endpoints:/countries/US

        Response response = given().accept(ContentType.JSON)
                                   //.baseUri("http://34.226.136.145:1000/ords/hr") //OPT1
                           .when().get("http://34.226.136.145:1000/ords/hr/countries/US"); //OPT2

        //     * - Then status code is 200
        //OPT1
        int actualStatusCode = response.getStatusCode();
        assertEquals(200, actualStatusCode);
        //OPT2
        assertEquals(200, response.getStatusCode());
        //OPT3
        assertEquals(HttpStatus.SC_OK, response.getStatusCode());

        //     * - And Content - Type is application/json
        //OPT1
        assertEquals("application/json",response.contentType());
        //OPT2
        assertEquals(ContentType.JSON.toString(),response.contentType());

        //     * - And response contains United States of America

        //OPT1
        //response.body().print();
        assertTrue(response.body().asString().contains("United States of America"));

        //OPT2
        //response.body().prettyPrint();
        assertTrue(response.body().asPrettyString().contains("United States of America"));

        //OPT3
        response.prettyPrint();
        assertTrue(response.asPrettyString().contains("United States of America"));



    }

    @Test
    public void task2() {


        //     * - Given accept type is Json
        //     * - And base URI: http://34.226.136.145:1000/ords/hr
        //     * - When users sends GET request to endpoints: /employees/1
        Response response = given().accept(ContentType.JSON)
                                   .log().all()
                           .when().get("/employees/1");

        //     * - Then status code is 404
        assertEquals(404, response.getStatusCode());
        assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusCode());

    }

    


}

