package ir.maktab.repository;

import ir.maktab.entitty.HousingLoan;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class HousingLoanRepository {

    public void creat(HousingLoan housingLoan) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(housingLoan);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public HousingLoan findById(int id) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hql = "from HousingLoan where id=:id";
        Query query = entityManager.createQuery(hql, HousingLoan.class);
        query.setParameter("id", id);
        HousingLoan housingLoan = (HousingLoan) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return housingLoan;
    }

    public void update(HousingLoan housingLoan) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(housingLoan);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void remove(HousingLoan housingLoan) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(HousingLoan.class, housingLoan.getId()));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
