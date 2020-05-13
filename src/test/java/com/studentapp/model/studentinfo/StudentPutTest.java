package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class StudentPutTest extends TestBase {
    @Test
    public void createNewStudent() {


        List<String> courses = new ArrayList<>();
        courses.add("Calculus");
        courses.add("Algorithms");
        courses.add("Software Development");
        courses.add("Ethics");


        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Chaitu");
        studentPojo.setLastName("Mehta");
        studentPojo.setEmail("ChaituMehta1234@gmail.com");
        studentPojo.setProgramme("Computer Science");
        studentPojo.setCourses(courses);

        given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .put("/4")
                .then()
                .statusCode(200);
        get("/list")
                .then()
                .body("[3].id", equalTo(4), "[3].firstName", equalTo("Chaitu"),
                        "[3].lastName", equalTo("Mehta"),
                        "[3].email", equalTo("ChaituMehta1234@gmail.com"));

    }
}