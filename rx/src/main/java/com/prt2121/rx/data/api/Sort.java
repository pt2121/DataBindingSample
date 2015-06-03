package com.prt2121.rx.data.api;

/**
 * Taken from JakeWharton's u2020
 */
public enum Sort {
    STARS("stars"),
    FORKS("forks"),
    UPDATED("updated");

    private final String value;

    Sort(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
