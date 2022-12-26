package com.example.testround3.mapper;

import com.example.testround3.model.dto.postDto;
import com.example.testround3.model.entity.postEntity;
import com.example.testround3.model.in.postIn;

public class postMapper {
    public static postEntity mapIn(postIn postIn){
        postEntity postEntity = new postEntity();
        postEntity.setIdPost(postIn.getIdPost());
        postEntity.setNamePost(postIn.getNamePost());
        postEntity.setMotaPost(postIn.getMotaPost());
        return postEntity;
    }

    public static postDto mapEntity(postEntity postEntity){
        postDto postDto = new postDto();
        postDto.setIdPost(postEntity.getIdPost());
        postDto.setMotaPost(postEntity.getMotaPost());
        postDto.setNamePost(postEntity.getNamePost());
        return postDto;
    }
}
