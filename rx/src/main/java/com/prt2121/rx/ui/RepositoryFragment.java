package com.prt2121.rx.ui;

import com.prt2121.rx.R;
import com.prt2121.rx.data.api.GitHubService;
import com.prt2121.rx.data.api.Order;
import com.prt2121.rx.data.api.SearchQuery;
import com.prt2121.rx.data.api.Sort;
import com.prt2121.rx.data.api.model.Item;
import com.prt2121.rx.databinding.FragmentRepositoryBinding;
import com.prt2121.rx.ui.trending.TrendingTimespan;
import com.prt2121.rx.viewmodel.RepositoryViewModel;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import retrofit.RestAdapter;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RepositoryFragment extends Fragment {

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
        final RepositoryViewModel repositoryViewModel = new RepositoryViewModel();
        binding.setRepositoryViewModel(repositoryViewModel);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        GitHubService gitHubService = provideGitHubService(restAdapter);
        SearchQuery trendingQuery = new SearchQuery.Builder()
                .createdSince(TrendingTimespan.WEEK.createdSince())
                .build();
        gitHubService.repositories(trendingQuery, Sort.STARS, Order.DESC)
                .doOnNext(repositoriesResponse -> Log.d(RepositoryFragment.class.getSimpleName(), "" + repositoriesResponse.items.size()))
                .map(repositoriesResponse -> repositoriesResponse.items.get(0))
                .first()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Item>() {
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
                        repositoryViewModel.setRepository(repository);
                    }
                });

        return inflater.inflate(R.layout.fragment_repository, container, false);
    }

    GitHubService provideGitHubService(RestAdapter restAdapter) {
        return restAdapter.create(GitHubService.class);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}