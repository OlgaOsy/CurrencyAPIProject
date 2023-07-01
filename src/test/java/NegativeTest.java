import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
        import static org.hamcrest.Matchers.equalTo;


public class NegativeTest {

    private static Response response;
    private static String source = "&source=eee";

    @BeforeAll
    public static void setUp() {
        response = given().get(Consts.URL + Consts.LIVE_ENDPOINT + Consts.ACCESS_KEY + source);
        System.out.println(response.asString());
    }

    @Test
    public void invalidSourceTest() {
        System.out.println(response.asString());
        response.then().statusCode(200);
        response.then().body("error.code", equalTo(201));
        response.then().body("error.info", equalTo("You have supplied an invalid Source Currency. [Example: source=EUR]"));
    }}