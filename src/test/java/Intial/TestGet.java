package Intial;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestGet {

    @Test
    public void test01(){

        Response response = given().get("https://reqres.in/api/users?page=2");
        System.out.println("Body : "+response.getBody().asPrettyString());
        System.out.println("Status Code : "+response.statusCode());

        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void test02(){
        given()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .body("data.id[0]", Matchers.equalTo(7))
                .statusCode(200);
    }

}
