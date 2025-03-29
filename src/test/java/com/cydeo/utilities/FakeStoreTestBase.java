package com.cydeo.utilities;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class FakeStoreTestBase {

    @BeforeAll
    public static void init() {
        baseURI="https://api.escuelajs.co/api/v1";
    }

    @AfterAll
    public static void destroy() {
        reset();
    }

}
