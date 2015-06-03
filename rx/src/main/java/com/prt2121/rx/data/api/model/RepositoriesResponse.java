package com.prt2121.rx.data.api.model;

import java.util.List;

/**
 * Taken from JakeWharton's u2020
 */
public final class RepositoriesResponse {

    public final List<Item> items;

    public RepositoriesResponse(List<Item> items) {
        this.items = items;
    }
}
