package org.example.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public final class Person {
    @JsonProperty("id")
    private final int id;
    @JsonProperty("name")
    private final String name;

    @JsonCreator
    public Person(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}
