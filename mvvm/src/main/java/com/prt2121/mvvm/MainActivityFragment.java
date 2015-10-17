package com.prt2121.mvvm;

import com.prt2121.mvvm.databinding.FragmentMainBinding;
import com.prt2121.mvvm.model.User;
import com.prt2121.mvvm.viewmodel.MainCommand;
import com.prt2121.mvvm.viewmodel.MainViewModel;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivityFragment extends Fragment {

    public static MainActivityFragment newInstance() {
        return new MainActivityFragment();
    }

    public MainActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        FragmentMainBinding binding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_main);

        final MainViewModel mainViewModel = new MainViewModel();
        final MainCommand mainCommand = new MainCommand(mainViewModel);
        binding.setMainViewModel(mainViewModel);
        binding.setMainCommand(mainCommand);

        User user = new User();
        user.setName("Prat");
        user.setAddress("123 Main St");
        mainViewModel.setUser(user);

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

}