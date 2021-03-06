package Lesson29_31.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Objects;

public class PutEmployeeResponse {



    @JsonProperty("status")
    String status;
    @JsonProperty("data")
    ArrayList<String> data;
    @JsonProperty("message")
    String message;

    public PutEmployeeResponse(String status, ArrayList<String> data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PutEmployeeResponse that = (PutEmployeeResponse) o;
        return Objects.equals(status, that.status) &&
                Objects.equals(data, that.data) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, data, message);
    }
}
