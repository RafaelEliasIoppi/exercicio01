package org.acme;

import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

@QuarkusTest
public class ConversionResourceTest {

    /**
     * Test case for converting kilometers to miles.
     *
     * This test sends a POST request to the "/Conversion/km-to-miles"
     * endpoint with a body of "50" (representing 50 kilometers).
     * The expected result is a response with a status code of 200 and a
     * body of "31.06855" (the equivalent value in miles).
     */
    
    @Test
void testConversionKmMiles() {
    given()
        .contentType(ContentType.TEXT)
        .body("50") // 50 kilometers per hour
    .when()
        .post("/Conversion/km-to-miles")
    .then()
        .contentType(ContentType.TEXT)
        .statusCode(200)
        .body(is("31,06855")); // Expecting the conversion result with a comma
}

    
    /**
     * Test case to verify the conversion from knots to kilometers per hour.
     * The expected value for 1 knot in km/h is 1.852.
     */
    
    
    @Test
void testConversionKnotsKm() {
    String response = 
        given()
            .when()
            .get("/Conversion/knots-to-km/1")
        .then()
            .statusCode(200)
            .extract().asString(); // Captura a resposta

    System.out.println("Response: " + response); // Imprime a resposta

    // Verifica se a resposta é um JSON válido
    given()
        .contentType(ContentType.JSON)
        .body(response) // Verifica o valor na resposta
    .then()
        .body("value", is(1.852f)); // Verifica o valor esperado
}

    
}
