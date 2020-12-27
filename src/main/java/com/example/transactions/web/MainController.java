package com.example.transactions.web;

import com.example.transactions.service.MainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class MainController {
    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("sounds/count")
    public ResponseEntity<Integer> getSoundsCount() {
        Integer soundsCount = mainService.getSoundsCount();
        return new ResponseEntity<Integer>(soundsCount, HttpStatus.OK);
    }

    @GetMapping("sounds/add")
    public ResponseEntity<?> addSound() {
        mainService.addSound();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("sounds/delete/all")
    public ResponseEntity<?> deleteAll() {
        mainService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


