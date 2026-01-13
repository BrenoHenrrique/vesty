package com.localcode.vesty.shared.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class AsyncConfig {

    @Bean(name = "s3UploadExecutor")
    public ExecutorService s3UploadExecutor() {
        return Executors.newFixedThreadPool(4);
    }
}
