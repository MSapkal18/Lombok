package com.stream.controller;


import com.stream.entities.Video;
import com.stream.playload.CustomMessage;
import com.stream.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/v1/videos")
public class VideoUploadController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/")
    public String frontPageLoad()
    {
        return "welcome";
    }
    @GetMapping("/uploadForm")
    public String openUpload()
    {
        return "upload";
    }

    @PostMapping
    public ResponseEntity<?> create(
            @RequestParam("file")MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam("description") String description
    ){
        Video video=new Video();
        video.setTittle(title);
        video.setDescription(description);
        video.setVideoId(UUID.randomUUID().toString());
        videoService.save(video,file);
        Video savedVideo=videoService.save(video,file);
        if(savedVideo!=null)
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(video);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(CustomMessage.builder()
                                    .message("Video not upload")
                                    .success(false)
                            .build()
                    );
        }
    }

}