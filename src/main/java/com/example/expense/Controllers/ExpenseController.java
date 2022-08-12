package com.example.expense.Controllers;

import com.example.expense.models.Expense;
import com.example.expense.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepo;

    @GetMapping("/expense/add")
    public String addExpense(Model model){
        return "expense-add";
    }

    @PostMapping("/expense/add")
    public String expensePostAdd(@RequestParam double money, @RequestParam String reason, @RequestParam String date, Model model){
        LocalDate date2 = LocalDate.parse(date);
        Date date3 = Date.from(date2.atStartOfDay(ZoneId.systemDefault()).toInstant());
        BigDecimal money2 = BigDecimal.valueOf(money);
        Expense expense = new Expense(date3, money2,reason);
        expenseRepo.save(expense);
        return "redirect:/home";
    }

    @GetMapping("expense/information")
    public String incomeInformation(Model model){
        Iterable<Expense> list = expenseRepo.findAll();
        model.addAttribute("list",list);
        return "expense-data";
    }


}
