package io.amofoe.composite.client;

import io.amofoe.api.core.school.SchoolResponse;
import io.amofoe.api.core.student.StudentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "school-service", url = "${application.config.school-url}")
public interface SchoolClient {

    @GetMapping("/schools/{schoolId}")
    SchoolResponse getSchool(@PathVariable("schoolId") long schoolId);
}
