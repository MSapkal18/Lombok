package com.stream.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "yt_course")
@Getter
@Setter
public class Course
{
    @Id
    private String id;

    private String tittle;

    //@OneToMany(mappedBy = "course")
    //private List<Video> list=new ArrayList<>();
}
