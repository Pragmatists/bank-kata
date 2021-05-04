package com.pragmatists.bank.domain;

import com.pragmatists.bank.Printable;

import java.time.LocalDate;

import static com.pragmatists.bank.domain.Amount.amountOf;


public class Transaction {

    private static final String EMPTY_VALUE = "          ";

    private Amount value;
    private LocalDate date;

    public Transaction(Amount value, LocalDate date) {
        this.value = value;
        this.date = date;
    }

    public Amount balanceAfterTransaction(Amount currentBalance) {
        return currentBalance.plus(value);
    }

    public void printTo(Printable printer, Amount currentBalance) {
        StringBuilder builder = new StringBuilder();
        addDateTo(builder);
        addValueTo(builder);
        addCurrentBalanceTo(builder, currentBalance);
        printer.println(builder);
    }

    private void addCurrentBalanceTo(StringBuilder builder, Amount currentBalance) {
        builder.append("| ")
                .append(currentBalance.moneyRepresentation());
    }

    private void addValueTo(StringBuilder builder) {
        if (value.isGreaterThan(amountOf(0))) {
            addCreditTo(builder);
        } else {
            addDebitTo(builder);
        }
    }

    private void addDebitTo(StringBuilder builder) {
        builder.append(EMPTY_VALUE)
                .append("|")
                .append(valueToString());
    }

    private void addCreditTo(StringBuilder builder) {
        builder.append(valueToString())
                .append("|")
                .append(EMPTY_VALUE);
    }

    private String valueToString() {
        String stringValue = " " + value.absoluteValue().moneyRepresentation();
        return stringValue;
    }

    private void addDateTo(StringBuilder builder) {
        builder.append(date);
        builder.append(" |");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        Transaction other = (Transaction) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }


}
