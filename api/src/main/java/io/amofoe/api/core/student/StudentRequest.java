package io.amofoe.api.core.student;

public record StudentRequest(
        String firstName,
        String lastName,
        String email,
        long schoolId
) {
}
