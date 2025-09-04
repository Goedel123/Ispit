package com.rad.ispit.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "File")
//@Table
@NoArgsConstructor
@Getter
@Setter
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer file_id;

    //@ManyToOne
    //@JoinColumn(name = "parent_id")
    @Column(nullable = false)
    private Integer parent;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date creation_time;

    @Column(nullable = false)
    private  String content;
}
