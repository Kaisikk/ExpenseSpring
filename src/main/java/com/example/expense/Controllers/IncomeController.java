package com.example.expense.Controllers;

import com.example.expense.models.Income;
import com.example.expense.repository.IncomeRepository;
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
public class IncomeController {

    @Autowired
    private IncomeRepository incomeRepo;


    @GetMapping("/income/add")
    public String addIncome (Model model){
        return "income-add";
    }


    @PostMapping("/income/add")
    public String addPostIncome(@RequestParam double money, @RequestParam String reason, @RequestParam String date, Model model){
        LocalDate stringToLocalDate = LocalDate.parse(date);
        Date LocalDateToDate = Date.from(stringToLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        BigDecimal doubleToBigDecimal = BigDecimal.valueOf(money);
        Income income = new Income(LocalDateToDate,doubleToBigDecimal,reason);
        incomeRepo.save(income);
        return "redirect:/home";
    }

    @GetMapping("income/information")
    public String incomeInformation(Model model){
        Iterable<Income> list = incomeRepo.findAll();
        model.addAttribute("list",list);
        return "income-data";
    }
}
