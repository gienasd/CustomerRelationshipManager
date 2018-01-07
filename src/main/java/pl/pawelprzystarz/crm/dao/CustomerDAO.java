package pl.pawelprzystarz.crm.dao;

import java.util.List;

import pl.pawelprzystarz.crm.entities.Customer;
import pl.pawelprzystarz.crm.entities.CustomerDetail;

public interface CustomerDAO {
	List<Customer> getCustomers();
	void saveCustomer(Customer customer);
	Customer getCustomer(int id);
	void deleteCustomer(int id);
	void saveDetail(CustomerDetail customerDetail);
	CustomerDetail getDetails(int id);
}
