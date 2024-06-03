package com.example.pr22;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@EnableScheduling
@AllArgsConstructor
@Slf4j
public class ScheduledService implements ScheduledMXBean{

    private final FootballerService footballerService;

    @PostConstruct
    private void init() throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.example.pr22:type=ScheduledService");
        if (!mbs.isRegistered(name)) {
            mbs.registerMBean(this, name);
        } else {
            log.info("MBean {} уже существует", name);
        }
    }


    @Scheduled(fixedRateString = "1800000")
    public void rewriteFiles() throws IOException {
        Files.walk(Path.of("src/main/resources/entities")).filter(Files::isRegularFile).forEach(file -> {
            try {
                Files.delete(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        FileWriter fileWriter = new FileWriter("src/main/resources/entities/footballers.txt");
        fileWriter.write(footballerService.getFootballers().toString());
        fileWriter.close();
    }
    @Override
    public void runRewrite() throws IOException {
        rewriteFiles();
    }
}
