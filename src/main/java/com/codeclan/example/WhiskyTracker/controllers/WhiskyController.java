package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(
            @RequestParam(name = "year", required = false) Integer year){
        if(year != null){
            return new ResponseEntity<>(whiskyRepository.findByYear(year),HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/distilleryAndAge")
    public ResponseEntity<List<Whisky>> findByDistilleryAndAge(
            @RequestParam(name = "distilleryId", required = false) Long distilleryId,
            @RequestParam(name = "age", required = false) Integer age){
        if(distilleryId != null && age != null){
            return new ResponseEntity<>(whiskyRepository.findByDistilleryIdAndAge(distilleryId, age),HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/distilleryAndRegion")
    public ResponseEntity<List<Whisky>> findByDistilleryRegion(
            @RequestParam(name = "distillery", required = false) String distillery){
        if (distillery != null){
            return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(distillery), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }









}
