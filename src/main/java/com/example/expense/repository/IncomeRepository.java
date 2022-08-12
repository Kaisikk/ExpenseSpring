package com.example.expense.repository;

import com.example.expense.models.Income;
import org.springframework.data.repository.CrudRepository;

public interface IncomeRepository extends CrudRepository<Income,Long> {
}
