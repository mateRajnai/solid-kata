package com.codurance.srp.service;

import com.codurance.srp.logger.TransactionLogger;
import com.codurance.srp.model.Transaction;
import com.codurance.srp.repository.TransactionRepository;

public class AccountService {

    private TransactionRepository transactionRepository;
    private Clock clock;
    private TransactionLogger transactionLogger;

    public AccountService(TransactionRepository transactionRepository, Clock clock, TransactionLogger transactionLogger) {
        this.transactionRepository = transactionRepository;
        this.clock = clock;
        this.transactionLogger = transactionLogger;
    }

    public void deposit(int amount) {
        transactionRepository.add(transactionWith(amount));
    }


    public void withdraw(int amount) {
        transactionRepository.add(transactionWith(-amount));
    }

    public void printStatement() {
        transactionLogger.printStatement(transactionRepository.all());
    }


    private Transaction transactionWith(int amount) {
        return new Transaction(clock.today(), amount);
    }

}