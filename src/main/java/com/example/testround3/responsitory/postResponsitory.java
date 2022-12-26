package com.example.testround3.responsitory;

import com.example.testround3.model.entity.postEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface postResponsitory extends JpaRepository<postEntity, Integer> {
    postEntity getById(Integer IdPost);
}
