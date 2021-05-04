package com.pragmatists.bank.domain.test;

import com.pragmatists.bank.domain.Account;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class StatementPrintingSteps {

    private Account account;

    @BeforeStory
    public void beforeStoryDo() {
        account = new Account();
    }

    @Given("a client makes a deposit of $value on $date")
    public void givenAClientMakesADepositOf(int value, Date date) {
    }

    @Given("a deposit of $value on $date")
    public void givenADepositOf(int value, Date date) {
    }

    @Given("a withdrawal of $value on $date")
    public void givenAWithdrawalOf(int value, Date date) {
    }

    @When("she prints her bank statement")
    public void whenSheChecksHerBankStatement() {
    }

    @Then("she would see $statement")
    public void thenSheWouldSee(String statement) {
    }

    public static LocalDate getLocalDateFromDate(Date date){
        return LocalDate.from(Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()));
    }

}
