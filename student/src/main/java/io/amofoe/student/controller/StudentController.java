package io.amofoe.student.controller;

import io.amofoe.api.core.student.StudentApi;
import io.amofoe.api.core.student.StudentRequest;
import io.amofoe.api.core.student.StudentResponse;
import io.amofoe.student.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
public class StudentController implements StudentApi {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public ResponseEntity<StudentResponse> create(StudentRequest request) {
        return new ResponseEntity<>(
                studentService.create(request), CREATED);
    }

    @Override
    public ResponseEntity<List<StudentResponse>> get(long schoolId) {
        return new ResponseEntity<>(
                studentService.getStudentsBySchoolId(schoolId), OK);
    }

    @Override
    public ResponseEntity<Void> delete(long schoolId) {
        studentService.deleteStudentsBySchoolId(schoolId);
        return new ResponseEntity<>(NO_CONTENT);
    }

}
