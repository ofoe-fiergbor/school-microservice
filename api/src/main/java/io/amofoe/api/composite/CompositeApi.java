package io.amofoe.api.composite;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/v1/composite")
public interface CompositeApi {

    @GetMapping
    ResponseEntity<CompositeResponse> getComposite(
            @RequestParam("schoolId") long schoolId
    );
}
