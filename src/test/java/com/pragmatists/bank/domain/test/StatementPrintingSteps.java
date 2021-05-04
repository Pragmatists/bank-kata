package com.pragmatists.bank.domain.test;

import com.pragmatists.bank.Printable;
import com.pragmatists.bank.domain.Account;
import com.pragmatists.bank.domain.Amount;
import com.pragmatists.bank.domain.Statement;
import org.assertj.core.api.Assertions;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class StatementPrintingSteps {

    private Account account;
    private Printable printer = new Printable();

    @BeforeStory
    public void beforeStoryDo() {
        account = new Account(new Statement());
    }

    @Given("a client makes a deposit of $value on $date")
    public void givenAClientMakesADepositOf(int value, Date date) {
        account.deposit(Amount.amountOf(value), getLocalDateFromDate(date));
    }

    @Given("a deposit of $value on $date")
    public void givenADepositOf(int value, Date date) {
        account.deposit(Amount.amountOf(value), getLocalDateFromDate(date));
    }

    @Given("a withdrawal of $value on $date")
    public void givenAWithdrawalOf(int value, Date date) {
        account.withdrawal(Amount.amountOf(value), getLocalDateFromDate(date));
    }

    @When("she prints her bank statement")
    public void whenSheChecksHerBankStatement() {
        account.printStatement(printer);
    }

    @Then("she would see $statement")
    public void thenSheWouldSee(String statement) {
		Assertions.assertThat(printer.getValue()).isEqualTo("" +
                "date       | credit   | debit    | balance\n" +
                "2012-01-14 |          | 500.00| 2500.00\n" +
                "2012-01-13 | 2000.00|          | 3000.00\n" +
                "2012-01-10 | 1000.00|          | 1000.00\n");
    }

    public static LocalDate getLocalDateFromDate(Date date){
        return LocalDate.from(Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()));
    }

}
