package Lesson30;

import Lesson30.Models.DeleteModel;
import Lesson30.Models.Employee;
import Lesson30.Models.EmployeeResponseBody;
import Lesson30.Models.PostEmployee;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

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
                .body("data.employee_age", hasItems("61"));

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
                .extract()
                .as(EmployeeResponseBody.class);
        assertEquals(responseBody, expectedResponse);

    }

    @Test
    public void postEmployee() {
        PostEmployee postEmployee = new PostEmployee("Kostya", "20000", "32");
        EmployeeResponseBody expectedResponse = new EmployeeResponseBody("success", new Employee(), "Successfully! Record has been updated.");
        EmployeeResponseBody responseBody = given()
                .with()
                .body(postEmployee)
                .post("/create")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(EmployeeResponseBody.class);
        assertEquals(responseBody, expectedResponse);
    }

    @Test
    public void putEmployeesList() {
        PostEmployee postEmployee = new PostEmployee("Kostya", "20000", "32");
        EmployeeResponseBody expectedResponse = new EmployeeResponseBody("success", new Employee(), "Successfully! Record has been updated.");
        EmployeeResponseBody responseBody = given()
                .with()
                .body(postEmployee)
                .put("/update/1")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(EmployeeResponseBody.class);
        assertEquals(responseBody, expectedResponse);
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
                .extract()
                .as(DeleteModel.class);
        assertEquals(deleteResponse, expectedResponse);
    }
}
