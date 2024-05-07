package io.amofoe.composite.service;

import io.amofoe.api.composite.CompositeResponse;
import io.amofoe.api.core.school.SchoolResponse;
import io.amofoe.api.core.student.StudentResponse;
import io.amofoe.composite.client.SchoolClient;
import io.amofoe.composite.client.StudentClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompositeService {

    private final StudentClient studentClient;
    private final SchoolClient schoolClient;

    public CompositeService(StudentClient studentClient, SchoolClient schoolClient) {
        this.studentClient = studentClient;
        this.schoolClient = schoolClient;
    }

    public CompositeResponse getCompositeResponse(long schoolId) {
        SchoolResponse school = schoolClient.getSchool(schoolId);
        List<StudentResponse> students = studentClient.getStudents(schoolId);

        CompositeResponse response = new CompositeResponse(
                school.id(),
                school.name(),
                school.email()
        );
        response.setStudents(students);
        return response;
    }
}
