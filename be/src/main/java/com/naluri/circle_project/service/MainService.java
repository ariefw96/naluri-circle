package com.naluri.circle_project.service;

import com.naluri.circle_project.constant.MainConstant;
import com.naluri.circle_project.entity.MainEntity;
import com.naluri.circle_project.repo.MainRepo;
import com.sun.tools.javac.Main;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class MainService {

    @Autowired
    private MainRepo mainRepo;


    @PostConstruct
    void init() {
        System.out.println("construct scale");

        mainRepo.findByKey(MainConstant.SCALE)
                .orElseGet(() -> {
                    MainEntity scale = new MainEntity();
                    scale.setId(UUID.randomUUID());
                    scale.setKey(MainConstant.SCALE);
                    scale.setValue("0");
                    return mainRepo.save(scale);
                });
    }


    public BigDecimal getPhi() {
        BigDecimal twentyTwo = new BigDecimal("22");
        BigDecimal seven = new BigDecimal("7");
        AtomicReference<BigDecimal> pi = new AtomicReference<>(BigDecimal.ZERO);
        mainRepo.findByKey(MainConstant.SCALE)
                .ifPresentOrElse(
                    scl -> {
                        pi.set(twentyTwo.divide(seven, Integer.parseInt(scl.getValue()), RoundingMode.DOWN));
                        scl.setValue(
                                String.valueOf((Integer.parseInt(scl.getValue()) + 1))
                        );
                        mainRepo.save(scl);
                    }, () -> {

                        }
                );

        mainRepo.findByKey(MainConstant.PI)
                .ifPresentOrElse(
                        p -> {
                            p.setValue(String.valueOf(pi.get()));
                            mainRepo.save(p);
                        }, () -> {
                            MainEntity newPi = new MainEntity();
                            newPi.setId(UUID.randomUUID());
                            newPi.setKey(MainConstant.PI);
                            newPi.setValue(String.valueOf(pi.get()));
                            mainRepo.save(newPi);
                        }
                );

        return pi.get();
    }

    public BigDecimal circleCircumference(BigDecimal diameter, BigDecimal pi) {
        BigDecimal two = new BigDecimal(2); //2 * pi * r
        BigDecimal halfDiameter = diameter.divide(BigDecimal.TWO, 20, RoundingMode.DOWN); // because d = 2r
        BigDecimal result = two.multiply(pi).multiply(halfDiameter);
        return result.setScale(6, RoundingMode.DOWN).stripTrailingZeros();
    }

    public BigDecimal resetPi(){
        mainRepo.findByKey(MainConstant.PI)
                .ifPresent(p -> {
                    p.setValue("0");
                    mainRepo.save(p);
                });

        mainRepo.findByKey(MainConstant.SCALE)
                .ifPresent(s -> {
                    s.setValue("0");
                    mainRepo.save(s);
                });

        return BigDecimal.ZERO;

    }


}
