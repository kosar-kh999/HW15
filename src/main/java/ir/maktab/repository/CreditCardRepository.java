package ir.maktab.repository;

import ir.maktab.entitty.CreditCard;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CreditCardRepository {

    public void creat(CreditCard creditCard) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(creditCard);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public CreditCard findByCardNumber(String cardNumber) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hql = "from CreditCard where cardNumber=:cardNumber";
        Query query = entityManager.createQuery(hql, CreditCard.class);
        query.setParameter("cardNumber", cardNumber);
        CreditCard creditCard = (CreditCard) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return creditCard;
    }

    public void update(CreditCard creditCard) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(creditCard);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void remove(CreditCard creditCard) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(CreditCard.class, creditCard.getId()));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
