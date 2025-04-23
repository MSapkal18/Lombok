package com.stream.services.impl;

import com.stream.entities.Video;
import com.stream.services.VideoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Value("${files.video}")
    String DIR;


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

            Path path =Paths.get(cleanFolder,cleanFileName);

            System.out.println(contentType);
            System.out.println(path);



            //  folder path with filename
            //  copy file to the folder
            //  video meta data
            //  save metadata
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Video getByTitle(String tittle) {
        return null;
    }
}
