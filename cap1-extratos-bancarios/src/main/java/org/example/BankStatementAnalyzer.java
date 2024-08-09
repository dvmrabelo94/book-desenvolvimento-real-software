package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

    private static final String RESOURCES = "src/main/resources/";

    public void analyzer(final String fileName, final BankStatementParser bankStatementParser) throws IOException {

        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("O total das trasações é de " + bankStatementProcessor.calculateTotalAmount());

        System.out.println("Transactions in this month: " + bankStatementProcessor.calculateTotalAmountInMonth(LocalDate.now().getMonth()));

        System.out.println("Transactions in January: " + bankStatementProcessor.calculateTotalAmountInMonth(Month.JANUARY));

        System.out.println("Transactions in February: " + bankStatementProcessor.calculateTotalAmountInMonth(Month.FEBRUARY));

        System.out.println("Total salary : " + bankStatementProcessor.calculateTotalAmountForCategory("Salary"));
    }
}
