package ir.maktab.repository;

import ir.maktab.entitty.StudentTuitionLoan;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class StudentTuitionLoanRepository {

    public void creat(StudentTuitionLoan studentTuitionLoan) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(studentTuitionLoan);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public StudentTuitionLoan findById(int id) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hql = "from StudentTuitionLoan where id=:id";
        Query query = entityManager.createQuery(hql, StudentTuitionLoan.class);
        query.setParameter("id", id);
        StudentTuitionLoan studentTuitionLoan = (StudentTuitionLoan) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return studentTuitionLoan;
    }

    public void update(StudentTuitionLoan studentTuitionLoan) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(studentTuitionLoan);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void remove(StudentTuitionLoan studentTuitionLoan) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(StudentTuitionLoan.class, studentTuitionLoan.getId()));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
