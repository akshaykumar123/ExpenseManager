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

	@PostMapping("/new") // Create a new Person.
	public ResponseEntity<ExpenseEntity> createExpense(@RequestBody ExpenseEntity expense) {

		ExpenseEntity addedExpense = expenseService.addExpense(expense);

		return ResponseEntity.ok(addedExpense);

	}

	@GetMapping("/expenses") // Get All Person.
	public ResponseEntity<List<ExpenseEntity>> getAllExpense() {

		List<ExpenseEntity> expenseList = expenseService.getAllExpenses();

		return ResponseEntity.ok(expenseList);
	}

	@DeleteMapping("/delete/{id}") // Delete a person with specific id.
	public ResponseEntity<?> deleteExpense(@PathVariable(value = "id") Integer id) {

		expenseService.deleteExpense(id);
		return null; 
	}

	@GetMapping(path = "/expense/search", params = { "date" }) // Search by Date.
	public ResponseEntity<List<ExpenseEntity>> searchByDate(@RequestParam(name = "date") String date) {

		List<ExpenseEntity> expenseSearchedList = expenseService.searchExpenseByDate(date);

		return ResponseEntity.ok(expenseSearchedList);
	}
}
