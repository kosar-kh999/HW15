package ir.maktab.repository;

import ir.maktab.entitty.EducationLoan;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EducationalLoanRepository {

    public void creat(EducationLoan educationLoan) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(educationLoan);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public EducationLoan findById(int id) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hql = "from EducationLoan where id=:id";
        Query query = entityManager.createQuery(hql, EducationLoan.class);
        query.setParameter("id", id);
        EducationLoan educationLoan = (EducationLoan) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return educationLoan;
    }

    public void update(EducationLoan educationLoan) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(educationLoan);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void remove(EducationLoan educationLoan) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(EducationLoan.class, educationLoan.getId()));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
