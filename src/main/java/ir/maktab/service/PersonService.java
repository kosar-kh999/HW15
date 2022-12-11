package ir.maktab.service;

import ir.maktab.entitty.Person;
import ir.maktab.exception.DuplicateNationalCodeException;

public interface PersonService {
    void saveNewPerson(Person person);

    boolean checkNationalCode(String nationalCode) throws DuplicateNationalCodeException;

    Person findByNationalCode(String nationalCode);

    void update(Person person);

    void remove(Person person);
}
