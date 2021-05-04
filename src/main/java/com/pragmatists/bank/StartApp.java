package com.pragmatists.bank;

import com.pragmatists.bank.domain.Account;
import com.pragmatists.bank.domain.Amount;
import com.pragmatists.bank.domain.Statement;

import java.time.LocalDate;

import static com.pragmatists.bank.domain.Amount.amountOf;

public class StartApp {

    public static void main(String[] args) {
        Account account = new Account(new Statement());
        Printable printer = new Printable();

        account.deposit(amountOf(1000), LocalDate.of(2012, 1, 10));
        account.deposit(amountOf(2000), LocalDate.of(2012, 1, 12));
        account.withdrawal(Amount.amountOf(500), LocalDate.of(2012, 1, 14));

        account.printStatement(printer);

        printer.printWith(System.out);
    }

}
