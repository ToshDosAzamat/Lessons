package com.example.authorizationserverservicespringboot.dto;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ExceptionMesssge {
    private Date date;
    private String message;
}
