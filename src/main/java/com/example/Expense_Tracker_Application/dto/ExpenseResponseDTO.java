package com.example.Expense_Tracker_Application.dto;

import java.time.LocalDate;

public class ExpenseResponseDTO {
    private Long id;
    private Double amount;
    private String category;
    private String paymentMode;
    private LocalDate expenseDate;

    public ExpenseResponseDTO() {}

    public ExpenseResponseDTO(Long id, Double amount, String category,
                              String paymentMode, LocalDate expenseDate) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.paymentMode = paymentMode;
        this.expenseDate = expenseDate;
    }

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }
}
