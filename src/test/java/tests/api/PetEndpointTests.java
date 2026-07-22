package tests.api;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseAPITest;

import static io.restassured.RestAssured.given;

public class PetEndpointTests extends BaseAPITest {

    private final String findByStatus = "/findByStatus?status=";

    @BeforeClass
    public void setUpEndpoint() {
        setBasePath(petEndpoint);
    }

    @DataProvider(name = "Pet Status")
    public static Object[] petStatus(){
        return new Object[]{"available", "pending", "sold"};
    }

    @Test(dataProvider = "Pet Status")
    public void getPetByStatus(String status) {
        given().
                spec(reqSpec).
                when().
                get(String.format(findByStatus + "%s", status)).
                then().
                spec(assertOKResponse());

    }
}
