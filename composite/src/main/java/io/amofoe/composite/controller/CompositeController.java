package io.amofoe.composite.controller;

import io.amofoe.api.composite.CompositeApi;
import io.amofoe.api.composite.CompositeResponse;
import io.amofoe.composite.service.CompositeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompositeController implements CompositeApi {

    private final CompositeService compositeService;

    public CompositeController(CompositeService compositeService) {
        this.compositeService = compositeService;
    }

    @Override
    public ResponseEntity<CompositeResponse> getComposite(long schoolId) {
        return ResponseEntity.ok(compositeService.getCompositeResponse(schoolId));
    }
}
