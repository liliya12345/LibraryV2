package org.libraryv2.service;

import lombok.RequiredArgsConstructor;
import org.libraryv2.model.Image;
import org.libraryv2.repository.ImageRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;
    public Image findImageById(long id){
        return imageRepository.findById(id).orElse(null);
    }
//    public Image findImageByBookId(long id){
//        return imageRepository.findImageByBookId(id);
//    }
}

