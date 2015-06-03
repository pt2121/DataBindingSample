package com.prt2121.rx.data.api.model;

import com.google.gson.annotations.SerializedName;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static com.prt2121.rx.util.Preconditions.checkNotNull;

/**
 * Taken from JakeWharton's u2020
 */
public final class User {

    @NonNull
    public final String login;

    @SerializedName("avatar_url")
    @Nullable
    public final String avatarUrl;

    public User(String login, @Nullable String avatarUrl) {
        this.login = checkNotNull(login, "login == null");
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}