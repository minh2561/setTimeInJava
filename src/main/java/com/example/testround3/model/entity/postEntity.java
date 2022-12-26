package com.example.testround3.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "post")
public class postEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdPost;

    @Column
    private String namePost;

    @Column
    private String motaPost;

    @OneToMany(mappedBy = "postEntity", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Collection<commentsEntity> commentsEntities;

    @PreRemove
    private void preRemove() {
        commentsEntities.forEach(commentsEntity -> commentsEntity.setPostEntity(null));
    }
}
