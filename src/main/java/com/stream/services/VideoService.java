package com.stream.services;

import com.stream.entities.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VideoService {

    //save video
     Video save(Video video, MultipartFile file);

    // get video by tittle
    Video getByTitle(String title);

}
