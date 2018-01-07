package pl.pawelprzystarz.crm.dao;

import pl.pawelprzystarz.crm.entities.Transaction;

import java.util.List;

public interface TransactionDAO {
    List<Transaction> getTransactions();
    void saveTransaction(Transaction transaction);
    Transaction getTransaction(int id);
    void deleteTransaction(int id);
}
