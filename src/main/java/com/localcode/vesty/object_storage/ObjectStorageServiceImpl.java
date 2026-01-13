package com.localcode.vesty.object_storage;

import com.localcode.vesty.shared.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
@Service
@RequiredArgsConstructor
public class ObjectStorageServiceImpl implements ObjectStorageService {
    private final S3Client s3;
    private final ExecutorService s3UploadExecutor;

    @Value("${storage.s3.bucket}")
    private String bucket;

    private static final String PATH_SEPARATOR = "/";

    public byte[] download(ObjectDownloadRequest object) {
        try {
            String key = String.join(PATH_SEPARATOR, object.company(), object.name());

            GetObjectRequest req = GetObjectRequest.builder()
                    .bucket(bucket)
                    .key(key)
                    .build();

            return s3.getObjectAsBytes(req).asByteArray();
        } catch (Exception e) {
            log.warn("Houve um erro ao baixar o arquivo: {}", e.getMessage());
            throw new BusinessException("Houve um erro ao baixar o arquivo. Entre em contato com o administrador.");
        }
    }

    @Override
    public void upload(ObjectUploadRequest object) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (MultipartFile file : object.files()) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> uploadSingleFile(object.company(), file), s3UploadExecutor);
            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    }

    private void uploadSingleFile(String company, MultipartFile file) {
        try {
            final String SEPARATOR = "-";
            String originalName = Optional.ofNullable(file.getOriginalFilename()).orElse("file");
            String name = UUID.randomUUID() + SEPARATOR + originalName;

            String key = String.join(PATH_SEPARATOR, company, name);

            PutObjectRequest req = PutObjectRequest.builder()
                    .bucket(bucket)
                    .key(key)
                    .contentType(file.getContentType())
                    .build();

            s3.putObject(req, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
        } catch (Exception e) {
            log.error("Erro ao subir arquivo {}: {}", file.getOriginalFilename(), e.getMessage());
            throw new BusinessException("Erro ao enviar arquivo.");
        }
    }
}
