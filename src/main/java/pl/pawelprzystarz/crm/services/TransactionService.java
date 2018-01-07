package pl.pawelprzystarz.crm.services;

import pl.pawelprzystarz.crm.entities.Transaction;

import javax.validation.Valid;
import java.util.List;

public interface TransactionService {
    List<Transaction> getTransactions();
    void saveTransaction(Transaction transaction);
    Transaction getTransaction(int id);
    void deleteTransaction(int id);
}
