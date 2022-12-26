package com.example.testround3.service.imp;

import com.example.testround3.mapper.postMapper;
import com.example.testround3.model.bo.respon;
import com.example.testround3.model.bo.responPage;
import com.example.testround3.model.dto.postDto;
import com.example.testround3.model.entity.postEntity;
import com.example.testround3.model.in.postIn;
import com.example.testround3.responsitory.postResponsitory;
import com.example.testround3.service.postServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class postServiceImp implements postServiceInterface {
    @Autowired
    private postResponsitory postResponsitory;

    @Override
    @PostConstruct
    public responPage getAll(){
        List<postEntity> list=postResponsitory.findAll();
        List<postDto> listDto =list.stream().map(postMapper::mapEntity).collect(Collectors.toList());
        log.info(listDto.toString());
        return new responPage("message",listDto);
    }

    @Override
    public respon create(postIn postIn) {
        postEntity postEntity = postMapper.mapIn(postIn);
        postResponsitory.save(postEntity);
        return new respon(true,"create post success");
    }

    @Override
    public respon delete(Integer IdPost) {
        postEntity postEntity = postResponsitory.getById(IdPost);
        postResponsitory.delete(postEntity);
        return new respon(true,"delete post success");
    }

    @Override
    public respon update(Integer IdPost, postIn postIn) {
        postEntity postEntity = postResponsitory.getById(IdPost);
        postEntity.setNamePost(postIn.getNamePost());
        postEntity.setMotaPost(postIn.getMotaPost());
        postEntity.setIdPost(IdPost);
        postResponsitory.save(postEntity);
        return new respon(true,"update post success");
    }
}
