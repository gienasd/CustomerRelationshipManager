package pl.pawelprzystarz.crm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.pawelprzystarz.crm.entities.Transaction;
import pl.pawelprzystarz.crm.services.TransactionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TranscationController {

    @Autowired
    private TransactionService transactionService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {

        List<Transaction> transactions = transactionService.getTransactions();

        model.addAttribute("transactions", transactions);

        return "list-transactions";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Transaction transaction = new Transaction();

        model.addAttribute("transaction", transaction);

        return "transaction-form";
    }

    @PostMapping("/saveTransaction")
    public String saveCustomer(@Valid @ModelAttribute("transaction") Transaction transaction,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "transaction-form";
        }else{
            transactionService.saveTransaction(transaction);
            return "redirect:/transaction/list";
        }
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("transactionId") int id, Model model) {

        Transaction transaction = transactionService.getTransaction(id);

        model.addAttribute("transaction", transaction);

        return "transaction-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("transactionId") int id) {

        transactionService.deleteTransaction(id);

        return "redirect:/transaction/list";
    }
}
