package com.cydeo.liveLabs.week26;

import com.cydeo.utilities.HrTestBase;

public class Homework1 extends HrTestBase {

    /*

     * Task 1 :
     * - Given accept type is Json
     * - And base URI: http://34.226.136.145:1000/ords/hr
     * - When users sends request to endpoints:/countries/US
     * - Then status code is 200
     * - And Content - Type is application/json
     * - And response contains United States of America


     * Task 2 : NEGATIVE TESTS
     * - Given accept type is Json
     * - And base URI: http://34.226.136.145:1000/ords/hr
     * - When users sends request to endpoints: /employees/1
     * - Then status code is 404


     * Task 3 :
     * - Given Accept type  is Json
     * - And base URI: http://34.226.136.145:1000/ords/hr
     * - When users sends request to endpoints:/regions/1
     * - Then status code is 200
     * - And Content - Type is application/json
     * - And response contains Europe
     * - And header should contains Date
     * - And "Transfer-Encoding" should be "chunked"


     */

}
