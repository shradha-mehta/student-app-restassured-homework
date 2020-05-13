package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.studentapp.model.StudentPojo.getRandomString;
import static io.restassured.RestAssured.given;

public class StudentPostTest extends TestBase {

    @Test
    public void createNewStudent() {

        List<String> course = new ArrayList<>();
        course.add("Selenium");
        course.add("Java");
        course.add("Api Testing");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Shradha");
        studentPojo.setLastName("Testing");
       studentPojo.setEmail("testing"+getRandomString(5)+"@test.com");
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCourses(course);


        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();


    }
    @Test
    public void createNewStudentWithNullFirstName() {

        List<String> course = new ArrayList<>();


        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("");
        studentPojo.setLastName("Mehta");
        studentPojo.setEmail("smaheta"+getRandomString(4)+"@gmail.com");
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCourses(course);

        course.add("Selenium");
        course.add("Java");
        course.add("Api Testing");

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();


    }
    @Test
    public void createNewStudentWithEmptyLastName() {

        List<String> course = new ArrayList<>();


        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Shradha");
        studentPojo.setLastName("");
        studentPojo.setEmail("smaheta"+getRandomString(4)+"@gmail.com");
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCourses(course);

        course.add("Selenium");
        course.add("Java");
        course.add("Api Testing");

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();


    }
    @Test
    public void createNewStudentWithDupeEmail() {

        List<String> course = new ArrayList<>();


        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Shradha");
        studentPojo.setLastName("Mehta");
        studentPojo.setEmail("non.ante.bibendum@risusDonecegestas.edu");
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCourses(course);

        course.add("Selenium");
        course.add("Java");
        course.add("Api Testing");

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(500);
        response.prettyPrint();


    }
}
