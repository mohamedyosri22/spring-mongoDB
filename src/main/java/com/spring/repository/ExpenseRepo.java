package com.spring.repository;

import com.spring.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepo extends MongoRepository<Expense,String> {
    public Expense findByExpenseName(String name);
}
