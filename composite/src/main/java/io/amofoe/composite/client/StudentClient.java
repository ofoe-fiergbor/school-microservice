package io.amofoe.composite.client;

import io.amofoe.api.core.student.StudentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "student-service", url = "${application.config.students-url}")
public interface StudentClient {

    @GetMapping("/students")
    List<StudentResponse> getStudents(
            @RequestParam("schoolId") long schoolId
    );
}
