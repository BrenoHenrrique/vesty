package com.localcode.vesty.object_storage.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record ObjectUploadRequest(String company, List<MultipartFile> files) {
}
