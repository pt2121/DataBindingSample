package com.prt2121.mvvm.viewmodel;

import com.prt2121.mvvm.BR;
import com.prt2121.mvvm.model.User;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by pt2121 on 6/1/15.
 */
public class MainViewModel extends BaseObservable {

    private User user;

    @Bindable
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        notifyPropertyChanged(BR.user);
    }
}
