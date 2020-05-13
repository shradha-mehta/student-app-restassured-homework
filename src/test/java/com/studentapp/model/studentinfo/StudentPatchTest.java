package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static com.studentapp.model.StudentPojo.getRandomString;
import static io.restassured.RestAssured.given;

public class StudentPatchTest extends TestBase {

    @Test
    public void updateStudentWithEmailOnly(){
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setEmail("smehta" + getRandomString(4) + "@gmail.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .patch("/2");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
