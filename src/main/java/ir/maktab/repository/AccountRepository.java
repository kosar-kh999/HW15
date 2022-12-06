package ir.maktab.repository;

import ir.maktab.entitty.Account;
import ir.maktab.entitty.Collegian;
import ir.maktab.exception.DuplicateNationalCodeException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AccountRepository {

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
        String hql = "SELECT COUNT (*) FROM Account  where username=:username";
        Query query = entityManager.createQuery(hql);
        query.setParameter("username", username);
        Long count = ((Number) query.getSingleResult()).longValue();
        entityManager.getTransaction().commit();
        entityManager.close();
        if (count == 1)
            throw new DuplicateNationalCodeException("national code is duplicated");
        return true;
    }

    public Account findByUsernameAndPassword(String username, String password) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hql = "from Account where username=:username and password=:password";
        Query query = entityManager.createQuery(hql, Account.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        Account account = (Account) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return account;
    }

    public void update(Account account) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(account);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void remove(Account account) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Account.class, account.getId()));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
