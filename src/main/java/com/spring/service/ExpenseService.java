package com.spring.service;

import com.spring.model.Expense;
import com.spring.repository.ExpenseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepo expenseRepo;
    public ExpenseService(ExpenseRepo expenseRepo) {
        this.expenseRepo = expenseRepo;
    }

    public void addExpense(Expense expense){
        expenseRepo.insert(expense);
    }

    public Expense updateExpense(Expense expense){
        Expense dbExpense = expenseRepo.findById(expense.getId())
                .orElseThrow(()->new RuntimeException
                        (String.format("Expense with id %s not found",expense.getId())));

        dbExpense.setExpenseName(expense.getExpenseName());
        dbExpense.setExpenseCategory(expense.getExpenseCategory());
        dbExpense.setExpenseAmount(expense.getExpenseAmount());

        return expenseRepo.save(expense);
    }

    public List<Expense> getAllExpense(){
        return expenseRepo.findAll();
    }

    public Expense getExpenseByName(String expenseName){
        Expense dbExpense = expenseRepo.findByExpenseName(expenseName);
        if(dbExpense == null){
            throw new RuntimeException(String.format("expense with name %s not found",
                    expenseName));

        }
        return dbExpense;
    }

    public void deleteExpense(String id){
        expenseRepo.deleteById(id);
    }
}
