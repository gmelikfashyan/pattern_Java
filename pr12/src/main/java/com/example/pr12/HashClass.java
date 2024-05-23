package com.example.pr12;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class HashClass {
    private String firstFilePath = "C:\\Users\\gmeli\\IdeaProjects\\pr12\\first.txt";
    private String secondFilePath = "C:\\Users\\gmeli\\IdeaProjects\\pr12\\second.txt";

    @PostConstruct
    public void hashFile() {
        try {
            File firstFile = new File(firstFilePath);
            if (firstFile.exists()) {
                byte[] firstData = Files.readAllBytes(Paths.get(firstFilePath));
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hashedData = digest.digest(firstData);
                Files.write(Paths.get(secondFilePath), hashedData);
            } else {
                Files.write(Paths.get(secondFilePath), "null".getBytes());
            }
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void deleteFirstFile() {
        File file = new File(firstFilePath);
        if (file.exists()) {
            file.delete();
        }
    }
}
