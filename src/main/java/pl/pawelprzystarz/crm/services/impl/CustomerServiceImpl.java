package pl.pawelprzystarz.crm.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.pawelprzystarz.crm.dao.CustomerDAO;
import pl.pawelprzystarz.crm.entities.Customer;
import pl.pawelprzystarz.crm.entities.CustomerDetail;
import pl.pawelprzystarz.crm.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}

    @Override
    @Transactional
    public void saveDetail(CustomerDetail customerDetail) {
        customerDAO.saveDetail(customerDetail);
    }

    @Override
    @Transactional
    public CustomerDetail getDetails(int id) {
        return customerDAO.getDetails(id);
    }
}