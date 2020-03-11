package com.techsophy.expense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techsophy.expense.entity.ExpenseEntity;
import com.techsophy.expense.service.ExpenseService;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;

	@PostMapping("/new") // Create a New Expense.
	public ResponseEntity<ExpenseEntity> createExpense(@RequestBody ExpenseEntity expense) {

		ExpenseEntity addedExpense = expenseService.addExpense(expense);

		return ResponseEntity.ok(addedExpense);

	}

	@GetMapping("/expenses") // Get All Expenses.
	public ResponseEntity<List<ExpenseEntity>> getAllExpense() {

		List<ExpenseEntity> expenseList = expenseService.getAllExpenses();

		return ResponseEntity.ok(expenseList);
	}

	@GetMapping(path = "/expenses/", params = { "date" }) // Get All Expenses By Date.
	public ResponseEntity<List<ExpenseEntity>> getAllExpenseByDate(@RequestParam(name = "date") String date) {

		List<ExpenseEntity> expenseList = expenseService.getAllExpensesByDate(date);

		return ResponseEntity.ok(expenseList);
	}

	@GetMapping(path = "/expenses/getAllByMonthAndYear/", params = { "date" }) // Get All Expenses By Month and Year.
	public ResponseEntity<List<ExpenseEntity>> getAllExpenseByMonthAndYear(@RequestParam(name = "date") String date) {

		List<ExpenseEntity> expenseList = expenseService.getAllExpensesByMonthAndYear(date);

		return ResponseEntity.ok(expenseList);
	}

	@GetMapping(path = "/expenses/getAllByYear/", params = { "date" }) // Get All Expenses By Year.
	public ResponseEntity<List<ExpenseEntity>> getAllExpenseByYear(@RequestParam(name = "date") String date) {

		List<ExpenseEntity> expenseList = expenseService.getAllExpensesByYear(date);

		return ResponseEntity.ok(expenseList);
	}

	@DeleteMapping("/delete/{id}") // Delete an Expense with specific id.
	public ResponseEntity<ExpenseEntity> deleteExpense(@PathVariable(value = "id") Integer id) {

		expenseService.deleteExpense(id);
		return null;
	}

}
