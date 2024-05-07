package io.amofoe.api.core.student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/students")
public interface StudentApi {

    @PostMapping
    ResponseEntity<StudentResponse> create(@RequestBody StudentRequest request);


    @GetMapping
    ResponseEntity<List<StudentResponse>> get(
            @RequestParam("schoolId") long schoolId
    );

    @DeleteMapping("/{schoolId}")
    ResponseEntity<Void> delete(@PathVariable long schoolId);
}
