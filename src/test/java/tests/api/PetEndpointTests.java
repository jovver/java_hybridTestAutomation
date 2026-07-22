package tests.api;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.base.BaseAPITest;

import static io.restassured.RestAssured.given;

public class PetEndpointTests extends BaseAPITest {

    private String findByStatus = "/findByStatus?status=";

    @BeforeClass
    public void setUpEndpoint() {
        reqSpec.basePath(petEndpoint);
    }

    // TODO: Make data-driven
    @Test
    public void getPetByStatus() {
        String status = "available";
        given().
                spec(reqSpec).
                when().
                get(String.format("%s%s", findByStatus, status)).
                then().
                spec(assertOKResponse());

    }
}
