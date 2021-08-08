package Intial;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestAll {

    @Test
    public void test_post(){
        JSONObject request = new JSONObject();
        request.put("name","morpheus");
        request.put("job","leader");
        System.out.println(request.toJSONString());
        RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201).log().all();
    }

    @Test
    public void test_put(){
        JSONObject request = new JSONObject();
        request.put("name","morpheus");
        request.put("job","zion resident");
        System.out.println(request.toJSONString());
        RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200).log().all();
    }

    @Test
    public void test_patch(){
        JSONObject request = new JSONObject();
        request.put("name","morpheus");
        request.put("job","zion resident");
        System.out.println(request.toJSONString());
        RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .patch("https://reqres.in/api/users/2")
                .then()
                .statusCode(200).log().all();
    }

    @Test
    public void test_delete(){
        RestAssured.given()
                .accept(ContentType.JSON)
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204).log().all();
    }
}
