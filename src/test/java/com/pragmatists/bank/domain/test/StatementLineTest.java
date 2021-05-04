package com.pragmatists.bank.domain.test;

import com.pragmatists.bank.Printable;
import com.pragmatists.bank.domain.StatementLine;
import org.junit.Test;

import java.time.LocalDate;

import static com.pragmatists.bank.domain.Amount.amountOf;
import static com.pragmatists.bank.domain.test.TransactionBuilder.aTransaction;
import static org.assertj.core.api.Assertions.assertThat;

public class StatementLineTest {

    @Test
    public void
    should_print_itself() {
        StatementLine statementLine = new StatementLine(
                aTransaction()
                        .with(amountOf(1000))
                        .with(LocalDate.of(2012, 1, 10)).build(),
                amountOf(1000));

        Printable printer = new Printable();
        statementLine.printTo(printer);

        assertThat(printer.getValue()).isEqualTo("2012-01-10 | 1000.00|          | 1000.00\n");
    }

    @Test
    public void
    should_print_withdrawal() {
        StatementLine statementLine = new StatementLine(
                aTransaction()
                        .with(amountOf(-1000))
                        .with(LocalDate.of(2012, 1, 10)).build(),
                amountOf(-1000));

        Printable printer = new Printable();
        statementLine.printTo(printer);

        assertThat(printer.getValue()).isEqualTo("2012-01-10 |          | 1000.00| -1000.00\n");
    }


}
