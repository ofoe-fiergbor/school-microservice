package io.amofoe.api.core.school;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/schools")
public interface SchoolApi {

    @PostMapping
    ResponseEntity<SchoolResponse> create(@RequestBody SchoolRequest request);

    @GetMapping
    ResponseEntity<List<SchoolResponse>> getAll();

    @GetMapping("/{id}")
    ResponseEntity<SchoolResponse> get(@PathVariable long id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable long id);
}
