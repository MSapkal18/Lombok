package com.stream.services.impl;

import com.stream.entities.Video;
import com.stream.repositorises.VideoRepository;
import com.stream.services.VideoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Value("${files.video}")
    String DIR;

    private VideoRepository videoRepository;

    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @PostConstruct
    public void init()
    {
        File file=new File(DIR);
        if(!file.exists())
        {
            file.mkdir();
            System.out.println("Folder created");
        }
        else
        {
            System.out.println("Folder already created");
        }
    }

    @Override
    public Video save(Video video, MultipartFile file)
    {
        try {

            String filename = file.getOriginalFilename();
            String contentType = file.getContentType();
            InputStream inputStream = file.getInputStream();


            //  folder path : create

            String cleanFileName = StringUtils.cleanPath(filename);
            String cleanFolder= StringUtils.cleanPath(DIR);

            //  folder path with filename
            Path path =Paths.get(cleanFolder,cleanFileName);

            System.out.println(contentType);
            System.out.println(path);



            //  copy file to the folder
            Files.copy(inputStream,path, StandardCopyOption.REPLACE_EXISTING);

            //  video meta data
            video.setContentType(contentType);
            video.setFilePath(path.toString());

            //  save metadata
            return videoRepository.save(video);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Video getByTitle(String tittle) {
        return null;
    }
}
