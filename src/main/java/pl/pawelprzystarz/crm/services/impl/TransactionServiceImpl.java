package pl.pawelprzystarz.crm.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pawelprzystarz.crm.dao.TransactionDAO;
import pl.pawelprzystarz.crm.entities.Transaction;
import pl.pawelprzystarz.crm.services.TransactionService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDAO transactionDAO;

    @Transactional
    @Override
    public List<Transaction> getTransactions() {
        return transactionDAO.getTransactions();
    }

    @Transactional
    @Override
    public void saveTransaction(Transaction transaction) {
        transactionDAO.saveTransaction(transaction);
    }

    @Transactional
    @Override
    public Transaction getTransaction(int id) {
        return transactionDAO.getTransaction(id);
    }

    @Transactional
    @Override
    public void deleteTransaction(int id) {
        transactionDAO.deleteTransaction(id);
    }
}
