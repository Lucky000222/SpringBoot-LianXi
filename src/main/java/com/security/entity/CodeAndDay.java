package com.security.entity;


import lombok.Data;

@Data
public class CodeAndDay {

    private Long id;
    private String code;

    private Integer day;

    private Integer meter;


    public CodeAndDay() {
    }

    public CodeAndDay(String code, Integer day, Integer meter) {
        this.code = code;
        this.day = day;
        this.meter = meter;

    }
}
