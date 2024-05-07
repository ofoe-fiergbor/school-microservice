package io.amofoe.api.core.student;

public record StudentResponse(
        long id,
        String firstName,
        String lastName,
        String email,
        long schoolId
) {
}
