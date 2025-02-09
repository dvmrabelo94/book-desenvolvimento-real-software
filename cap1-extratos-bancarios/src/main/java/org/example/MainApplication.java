package org.example;

import java.io.IOException;

public class MainApplication {
    public static void main(final String... args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer
                = new BankStatementAnalyzer();

        final BankStatementParser bankStatementParser
                = new BankStatementCSVParser();

        final Exporter exporter = new HtmlExporter();

        bankStatementAnalyzer.analyze("bank-data-simple.csv", bankStatementParser, exporter);

    }

}
