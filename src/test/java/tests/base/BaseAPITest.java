package tests.base;

import drivers.config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseAPITest {

    protected String baseURL = ConfigReader.getProperty("api.baseUrl");
    protected static String petEndpoint = "/pet";
    protected static String storeEndpoint = "/store";
    protected static String userEndpoint = "/user";
    protected static RequestSpecification reqSpec;
    protected static ResponseSpecification respSpec;

    @BeforeSuite
    public void setUpRestClient(){
        reqSpec = new RequestSpecBuilder().
                addHeader("accept", "application/json").
                setBaseUri(baseURL).
                build();
    }

    public ResponseSpecification assertOKResponse() {
        return respSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }

    public ResponseSpecification assertInvalidInputResponse() {
        return respSpec = new ResponseSpecBuilder().
                expectStatusCode(401).
                expectStatusLine("Invalid Input").
                build();
    }

    public ResponseSpecification assertNotFoundResponse(){
        return respSpec = new ResponseSpecBuilder().
                expectStatusCode(404).
                build();
    }

    public ResponseSpecification assertValidationErrorResponse(){
        return respSpec = new ResponseSpecBuilder().
                expectStatusCode(405).
                build();
    }

    public void assertBadRequestResponse(){
        respSpec = new ResponseSpecBuilder().
                expectStatusCode(400).
                build();
    }

}
