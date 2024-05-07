package io.amofoe.student.repository;

import io.amofoe.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllBySchoolId(long schoolId);

}
