package com.prt2121.rx.ui;

import com.prt2121.rx.R;
import com.prt2121.rx.data.DataLayer;
import com.prt2121.rx.data.api.model.Item;
import com.prt2121.rx.databinding.FragmentRepositoryBinding;
import com.prt2121.rx.viewmodel.RepositoryViewModel;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

public class RepositoryFragment extends Fragment {

    private RepositoryViewModel mRepositoryViewModel;

    public Subscription mSubscription;

    public static RepositoryFragment newInstance() {
        return new RepositoryFragment();
    }

    public RepositoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        FragmentRepositoryBinding binding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_repository);
        mRepositoryViewModel = new RepositoryViewModel();
        binding.setRepositoryViewModel(mRepositoryViewModel);
        return inflater.inflate(R.layout.fragment_repository, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Observable<Item> observable = DataLayer
                .getGitHubRepositorySearch(DataLayer.getGitHubService(DataLayer.getRestAdapter()));

        mSubscription = observable.subscribe(new Subscriber<Item>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e(RepositoryFragment.class.getSimpleName(),
                        "Failed to get trending repositories " + e.getLocalizedMessage());
            }

            @Override
            public void onNext(Item repository) {
                Log.d("TAG", "repository " + repository);
                mRepositoryViewModel.setRepository(repository);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mSubscription.unsubscribe();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}