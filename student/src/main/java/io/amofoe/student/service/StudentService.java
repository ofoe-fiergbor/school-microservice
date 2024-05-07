package io.amofoe.student.service;

import io.amofoe.api.core.student.StudentRequest;
import io.amofoe.api.core.student.StudentResponse;
import io.amofoe.student.model.Student;
import io.amofoe.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponse create(StudentRequest student) {
        Student newStudent = new Student(
                student.firstName(),
                student.lastName(),
                student.email(),
                student.schoolId()
        );

        Student saved = studentRepository.save(newStudent);
        return new StudentResponse(
                saved.getId(),
                saved.getFirstName(),
                saved.getLastName(),
                saved.getEmail(),
                saved.getSchoolId()
        );
    }

    public List<StudentResponse> getStudentsBySchoolId(long id) {
        List<Student> students = studentRepository.findAllBySchoolId(id);
        return students
                .stream()
                .map(student -> new StudentResponse(
                        student.getId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getEmail(),
                        student.getSchoolId()
                )).toList();
    }

    public void deleteStudentsBySchoolId(long id) {
        List<Student> students = studentRepository.findAllBySchoolId(id);
        if (!students.isEmpty()) {
            studentRepository.deleteAll(students);
        }
    }
}
