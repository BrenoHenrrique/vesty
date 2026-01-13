package com.localcode.vesty.object_storage;

import com.localcode.vesty.object_storage.dto.ObjectDeleteRequest;
import com.localcode.vesty.object_storage.dto.ObjectDownloadRequest;
import com.localcode.vesty.object_storage.dto.ObjectUploadRequest;

import java.util.List;

public interface ObjectStorageService {
    byte[] download(ObjectDownloadRequest object);

    List<String> upload(ObjectUploadRequest object);

    void remove(ObjectDeleteRequest object);
}
