package com.example.diplomaprojectbackend.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public interface AzureBlobService {
    CompletableFuture<String> uploadPhoto(MultipartFile file) throws IOException;
    CompletableFuture<Void> deletePhoto(String imageUrl);
}