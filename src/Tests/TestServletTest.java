import Domains.Movie;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestServletTest extends Tests.FunctionalTest {
    @Test
    public void basicPingTest() {
        given().when().get("/test").then().statusCode(200);
    }

    @Test
    public void getAvengersTest() {
        given().when().get("/rest/movie/1").then()
                .statusCode(200)
                .assertThat()
                .body("name", equalTo("The Avengers"));
    }
}
