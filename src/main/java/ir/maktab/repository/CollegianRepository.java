package ir.maktab.repository;

import ir.maktab.entitty.Collegian;
import ir.maktab.exception.DuplicateNationalCodeException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CollegianRepository {

    public void creat(Collegian collegian) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(collegian);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public boolean checkUsername(String username) throws DuplicateNationalCodeException {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hql = "SELECT COUNT (*) FROM Collegian  where username=:username";
        Query query = entityManager.createQuery(hql);
        query.setParameter("username", username);
        Long count = ((Number) query.getSingleResult()).longValue();
        entityManager.getTransaction().commit();
        entityManager.close();
        if (count == 1)
            throw new DuplicateNationalCodeException("national code is duplicated");
        return true;
    }

    public Collegian findByUsernameAndPassword(String username, String password) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hql = "from Collegian where username=:username and password=:password";
        Query query = entityManager.createQuery(hql, Collegian.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        Collegian collegian = (Collegian) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return collegian;
    }

    public void update(Collegian collegian) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(collegian);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void remove(Collegian collegian) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Collegian.class, collegian.getId()));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
