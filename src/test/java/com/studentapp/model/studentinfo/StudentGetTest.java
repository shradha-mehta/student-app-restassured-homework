package com.studentapp.model.studentinfo;

import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class StudentGetTest extends TestBase {

        @Test
        public void getAllStudentsDetails() {
            Response response = given()
                    .when()
                    .get("/list");
            response.then().statusCode(200);
            response.prettyPrint();
        }

            @Test
            public void searchStudentById(){
                Response respone =given()
                        .when()
                        .get("85");
                respone.then().statusCode(200);
                respone.prettyPrint();

            }
            @Test
    public void searchStudentByProgramme(){
            Response response = given()
                    .param("programme","Financial Analysis")
                    .when()
                    .get("/list");
            response.then().statusCode(200);
            response.prettyPrint();
            }
            @Test
    public void searchStudentByProgrammeAndLimit(){
            Response response =given()
                    .param("programme","Financial Analysis")
                    .param("limit",4)
                    .when()
                    .get("/list");
            response.then().statusCode(200);
            response.prettyPrint();
            }
            
            
        }


