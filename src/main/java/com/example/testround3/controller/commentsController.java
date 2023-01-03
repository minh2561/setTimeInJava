package com.example.testround3.controller;

import com.example.testround3.model.in.DateIn;
import com.example.testround3.model.in.commentsIn;
import com.example.testround3.service.commentsServiceInterface;
import com.example.testround3.service.cronJob.ScheduledTasks;
import com.example.testround3.service.imp.commentsServiceImp;
import com.sun.istack.NotNull;
import lombok.Data;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ScheduledFuture;

//@Data
@Controller
@RequestMapping("apiComments")
@CrossOrigin("*")
public class commentsController extends ScheduledTasks {

    @Autowired
    private ScheduledTasks scheduledTasks;

//    ScheduledTasks scheduledTasks = new ScheduledTasks();


    @Autowired
    private commentsServiceImp commentsServiceInterface;
    private commentsServiceImp commentsServiceImp;


//  set time
    @PostMapping
    public ResponseEntity<?>getAll(@RequestBody commentsIn commentsIn){
        commentsServiceInterface.getAll(commentsIn.getTimeCrone());
//        scheduledTasks.stopTask();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


//    start
    @PostMapping("/get")
    public ResponseEntity<?>callGetAll(){
        scheduledTasks.scheduleTasks();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    stop
    @PostMapping("/del")
    public ResponseEntity<?>callDelAll(){
        scheduledTasks.stopTask();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }





    @PostMapping("/allTime")
    public ResponseEntity<?>getAllTime(@RequestBody DateIn dateIn){
        commentsServiceInterface.getAllTime(dateIn);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }





    @DeleteMapping("/delete/{IdComments}")
    public ResponseEntity<?>delete(@PathVariable Integer IdComments){
        return new ResponseEntity<>(commentsServiceInterface.delete(IdComments),HttpStatus.OK);
    }

    @PutMapping("/update/{IdComments}")
    public ResponseEntity<?>update(@PathVariable Integer IdComments, @RequestBody commentsIn commentsIn){
        return new ResponseEntity<>(commentsServiceInterface.update(IdComments, commentsIn),HttpStatus.OK);
    }
}
