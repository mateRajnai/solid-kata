package com.codurance.srp.logger;


import com.codurance.srp.utils.FormatUtils;
import com.codurance.srp.model.Transaction;

import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toCollection;

public class TransactionLogger {

    private static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";

    private Console console;


    public TransactionLogger(Console console) {
        this.console = console;
    }

    private void printHeader() {
        console.printLine(STATEMENT_HEADER);
    }


    private void printTransactions(List<Transaction> transactions) {
        final AtomicInteger balance = new AtomicInteger(0);
        transactions.stream()
                .map(transaction -> statementLine(transaction, balance.addAndGet(transaction.amount())))
                .collect(toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(console::printLine);
    }

    private String statementLine(Transaction transaction, int balance) {
        return MessageFormat.format("{0} | {1} | {2}",
                FormatUtils.formatDate(transaction.date()),
                FormatUtils.formatNumber(transaction.amount()),
                FormatUtils.formatNumber(balance));
    }



    public void printStatement(List<Transaction> transactions) {
        printHeader();
        printTransactions(transactions);
    }
}
