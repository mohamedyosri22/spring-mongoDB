package com.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Document("expense")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    @Id
    private String id;

    @Field(name="name")
    @Indexed(unique = true)
    private String expenseName;

    @Field(name="category")
    private ExpenseCategory expenseCategory;

    @Field(name="amount")
    private BigDecimal expenseAmount;
}
