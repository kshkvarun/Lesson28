package Lesson29_31;

import Lesson29_31.Listener.Listener;
import Lesson29_31.Models.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

@Listeners(Listener.class)
public class RestTest {


    @BeforeClass
    public void beforeCLass() {
        baseURI = "http://dummy.restapiexample.com/api/v1";
    }

    @Test
    public void getEmployeesList() {
        given()
                .when()
                .get("/employees")
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("status", equalTo("success"))
                .body("data.employee_age", hasItems("61"))
                .body("data.employee_salary", hasItems("320800"))
                .body(hasXPath("data/profile_image", containsString("")));

    }

    @Test
    public void getWrongEndPoint() {
        given()
                .when()
                .get("/employeess")
                .then()
                .log().all()
                .statusCode(404)
                .body("message", containsString("Error Occured! Page Not found, contact rstapi2example@gmail.com"));
    }

    @Test
    public void getEmployeeByID() {
        Employee expectedEmployee = new Employee("Tiger Nixon", 320800, 61, "");
        EmployeeResponseBody expectedResponse = new EmployeeResponseBody("success", expectedEmployee, "Successfully! Record has been fetched.");
        EmployeeResponseBody responseBody = given()
                .when()
                .get("/employee/1")
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("status", equalTo("success"))
                .body("data.id", equalTo(1))
                .body("data.employee_name", containsString("Tiger"))
                .body("data.employee_salary", equalTo(320800))
                .body("data.employee_age", equalTo(61))
                .body("data.profile_image", equalTo(""))
                .body("message", containsString("Successfully! Record has been fetched."))
                .extract()
                .as(EmployeeResponseBody.class);
        assertEquals(responseBody, expectedResponse);
    }

    @Test
    public void getNonExistingEmployeeByID() {
        GetNonExistingEmployee expectedResponse = new GetNonExistingEmployee("success", null, "Successfully! Record has been fetched.");
        GetNonExistingEmployee responseBody = given()
                .when()
                .get("/employee/121212")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(GetNonExistingEmployee.class);
        assertEquals(responseBody, expectedResponse);
    }

    @Test
    public void postEmployee() {
        PostEmployee postEmployee = new PostEmployee("Kostya", "20000", "32");
        EmployeeResponseBody expectedResponse = new EmployeeResponseBody("success", new Employee(), "Successfully! Record has been added.");
        EmployeeResponseBody responseBody = given()
                .with()
                .body(postEmployee)
                .post("/create")
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("status", equalTo("success"))
                .body("data.id", instanceOf(Integer.class))
                .body("message", equalTo("Successfully! Record has been added."))
                .extract()
                .as(EmployeeResponseBody.class);
        assertEquals(responseBody, expectedResponse);
    }

    @Test
    public void postEmployeeToWrongEndPoint() {
        PostEmployee postEmployee = new PostEmployee("Kostya", "20000", "32");
        given()
                .with()
                .body(postEmployee)
                .post("/createe")
                .then()
                .log().all()
                .statusCode(405);
    }

    @Test
    public void putEmployeesList() {
        PostEmployee postEmployee = new PostEmployee("Kostya", "20000", "32");
        PutEmployeeResponse expectedResponse = new PutEmployeeResponse("success", new ArrayList<>(), "Successfully! Record has been updated.");
        PutEmployeeResponse responseBody = given()
                .with()
                .body(postEmployee)
                .put("/update/1")
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("status", equalTo("success"))
                .body("message", equalTo("Successfully! Record has been updated."))
                .body("data", equalTo(new ArrayList<>()))
                .extract()
                .as(PutEmployeeResponse.class);
        assertEquals(responseBody, expectedResponse);
    }

    @Test
    public void putEmployeesToWrongEndpoint() {
        PostEmployee postEmployee = new PostEmployee("Kostya", "20000", "32");
        given()
                .with()
                .body(postEmployee)
                .put("/updatee/1")
                .then()
                .log().all()
                .statusCode(405);

    }

    @Test
    public void deleteEmployeesList() {
        DeleteModel expectedResponse = new DeleteModel("success", 1, "Successfully! Record has been deleted");
        DeleteModel deleteResponse = given()
                .when()
                .delete("/delete/1")
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("status", equalTo("success"))
                .body("message", equalTo("Successfully! Record has been deleted"))
                .body("data", equalTo("1"))
                .extract()
                .as(DeleteModel.class);
        assertEquals(deleteResponse, expectedResponse);
    }

    @Test
    public void deleteEmployeesFromWrongEndPoint() {
        given()
                .when()
                .delete("/delete/1")
                .then()
                .log().all()
                .statusCode(200);
    }
}
