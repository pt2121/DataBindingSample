package com.prt2121.rx.data.api;

/**
 * Taken from JakeWharton's u2020
 */
public enum Order {
    ASC("asc"),
    DESC("desc");

    private final String value;

    Order(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
