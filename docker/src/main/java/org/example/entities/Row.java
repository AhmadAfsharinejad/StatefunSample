package org.example.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Row {
    @JsonProperty("myValues")
    private final Object[] myValues;

    @JsonCreator
    public Row(@JsonProperty("myValues") Object[] myValues) {
        this.myValues = myValues;
    }
}
