package org.example;

import java.time.Month;
import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        double total = 0;
        for (final BankTransaction bankTransaction: bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalAmountInMonth(final Month month) {
        double total = 0;
        for (final BankTransaction bankTransaction: bankTransactions) {
            if (bankTransaction.getDate().getMonth().equals(month)){
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalAmountForCategory(final String category) {
        double total = 0;
        for (final BankTransaction bankTransaction: bankTransactions) {
            if (bankTransaction.getDescription().contains(category)){
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
}
