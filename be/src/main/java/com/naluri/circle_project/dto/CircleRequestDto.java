package com.naluri.circle_project.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CircleRequestDto {

    private BigDecimal pi;
    private BigDecimal diameter;

}
