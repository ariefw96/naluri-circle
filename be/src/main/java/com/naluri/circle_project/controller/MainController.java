package com.naluri.circle_project.controller;

import com.naluri.circle_project.dto.CircleRequestDto;
import com.naluri.circle_project.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("")
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/get-pi")
    @ResponseBody
    public ResponseEntity<Object> getPi() {
        Map<String, Object> response = new HashMap<>();
        BigDecimal pi = mainService.getPhi();
        response.put("pi", pi);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/calculate-circumference")
    @ResponseBody
    public ResponseEntity<Object> calculate(
            @RequestBody CircleRequestDto request
    ) {
        Map<String, Object> response = new HashMap<>();
        BigDecimal circumeference = mainService.circleCircumference(request.getDiameter(), request.getPi());
        response.put("circumference", circumeference.toString().concat(" KM"));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/reset")
    @ResponseBody
    public ResponseEntity<Object> resetPi() {
        Map<String, Object> response = new HashMap<>();
        response.put("pi", mainService.resetPi());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
