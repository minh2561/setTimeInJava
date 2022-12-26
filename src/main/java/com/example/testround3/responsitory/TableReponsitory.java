package com.example.testround3.responsitory;

import com.example.testround3.model.entity.TableEntity;
import com.example.testround3.model.entity.commentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableReponsitory extends JpaRepository <TableEntity, Integer>{

}
