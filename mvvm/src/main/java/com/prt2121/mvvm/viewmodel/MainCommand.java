package com.prt2121.mvvm.viewmodel;

import com.prt2121.mvvm.model.User;

import android.view.View;

/**
 * Created by pt2121 on 10/15/15.
 */
public class MainCommand {

    private final MainViewModel mViewModel;

    public MainCommand(MainViewModel viewModel) {
        mViewModel = viewModel;
    }

    public void updateUser(View view) {
        User phil = new User();
        phil.setName("Phil");
        phil.setAddress("777 Broad St");
        mViewModel.setUser(phil);
    }
}
