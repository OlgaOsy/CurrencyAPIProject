
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class AllCurrencyEndpointTests {

private static Response response;

    @BeforeAll
    public static void setUp() {
        response = given().get(Consts.URL + Consts.LIVE_ENDPOINT + Consts.ACCESS_KEY);
        System.out.println(response.asString());
    }

    @Test
    public void getAllCurrencyListCodeTest() {
        response.then().statusCode(200);
    }

    @Test
    public void getQueryResponseTest() {
        response.then().body("success", equalTo(true));
    }


    @Test
    public void getSourceTest() {
        response.then().body("source", equalTo("USD"));
    }

    @Test
    public void getSQuotesTest() {
        response.then().body("quotes", notNullValue());
        response.then().body("quotes.USDCAD", notNullValue());
        response.then().body("quotes.USDEUR", notNullValue());
        response.then().body("quotes.USDNIO", notNullValue());
        response.then().body("quotes.USDRUB", notNullValue());
    }
}
