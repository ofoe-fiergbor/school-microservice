package io.amofoe.school.controller;

import io.amofoe.api.core.school.SchoolApi;
import io.amofoe.api.core.school.SchoolRequest;
import io.amofoe.api.core.school.SchoolResponse;
import io.amofoe.school.service.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
public class SchoolController implements SchoolApi {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @Override
    public ResponseEntity<SchoolResponse> create(SchoolRequest request) {
        return new ResponseEntity<>(schoolService.create(request), CREATED);
    }

    @Override
    public ResponseEntity<List<SchoolResponse>> getAll() {
        return ResponseEntity.ok(schoolService.getAll());
    }

    @Override
    public ResponseEntity<SchoolResponse> get(long id) {
        return ResponseEntity.ok(schoolService.get(id));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        schoolService.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
