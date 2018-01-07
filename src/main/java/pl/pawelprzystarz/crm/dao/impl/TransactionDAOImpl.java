package pl.pawelprzystarz.crm.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.pawelprzystarz.crm.dao.TransactionDAO;
import pl.pawelprzystarz.crm.entities.Transaction;

import java.util.List;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Transaction> getTransactions() {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Transaction order by price desc", Transaction.class);

        List<Transaction> transactions = query.getResultList();

        return transactions;
    }

    @Override
    public void saveTransaction(Transaction transaction) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(transaction);
    }

    @Override
    public Transaction getTransaction(int id) {

        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.get(Transaction.class, id);

        return transaction;
    }

    @Override
    public void deleteTransaction(int id) {

        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.get(Transaction.class, id);

        session.delete(transaction);
    }


}
