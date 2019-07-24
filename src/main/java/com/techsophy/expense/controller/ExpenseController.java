package com.techsophy.expense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techsophy.expense.entity.ExpenseEntity;
import com.techsophy.expense.service.ExpenseService;

@RestController
@RequestMapping(value="/expense",produces = "application/json")
@CrossOrigin(origins = "http://localhost:8081" ,maxAge=3600)
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	@PostMapping("/new") // Create a new Person /
	public ResponseEntity<ExpenseEntity> createExpense(@RequestBody ExpenseEntity expense) {

		ExpenseEntity addedExpense = expenseService.addExpense(expense);
		return ResponseEntity.ok(addedExpense);

	}

	
	@GetMapping("/expenses") // Get All Person
	public ResponseEntity<List<ExpenseEntity>> getAllExpense() {

		List<ExpenseEntity> expenseList = expenseService.getAllExpenses();

		return ResponseEntity.ok(expenseList);
	}

	 
	@PutMapping("/expense/{id}") // Update a person with specific id
	public ResponseEntity<ExpenseEntity> updateExpense(@PathVariable(value = "id") Integer id, @RequestBody  ExpenseEntity expense) {

			expense.setId(id);
			return ResponseEntity.ok(expenseService.updateExpense(expense));
		
	}

	
	@DeleteMapping("/delete/{id}") // Delete a person with specific id
	public ResponseEntity<String> deleteExpense(@PathVariable(value = "id") Integer id) {

		     expenseService.deleteExpense(id);

			return ResponseEntity.status(HttpStatus.OK).body(" "+id.toString() + " id is successfully deleted.");
		}
	
	
	@GetMapping(path = "/expense/search", params = { "date"})
	public ResponseEntity<List<ExpenseEntity>> searchByDate(	@RequestParam(name = "date") String date){

		List<ExpenseEntity> expenseSearchedList = expenseService.searchExpenseByDate(date);

		return ResponseEntity.ok(expenseSearchedList);
	}
}
