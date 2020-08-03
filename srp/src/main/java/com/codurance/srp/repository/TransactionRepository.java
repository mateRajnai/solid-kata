package com.codurance.srp.repository;

import com.codurance.srp.model.Transaction;

import java.util.List;

public interface TransactionRepository {
    void add(Transaction transaction);
    List<Transaction> all();
}
