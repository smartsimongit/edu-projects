package org.smart.simon.edu.app.service;

import jakarta.annotation.Nonnull;
import org.smart.simon.edu.app.model.PersonShortResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PersonService {

    @Nonnull
    List<PersonShortResponse> findAll();

//TODO    @Nonnull
//    PersonFullResponse getById(int id);
//
//TODO    int create(@Nonnull PersonRequest request);
//
//TODO    @Nonnull
//    PersonFullResponse update(int id, @Nonnull PersonRequest request);

    void delete(int id);

    void addPersonToDepartment(int departmentId, int personId);

    void removePersonFromDepartment(int departmentId, int personId);
}
