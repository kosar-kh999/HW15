package ir.maktab.repository;

import ir.maktab.entitty.Refund;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class RefundRepository {
    public void creat(Refund refund) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(refund);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Refund findById(int id) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hql = "from Refund where id=:id";
        Query query = entityManager.createQuery(hql, Refund.class);
        query.setParameter("id", id);
        Refund refund = (Refund) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return refund;
    }

    public void update(Refund refund) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(refund);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void remove(Refund refund) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Refund.class, refund.getId()));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void increaseMonthOfPaid(Refund refund) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        refund.setNumberOfMonth(refund.getNumberOfMonth() + 1);
        entityManager.merge(refund);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void decreaseMonthOfRemain(Refund refund) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        refund.setNumberOfMonth(refund.getNumberOfMonth() - 1);
        entityManager.merge(refund);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Refund> getAll() {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        List refunds = entityManager.createQuery("from Refund ").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return refunds;
    }

}
