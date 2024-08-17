package org.example.interfacefuncional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static List<Product> filter(List<Product> products, Filter<Product> filter) {
        return products.stream()
                .filter(filter::apply)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Notebook", 3000d));
        products.add(new Product("Mouse", 50d));
        products.add(new Product("Teclado", 150d));
        products.add(new Product("Monitor", 800d));

        List<Product> productsFiltered = filter(products, p -> p.price() > 100);

        productsFiltered.forEach(System.out::println);
    }
}
