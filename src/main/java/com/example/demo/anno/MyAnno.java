package com.example.demo.anno;

import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR,ElementType.PARAMETER,ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    String value();
}
