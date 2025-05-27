package com.naluri.circle_project.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class MainService {

    Integer scale = 0;

    @PostConstruct
    void init(){
        System.out.println("construct scale");
        scale = 0;
    }

    public BigDecimal getPhi() {
        BigDecimal twentyTwo = new BigDecimal("22");
        BigDecimal seven = new BigDecimal("7");
        BigDecimal pi = twentyTwo.divide(seven, scale, RoundingMode.DOWN);
        scale = scale + 1;
        return pi;
    }

    public BigDecimal circleCircumference(BigDecimal diameter, BigDecimal pi) {
        BigDecimal two = new BigDecimal(2); //2 * pi * r
        BigDecimal halfDiameter = diameter.divide(BigDecimal.TWO, 20, RoundingMode.DOWN); // because d = 2r
        BigDecimal result = two.multiply(pi).multiply(halfDiameter);
        return result.setScale(3, RoundingMode.DOWN);
    }

    public BigDecimal resetPi(){
        scale = 0;
        return BigDecimal.ZERO;
    }


}
