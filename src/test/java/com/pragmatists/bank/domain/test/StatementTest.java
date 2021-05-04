package com.pragmatists.bank.domain.test;

import com.pragmatists.bank.Printable;
import com.pragmatists.bank.domain.Statement;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static com.pragmatists.bank.domain.Amount.amountOf;
import static com.pragmatists.bank.domain.test.TransactionBuilder.aTransaction;

public class StatementTest {

    Printable printer;
    private Statement statement;

    @Before
    public void initialise() {
        statement = new Statement();
        printer = new Printable();
    }

    @Test
    public void
    should_print_statement_header() {
        statement.printTo(printer);

        Assertions.assertThat(printer.getValue()).isEqualTo(Statement.STATEMENT_HEADER + "\n");
    }

    @Test
    public void
    should_print_deposit() {
        statement.addLineContaining(aTransaction()
                        .with(amountOf(1000))
                        .with(LocalDate.of(2012, 1, 10)).build(),
                amountOf(1000));

        statement.printTo(printer);

        Assertions.assertThat(printer.getValue()).isEqualTo(
                "date       | credit   | debit    | balance\n" +
                        "2012-01-10 | 1000.00|          | 1000.00\n");
    }

    @Test
    public void
    should_print_withdrawal() {
        statement.addLineContaining(aTransaction()
                        .with(amountOf(-1000))
                        .with(LocalDate.of(2012, 1, 10)).build(),
                amountOf(-1000));

        statement.printTo(printer);

        Assertions.assertThat(printer.getValue()).isEqualTo(
                "date       | credit   | debit    | balance\n" +
                        "2012-01-10 |          | 1000.00| -1000.00\n");
    }

    @Test
    public void
    should_print_two_deposits_in_reverse_order() {
        statement.addLineContaining(aTransaction()
                        .with(amountOf(1000))
                        .with(LocalDate.of(2012, 1, 10)).build(),
                amountOf(1000));
        statement.addLineContaining(aTransaction()
                        .with(amountOf(2000))
                        .with(LocalDate.of(2012, 1, 13)).build(),
                amountOf(3000));

        statement.printTo(printer);

        Assertions.assertThat(printer.getValue()).isEqualTo(
                "date       | credit   | debit    | balance\n" +
                        "2012-01-13 | 2000.00|          | 3000.00\n" +
                        "2012-01-10 | 1000.00|          | 1000.00\n");
    }

}
