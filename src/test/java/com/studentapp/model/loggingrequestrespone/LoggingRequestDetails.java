package com.studentapp.model.loggingrequestrespone;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class LoggingRequestDetails extends TestBase {
    //This test will print out all the request headers

    @Test
    public void test001(){

        System.out.println("---------------Printing Request Headers------------------");
        given()
                .log()
                .headers()
                .when()
                .get("/1")
                .then()
                .statusCode(200);
    }


    // This test will print out all the request Parameters

    @Test
    public void test002(){
        System.out.println("---------------Printing Request Parameters------------------");
        given()
                .param("programme", "Computer Science")
                .param("limit", 2)
                .log()
                .parameters()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }


    // This test will print out the Request body

    @Test
    public void test003(){
        System.out.println("---------------Printing Request Body------------------");
        List<String> course = new ArrayList<>();
        course.add("Selenium");
        course.add("Java");
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Shradha");
        studentPojo.setLastName("Mehta");
        studentPojo.setEmail("jiya@gmail.com");
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCourses(course);

        Response response = given()

                .header("Content-Type","application/json") //     .contentType("application/json")
                .log()
                .body()
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);


    }


    // This test will print out All the details

    @Test
    public void test004(){

        System.out.println("---------------Printing All the Request Details------------------");
        Response response = given()
                .log().all()
                .param("programme","Financial Analysis")
                .param("limit",4)
                .when()
                .get("/list");
        response.then().statusCode(200);



    }



    // This test will print Request details if validation fails

    @Test
    public void test005(){
        System.out.println("---------------Printing All the Request Details if validation fails------------------");
        Response response = given()
                .log().ifValidationFails()
                .param("programme", "Financial Analysis")
                .param("limit", 2)
                .when()
                .get("/list");
        response.then().statusCode(201);



    }

}


