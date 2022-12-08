package ir.maktab.repository;

import ir.maktab.entitty.AllocatedLoan;
import ir.maktab.entitty.Collegian;
import ir.maktab.entitty.Loan;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AllocatedLoanRepository {

    public void persist(AllocatedLoan allocatedLoan) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(allocatedLoan);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(AllocatedLoan allocatedLoan) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(allocatedLoan);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public AllocatedLoan find(Loan loan, Collegian collegian) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select e from AllocatedLoan  e where e.loan=:loan and " +
                "e.collegian=:collegian");
        query.setParameter("loan", loan);
        query.setParameter("collegian", collegian);
        AllocatedLoan singleResult = (AllocatedLoan) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }

    public void remove(Loan loan, Collegian collegian) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        AllocatedLoan allocatedLoan = find(loan, collegian);
        entityManager.remove(allocatedLoan);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
