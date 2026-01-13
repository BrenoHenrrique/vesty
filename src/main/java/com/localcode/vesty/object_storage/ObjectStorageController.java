package com.localcode.vesty.object_storage;

import com.localcode.vesty.object_storage.dto.ObjectDeleteRequest;
import com.localcode.vesty.object_storage.dto.ObjectDownloadRequest;
import com.localcode.vesty.object_storage.dto.ObjectUploadRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<String>> upload(ObjectUploadRequest object) {
        List<String> names = storage.upload(object);
        return ResponseEntity.ok(names);
    }

    @DeleteMapping
    public ResponseEntity<Void> remove(@RequestParam ObjectDeleteRequest object) {
        storage.remove(object);
        return ResponseEntity.ok().build();
    }
}
