package fr.jabbytechs.eclipse.demo;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ConversionResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/conversions")
          .then()
             .statusCode(200);
    }

}