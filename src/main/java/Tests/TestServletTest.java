package Tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestServletTest extends FunctionalTest {
    @Test
    public void basicPingTest() {
        given().when().get("/PayaraIntro1/test").then().statusCode(200);
    }

    
}
