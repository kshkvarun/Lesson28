package Lesson29_31.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class EmployeeResponseBody {

    @JsonProperty("status")
    String status;
    @JsonProperty("data")
    Employee data;
    @JsonProperty("message")
    String message;

    public EmployeeResponseBody(String status, Employee data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeResponseBody that = (EmployeeResponseBody) o;
        return Objects.equals(status, that.status) &&
                data.equals(that.data) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, data, message);
    }
}
