package com.pragmatists.bank.domain.test;

import com.pragmatists.bank.Printable;
import com.pragmatists.bank.domain.Account;
import com.pragmatists.bank.domain.Amount;
import com.pragmatists.bank.domain.Statement;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;
import java.time.LocalDate;

import static com.pragmatists.bank.domain.Amount.amountOf;
import static com.pragmatists.bank.domain.test.TransactionBuilder.aTransaction;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountTest {

    @Mock
    private Statement statement;
    private Account account;

    @Before
    public void initialise() {
        account = new Account(statement);
    }

    @Test
    public void
    should_add_deposit_line_to_statement() {
        LocalDate depositDate = LocalDate.of(2012, 1, 10);
        Amount depositAmount = amountOf(1000);

        account.deposit(depositAmount, depositDate);

        verify(statement).addLineContaining(aTransaction()
                        .with(depositDate)
                        .with(depositAmount).build(),
                currentBalanceEqualsTo(depositAmount));
    }

    @Test
    public void
    should_add_withdraw_line_to_statement() {
        LocalDate withdrawalDate = LocalDate.of(2012, 1, 10);

        account.withdrawal(amountOf(500), withdrawalDate);

        verify(statement).addLineContaining(aTransaction()
                        .with(amountOf(-500))
                        .with(withdrawalDate).build(),
                amountOf(-500));
    }

    @Test
    public void
    should_print_statement() {
        Printable printer = new Printable();

        account.printStatement(printer);

        verify(statement).printTo(printer);
    }

    private Amount currentBalanceEqualsTo(Amount amount) {
        return amount;
    }

}
