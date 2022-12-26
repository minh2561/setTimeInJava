package com.example.testround3.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="comments")
public class commentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdComments;

    @Column
    private String name_Comments;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="IdPost")
    private postEntity postEntity;
}
