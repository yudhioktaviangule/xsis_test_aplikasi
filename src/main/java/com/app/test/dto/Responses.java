package com.app.test.dto;


import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Responses implements Serializable {
    private Integer response_code;
    private String message;
    private Object data;
}
