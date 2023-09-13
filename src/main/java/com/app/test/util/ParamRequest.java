package com.app.test.util;

import com.app.test.exceptions.CustomExceptions;
import org.springframework.http.HttpStatus;

public class ParamRequest {
    public static void check(String paramName,String param){
        if(param==null){
            throw new CustomExceptions(String.format("%s is empty",paramName),null, HttpStatus.BAD_REQUEST);
        }
    }

    public static void check(String paramName,Float param){
        if(param==null || param < 0 ){
            throw new CustomExceptions(String.format("%s cannot null or must g5reater than 0",paramName),null, HttpStatus.BAD_REQUEST);
        }
    }
}
