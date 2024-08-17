package org.example.interfacefuncional;

@FunctionalInterface
public interface Filter<T> {
    boolean apply(T t);
}
