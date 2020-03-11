package com.techsophy.expense.service;

import java.util.List;

import com.techsophy.expense.entity.ExpenseEntity;

public interface ExpenseService {

	ExpenseEntity addExpense(ExpenseEntity expense);

	List<ExpenseEntity> getAllExpenses();

	ExpenseEntity updateExpense(ExpenseEntity expense);

	void deleteExpense(Integer id);

	List<ExpenseEntity> getAllExpensesByDate(String date);

	List<ExpenseEntity> getAllExpensesByMonthAndYear(String date);

	List<ExpenseEntity> getAllExpensesByYear(String date);

}
