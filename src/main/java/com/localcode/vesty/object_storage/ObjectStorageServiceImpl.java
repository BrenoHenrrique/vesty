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

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ObjectStorageServiceImpl implements ObjectStorageService {
    private final S3Client s3;

    @Value("${storage.s3.bucket}")
    private String bucket;

    private static final String PATH_SEPARATOR = "/";

    public byte[] download(ObjectDownloadRequest object) {
        try {
            String key = String.join(PATH_SEPARATOR, object.getCompany(), object.getName());

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

    public void upload(ObjectUploadRequest object) {
        try {
            final String SEPARATOR = "-";
            MultipartFile file = object.getFile();
            String originalName = Optional.ofNullable(file.getOriginalFilename()).orElse("file");
            String name = UUID.randomUUID() + SEPARATOR + originalName;

            String key = String.join(
                    PATH_SEPARATOR,
                    object.getCompany(),
                    name
            );

            PutObjectRequest req = PutObjectRequest.builder()
                    .bucket(bucket)
                    .key(key)
                    .contentType(file.getContentType())
                    .build();
            s3.putObject(req, RequestBody.fromBytes(file.getBytes()));
        } catch (IOException e) {
            log.warn("Houve um erro ao enviar o arquivo: {}", e.getMessage());
            throw new BusinessException("Houve um erro ao enviar o arquivo, entre em contato com o administrador.");
        }
    }
}
