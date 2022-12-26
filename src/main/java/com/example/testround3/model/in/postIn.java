package com.example.testround3.model.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class postIn {
    private Integer IdPost;
    private String namePost;
    private String motaPost;
    private String date;
}
