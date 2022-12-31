package com.example.testround3.service.imp;

import com.example.testround3.mapper.commentsMapper;
import com.example.testround3.model.bo.respon;
import com.example.testround3.model.bo.responPage;
import com.example.testround3.model.dto.commentsDto;
import com.example.testround3.model.entity.TableEntity;
import com.example.testround3.model.entity.commentsEntity;
import com.example.testround3.model.entity.postEntity;
import com.example.testround3.model.in.commentsIn;
import com.example.testround3.responsitory.TableReponsitory;
import com.example.testround3.responsitory.commentsResponsitory;
import com.example.testround3.responsitory.postResponsitory;
import com.example.testround3.service.commentsServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class commentsServiceImp implements commentsServiceInterface, Runnable {
    private static final Integer GET_ALL_COMMENT = 1;

    @Autowired
    private commentsResponsitory commentsResponsitory;
    @Autowired
    private postResponsitory postResponsitory;
    @Autowired
    private TaskScheduler taskScheduler;
    @Autowired
    private TableReponsitory tableReponsitory;
    @Override
    public responPage getAll(String timeCronReq) {
        TableEntity entity = tableReponsitory.findById(GET_ALL_COMMENT).get();
        entity.setTimeCron(timeCronReq);
        tableReponsitory.save(entity);
//        List<commentsEntity> list = commentsResponsitory.findAll();
//        List<commentsDto> listDto = list.stream().map(commentsMapper::mapEntity).collect(Collectors.toList());
//        log.info(listDto.toString());
//        System.out.println(listDto+ "-----------------MINH------------------");
//        return new responPage("add complete",listDto);


        return null;
    }



    void callGetAll() {
//        TableEntity entity = tableReponsitory.findById(GET_ALL_COMMENT).get();
//        this.getAll(entity.getTimeCron());


        List<commentsEntity> list = commentsResponsitory.findAll();
        List<commentsDto> listDto = list.stream().map(commentsMapper::mapEntity).collect(Collectors.toList());
        log.info(listDto.toString());
        System.out.println(listDto+ "-----------------MINH------------------");
    }

    @Override
    public respon create(commentsIn commentsIn) {
        commentsEntity commentsEntity = commentsMapper.mapIn(commentsIn);
        postEntity postEntity = postResponsitory.getById(commentsIn.getIdPost());
        commentsEntity.setPostEntity(postEntity);
        commentsResponsitory.save(commentsEntity);
        return new respon(true, "create comments success");
    }

    @Override
    public respon delete(Integer IdComments) {
        commentsEntity commentsEntity = commentsResponsitory.getById(IdComments);
        commentsResponsitory.delete(commentsEntity);
        return new respon(true, "delete success comments");
    }

    @Override
    public respon update(Integer IdComments, commentsIn commentsIn) {
        commentsEntity commentsEntity = commentsResponsitory.getById(IdComments);
        postEntity postEntity = postResponsitory.getById(commentsIn.getIdPost());
        commentsEntity.setPostEntity(postEntity);
        commentsEntity.setName_Comments(commentsIn.getName_Comments());
        commentsResponsitory.save(commentsEntity);
        return new respon(true, "update comments success");
    }


    @Override
    public void run() {
        this.callGetAll();
    }
}