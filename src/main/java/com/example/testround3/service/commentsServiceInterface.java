package com.example.testround3.service;

import com.example.testround3.model.bo.respon;
import com.example.testround3.model.bo.responPage;
import com.example.testround3.model.in.commentsIn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface commentsServiceInterface {
    responPage getAll(String timeCronReq);
    respon create(commentsIn commentsIn);
    respon delete (Integer IdComments);
    respon update(Integer IdComments, commentsIn commentsIn);
}
