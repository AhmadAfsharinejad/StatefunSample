package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
public class EmbeddedDto {
    private final String id;
    private final String content;

    @JsonCreator
    public EmbeddedDto(@JsonProperty("id") String id, @JsonProperty("content") String content) {
        this.id = id;
        this.content = content;
    }
}
