package com.example.testround3.mapper;

import com.example.testround3.model.dto.commentsDto;
import com.example.testround3.model.entity.commentsEntity;
import com.example.testround3.model.in.commentsIn;

public class commentsMapper {
    public static commentsEntity mapIn(commentsIn commentsIn){
        commentsEntity commentsEntity = new commentsEntity();
        commentsEntity.setIdComments(commentsIn.getIdComments());
        commentsEntity.setName_Comments(commentsIn.getName_Comments());
        return commentsEntity;
    }

    public static commentsDto mapEntity (commentsEntity commentsEntity){
        commentsDto commentsDto = new commentsDto();
        commentsDto.setIdComments(commentsEntity.getIdComments());
        commentsDto.setName_Comments(commentsEntity.getName_Comments());

        if(commentsEntity.getPostEntity() == null){
            commentsDto.setIdPost(null);
            commentsDto.setNamePost(null);
        }else {
            commentsDto.setIdPost(commentsEntity.getPostEntity().getIdPost());
            commentsDto.setNamePost(commentsEntity.getPostEntity().getNamePost());
        }
        return commentsDto;
    }
}
