package com.prt2121.rx.data;

import com.prt2121.rx.data.api.GitHubService;
import com.prt2121.rx.data.api.Order;
import com.prt2121.rx.data.api.SearchQuery;
import com.prt2121.rx.data.api.Sort;
import com.prt2121.rx.data.api.model.Item;
import com.prt2121.rx.ui.trending.TrendingTimespan;

import retrofit.RestAdapter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pt2121 on 6/3/15.
 */
public class DataLayer {

    public static RestAdapter getRestAdapter() {
        return new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }

    public static GitHubService getGitHubService(RestAdapter restAdapter) {
        return restAdapter.create(GitHubService.class);
    }

    public static Observable<Item> getGitHubRepositorySearch(GitHubService gitHubService) {
        SearchQuery trendingQuery = new SearchQuery.Builder()
                .createdSince(TrendingTimespan.WEEK.createdSince())
                .build();
        return gitHubService.repositories(trendingQuery, Sort.STARS, Order.DESC)
                .map(repositoriesResponse -> repositoriesResponse.items.get(0))
                .first()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
