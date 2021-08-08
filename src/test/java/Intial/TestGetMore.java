package Intial;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestGetMore {

    @Test
    public void test01(){
        given()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("data.id", Matchers.equalTo(2))
                .body("data.first_name",Matchers.equalTo("Janet"))
                .log().all();
    }
}
