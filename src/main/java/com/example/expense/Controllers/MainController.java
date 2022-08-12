package com.example.expense.Controllers;



import com.example.expense.repository.ExpenseRepository;
import com.example.expense.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {


    @Autowired
   private ExpenseRepository ExpenseRepo;

    @Autowired
    private IncomeRepository IncomeRepo;

    @GetMapping("/home")
    public String home (Model model){

        return "home";
    }



}