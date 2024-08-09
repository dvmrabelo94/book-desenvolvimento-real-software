package org.example;

import java.io.IOException;

public class MainApplication {

    private static final String RESORUCES = "src/main/resources/";

    public static void main(final String... args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();

        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyzer(args[0], bankStatementParser);
    }

}
