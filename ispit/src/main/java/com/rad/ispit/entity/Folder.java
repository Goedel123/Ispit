package com.rad.ispit.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "Folder")
//@Table
@NoArgsConstructor
@Getter
@Setter
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer folder_id;

    //@ManyToOne
    //@JoinColumn(name = "parent_id")
    @Column(nullable = false)
    private Integer parent;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date creation_time;
}
