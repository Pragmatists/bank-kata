package com.pragmatists.bank.domain.test;

import com.pragmatists.bank.Printable;
import com.pragmatists.bank.domain.Amount;
import com.pragmatists.bank.domain.Transaction;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;

import static com.pragmatists.bank.domain.Amount.amountOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {

    Printable printer = new Printable();

    @Test
    public void
    should_print_credit_trasanction() {
        Transaction transaction = new Transaction(amountOf(1000), LocalDate.of(2012, 1, 10));

        transaction.printTo(printer, amountOf(1000));

        Assertions.assertThat(printer.getValue()).isEqualTo("2012-01-10 | 1000.00|          | 1000.00\n");
    }

    @Test
    public void
    should_print_debit_trasanction() {
        Transaction transaction = new Transaction(amountOf(-1000), LocalDate.of(2012, 1, 10));

        transaction.printTo(printer, amountOf(-1000));

        Assertions.assertThat(printer.getValue()).isEqualTo("2012-01-10 |          | 1000.00| -1000.00\n");
    }

    @Test
    public void
    should_calculate_current_balance_after_deposit() {
        Transaction transaction = new Transaction(amountOf(1000), LocalDate.of(2012, 1, 10));

        Amount currentValue = transaction.balanceAfterTransaction(amountOf(100));

        assertThat(currentValue, is(amountOf(1100)));
    }

    @Test
    public void
    should_calculate_current_balance_after_withdrawal() {
        Transaction transaction = new Transaction(amountOf(-1000), LocalDate.of(2012, 1, 10));

        Amount currentValue = transaction.balanceAfterTransaction(amountOf(100));

        assertThat(currentValue, is(amountOf(-900)));
    }

    @Test
    public void should_be_equal_to_other_transaction_with_same_value_and_date() {
        LocalDate depositDate = LocalDate.of(2012, 1, 10);
        Transaction depositOfOneHundred = new Transaction(amountOf(1000), depositDate);
        Transaction anotherDepositOfOneHundred = new Transaction(amountOf(1000), depositDate);

        assertThat(depositOfOneHundred, is(equalTo(anotherDepositOfOneHundred)));
    }

}
