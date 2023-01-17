import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestPost {

    @Test
    void TestPostBodyText() {
        given()
                .baseUri("https://postman-echo.com")
                .body("text")

                .when()
                .post("/post")

                .then()
                .statusCode(400)
                .body("data", equalTo("text"));

    }

    @Test
    void TesPostRuBodyText() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Русский язык")

                .when()
                .post("/post")

                .then()
                .statusCode(200)
                .body("data", equalTo("Русский язык"));
    }
}
