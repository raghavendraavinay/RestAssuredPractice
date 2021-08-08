import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class OwnApi {

    @Test
    public void test_get(){

        RestAssured.baseURI = "http://localhost:3000";
        RestAssured.given()
                .param("firstName","Raghav")
            .get("/users")
                .then()
                .statusCode(200)
                .body("firstName", Matchers.hasItem("Raghav"))
                .body("lastName",Matchers.hasItem("Vinay"))
                .log().all();
    }

    @Test
    public void test_post(){

        RestAssured.baseURI = "http://localhost:3000";

        JSONObject request = new JSONObject();
        request.put("firstName","Raghav4");
        request.put("lastName","Vinay4");
        RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                    .body(request.toJSONString())
                .post("/users")
                .then()
                .statusCode(201)
                .log().all();
    }

    @Test
    public void test_patch(){

        RestAssured.baseURI = "http://localhost:3000";

        JSONObject request = new JSONObject();
        request.put("firstName","Raghav41");
        request.put("lastName","Vinay4");
        RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .patch("/users/4")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void test_put(){

        RestAssured.baseURI = "http://localhost:3000";

        JSONObject request = new JSONObject();
        request.put("firstName","Raghav4");
        request.put("lastName","Vinay4");
        RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .put("/users/4")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void test_delete(){

        RestAssured.baseURI = "http://localhost:3000";
        RestAssured.given()
                .delete("/users/4")
                .then()
                .statusCode(200)
                .log().all();
    }
}
