package com.localcode.vesty.object_storage;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ObjectUploadRequest {
    private String name;
    private String company;
    private MultipartFile file;
}
