package com.localcode.vesty.object_storage;

public interface ObjectStorageService {
    byte[] download(ObjectDownloadRequest object);

    void upload(ObjectUploadRequest object);
}
