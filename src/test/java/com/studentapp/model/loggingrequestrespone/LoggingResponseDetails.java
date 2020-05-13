package com.studentapp.model.loggingrequestrespone;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class LoggingResponseDetails extends TestBase {
    /**
     * This test will print out all the Response Headers
     */

    @Test
    public void test001() {
        System.out.println("---------------Printing Response Headers------------------");
        Response response = given()
                .when()
                .get("/1");
        response.then().statusCode(200)
                .log().headers();

    }


    /**
     * This test will print the Response Status Line
     */
    @Test
    public void test002() {
        System.out.println("---------------Printing Response Status Line------------------");
        Response response = given()
                .when()
                .get("/1");
        response.then().statusCode(200)
                .log().status();
    }


    /**
     * This test will print the Response Body
     */
    @Test
    public void test003() {
        System.out.println("---------------Printing Response Body------------------");
        Response response = given()
                .when()
                .get("/1");
        response.then().statusCode(200)
                .log().body();

    }

    /**
     * This test will print the Response in case of an error
     */
    @Test
    public void test004() {
        System.out.println("---------------Printing Response Body in case of an error------------------");
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Shradha");
        studentPojo.setLastName("Mehta");
        studentPojo.setEmail("egestas.rhoncus.Proin@massaQuisqueporttitor.org");
        studentPojo.setProgramme("Automation Testing");
        List<String> course = new ArrayList<>();
        course.add("Selenium");
        course.add("Java");
        course.add("Api Testing");
        studentPojo.setCourses(course);

        Response response =  given()
                .header("Content-Type","application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(500)
                .log().body();

    }
}


