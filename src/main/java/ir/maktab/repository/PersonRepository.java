package ir.maktab.repository;

import ir.maktab.entitty.Person;
import ir.maktab.exception.DuplicateNationalCodeException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PersonRepository {
    public void creat(Person person) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public boolean checkNationalCode(String nationalCode) throws DuplicateNationalCodeException {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hql = "SELECT COUNT (*) FROM Person  where nationalCode=:nationalCode";
        Query query = entityManager.createQuery(hql);
        query.setParameter("nationalCode", nationalCode);
        Long count = ((Number) query.getSingleResult()).longValue();
        entityManager.getTransaction().commit();
        entityManager.close();
        if (count == 1)
            throw new DuplicateNationalCodeException("national code is duplicated");
        return true;
    }

    public Person findByNationalCode(String nationalCode) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hql = "from Person where nationalCode=:nationalCode";
        Query query = entityManager.createQuery(hql, Person.class);
        query.setParameter("nationalCode", nationalCode);
        Person person = (Person) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return person;
    }

    public void update(Person person) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void remove(Person person) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Person.class, person.getId()));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
