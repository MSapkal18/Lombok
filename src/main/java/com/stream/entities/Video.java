package com.stream.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "yt_videos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Video {
    @Id
    private String videoId;

    @Column
    private String tittle;

    @Column
    private String description;

    @Column
    private String contentType;

    @Column
    private String filePath;

}
