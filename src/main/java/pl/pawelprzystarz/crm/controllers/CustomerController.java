package pl.pawelprzystarz.crm.controllers;

import java.util.List;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import pl.pawelprzystarz.crm.entities.Customer;
import pl.pawelprzystarz.crm.entities.CustomerDetail;
import pl.pawelprzystarz.crm.services.CustomerService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		List<Customer> customers = customerService.getCustomers();
		
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Customer customer = new Customer();

		model.addAttribute("customer", customer);

		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer,
							   BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "customer-form";
		}else{
			customerService.saveCustomer(customer);
			return "redirect:/customer/list";
		}
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		
		Customer customer = customerService.getCustomer(id);

		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {

		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdateDetails")
	public String showFormForUpdateDetails(@RequestParam("customerId") int id, Model model) {

		CustomerDetail customerDetail = customerService.getDetails(id);

		Customer customer = customerService.getCustomer(id);

		model.addAttribute("customer", customer);

		if(customerDetail == null){
			CustomerDetail customerDetail2 = new CustomerDetail();
			model.addAttribute("detail", customerDetail2);
		}else {
			model.addAttribute("detail", customerDetail);
		}

		return "customer-detail-form";
	}

	@RequestMapping("/saveDetails")
	public String saveDetail(@Valid @ModelAttribute("detail") CustomerDetail customerDetail,
							BindingResult bindingResult) {

		if(bindingResult.hasErrors()){
			return "customer-detail-form";
		}else {
			customerService.saveDetail(customerDetail);
			return "redirect:/customer/list";
		}
	}
}
