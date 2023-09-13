package com.app.test.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FilmRequest implements Serializable {
    private String title;
    private String description;
    private Float rating;
    private String image;
    private Long id;
}
