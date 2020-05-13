package com.studentapp.model.studentinfo;

import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentDeleteTest extends TestBase {

    @Test
    public void deleteStudentById() {
        Response response = given()
                .when()
                .delete("/1");
        response.then().statusCode(204);
        response.prettyPrint();

    }
}
