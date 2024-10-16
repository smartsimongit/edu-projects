package org.smart.simon.edu.app.service.impl;

import jakarta.annotation.Nonnull;
import org.smart.simon.edu.app.model.PersonShortResponse;
import org.smart.simon.edu.app.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class PersonServiceStubImpl implements PersonService {
    @Nonnull
    @Override
    public List<PersonShortResponse> findAll() {
        PersonShortResponse psr = new PersonShortResponse();
        psr.setId(Math.abs(new Random().nextInt()));
        psr.setFullName("John Doe");
        return Collections.singletonList(psr);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void addPersonToDepartment(int departmentId, int personId) {

    }

    @Override
    public void removePersonFromDepartment(int departmentId, int personId) {

    }
}
