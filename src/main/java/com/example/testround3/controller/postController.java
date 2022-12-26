package com.example.testround3.controller;

import com.example.testround3.model.in.postIn;
import com.example.testround3.service.postServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("apiPost")
@CrossOrigin("*")

public class postController {
    @Autowired
    private postServiceInterface postServiceInterface;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(postServiceInterface.getAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody postIn postIn) {
        return new ResponseEntity<>(postServiceInterface.create(postIn), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{IdPost}")
    public ResponseEntity<?> delete(@PathVariable Integer IdPost){
        return new ResponseEntity<>(postServiceInterface.delete(IdPost), HttpStatus.OK);
    }

    @PutMapping("/update/{IdPost}")
    public ResponseEntity<?> update(@PathVariable Integer IdPost, @RequestBody postIn postIn){
        return new ResponseEntity<>(postServiceInterface.update(IdPost, postIn),HttpStatus.OK);
    }
}