package ir.maktab.service.serviceImpl;

import ir.maktab.entitty.Person;
import ir.maktab.exception.DuplicateNationalCodeException;
import ir.maktab.repository.PersonRepository;
import ir.maktab.service.PersonService;

public class PersonServiceImpl implements PersonService {
    PersonRepository personRepository = new PersonRepository();

    @Override
    public void saveNewPerson(Person person) {
        personRepository.creat(person);
    }

    @Override
    public boolean checkNationalCode(String nationalCode) throws DuplicateNationalCodeException {
        return personRepository.checkNationalCode(nationalCode);
    }

    @Override
    public Person findByNationalCode(String nationalCode) {
        return personRepository.findByNationalCode(nationalCode);
    }

    @Override
    public void update(Person person) {
        personRepository.update(person);
    }

    @Override
    public void remove(Person person) {
        remove(person);
    }
}
