package com.example.testround3.model.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class commentsIn {
    private Integer IdComments;
    private String name_Comments;
    private Integer idPost;
    private String timeCrone;
}
