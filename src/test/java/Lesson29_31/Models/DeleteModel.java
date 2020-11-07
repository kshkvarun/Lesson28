package Lesson29_31.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class DeleteModel {

    @JsonProperty("status")
    String status;
    @JsonProperty("data")
    Integer data;
    @JsonProperty("message")
    String message;


    public DeleteModel(String status, Integer data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteModel that = (DeleteModel) o;
        return Objects.equals(status, that.status) &&
                Objects.equals(data, that.data) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, data, message);
    }
}
