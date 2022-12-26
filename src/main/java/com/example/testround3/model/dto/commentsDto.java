package com.example.testround3.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class commentsDto {
    private Integer IdComments;
    private String name_Comments;
    private String namePost;
    private Integer IdPost;
    private String TimeCrone;
}
