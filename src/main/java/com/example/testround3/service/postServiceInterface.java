package com.example.testround3.service;

import com.example.testround3.model.bo.respon;
import com.example.testround3.model.bo.responPage;
import com.example.testround3.model.in.postIn;
import org.springframework.stereotype.Service;

@Service
public interface postServiceInterface {
    responPage getAll();
    respon create(postIn postIn);
    respon delete(Integer IdPost);
    respon update(Integer IdPost, postIn postIn);
}
