import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataDrivenTest extends DataProvider{

    @Test(dataProvider = "DataDriven")
    public void test_post(String firstName,String lastName, int subjectId){

        RestAssured.baseURI = "http://localhost:3000";

        JSONObject request = new JSONObject();
        request.put("firstName",firstName);
        request.put("lastName",lastName);
        request.put("subjectId",subjectId);
        RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .post("/users")
                .then()
                .statusCode(201)
                .log().all();
    }

    @Test(dataProvider = "deleteData")
    public void test_delete(int id){

        RestAssured.baseURI = "http://localhost:3000";
        RestAssured.given()
                .delete("/users/"+id)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    @Parameters({"id"})
    public void test_delete2(int id){

        RestAssured.baseURI = "http://localhost:3000";
        RestAssured.given()
                .delete("/users/"+id)
                .then()
                .statusCode(200)
                .log().all();
    }

}
