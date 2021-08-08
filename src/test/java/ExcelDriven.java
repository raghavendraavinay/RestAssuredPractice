import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExcelDriven {
    private ExcelUtil excelUtil;

    @DataProvider(name = "ExcelData")
    public Object[][] readData() throws IOException {
        excelUtil = new ExcelUtil();
        int rowCnt = excelUtil.readRowCnt();
        int colCnt = excelUtil.readColCnt();
        Object[][] data = new Object[2][3];
        for (int i=1;i<rowCnt;i++){
            for (int j=0;j<colCnt;j++){
                System.out.println("Data: "+excelUtil.readData(i,j));
                data[i-1][j] = excelUtil.readData(i,j);
            }
        }
        return data;
    }

    @Test(dataProvider = "ExcelData")
    public void test_post(String firstName, String lastName, String subjectId){
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
}
