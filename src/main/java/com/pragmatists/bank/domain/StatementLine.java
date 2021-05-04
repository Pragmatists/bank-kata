package com.pragmatists.bank.domain;

import com.pragmatists.bank.Printable;

public class StatementLine {

    private Transaction transaction;
    private Amount currentBalance;

    public StatementLine(Transaction transaction, Amount currentBalance) {
        this.transaction = transaction;
        this.currentBalance = currentBalance;
    }

    public void printTo(Printable printer) {
        this.transaction.printTo(printer, currentBalance);
    }

}
