package com.localcode.vesty.object_storage;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/objects")
public class ObjectStorageController {
    private final ObjectStorageService storage;

    @GetMapping(produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> download(@RequestParam ObjectDownloadRequest object) {
        byte[] bytes = storage.download(object);
        return ResponseEntity.ok(bytes);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> upload(ObjectUploadRequest object) {
        storage.upload(object);
        return ResponseEntity.ok().build();
    }
}
