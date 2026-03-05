package com.example.Expense_Tracker_Application.Controller;

import com.example.Expense_Tracker_Application.Model.Expense;
import com.example.Expense_Tracker_Application.Service.ExpenseService;
import com.example.Expense_Tracker_Application.dto.ExpenseResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@Tag(name = "Expense API", description = "Expense Tracker APIs")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;


    @PostMapping
    public Expense addExpense(@Valid @RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    @GetMapping
    public List<ExpenseResponseDTO> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/date")
    public List<Expense> getByDate(@RequestParam LocalDate date) {
        return expenseService.getExpensesByDate(date);
    }

    @GetMapping("/monthly-total")
    public Double getMonthlyTotal(@RequestParam int month) {
        return expenseService.getMonthlyTotal(month);
    }

    @GetMapping("/category-wise")
    public List<Object[]> getCategoryWiseMonthlySpend(@RequestParam int month) {
        return expenseService.getCategoryWiseMonthlySpend(month);
    }


    @GetMapping("/payment-mode-wise")
    public List<Object[]> getPaymentModeWiseMonthlySpend(@RequestParam int month) {
        return expenseService.getPaymentModeWiseMonthlySpend(month);
    }


    @PutMapping("/{id}")
    public Expense updateExpense(
            @PathVariable Long id,
            @Valid @RequestBody Expense expense) {

        return expenseService.updateExpense(id, expense);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense deleted successfully");
    }


    @GetMapping("/paginated")
    public Page<Expense> getExpensesWithPagination(
            @RequestParam int page,
            @RequestParam int size) {

        return expenseService.getExpensesWithPagination(page, size);
    }



}
