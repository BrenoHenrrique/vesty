package com.localcode.vesty.object_storage;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record ObjectUploadRequest(String name, String company, List<MultipartFile> files) {
}
