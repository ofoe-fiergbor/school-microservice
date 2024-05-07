package io.amofoe.school.service;

import io.amofoe.api.core.school.SchoolRequest;
import io.amofoe.api.core.school.SchoolResponse;
import io.amofoe.api.exception.NotFoundException;
import io.amofoe.school.model.School;
import io.amofoe.school.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public SchoolResponse create(SchoolRequest schoolRequest) {
        School school = new School(
                schoolRequest.name(),
                schoolRequest.email());
        School savedSchool = schoolRepository.save(school);
        return new SchoolResponse(
                savedSchool.getId(),
                savedSchool.getName(),
                savedSchool.getEmail()
        );
    }

    public SchoolResponse get(long id) {
        School foundSchool = schoolRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("School not found"));

        return new SchoolResponse(
                foundSchool.getId(),
                foundSchool.getName(),
                foundSchool.getEmail()
        );
    }

    public List<SchoolResponse> getAll() {
        List<School> foundSchools = schoolRepository.findAll();
        return foundSchools
                .stream()
                .map(school -> new SchoolResponse(
                        school.getId(),
                        school.getName(),
                        school.getEmail()
                )).toList();
    }

    public void delete(long id) {
        schoolRepository.deleteById(id);
    }
}
