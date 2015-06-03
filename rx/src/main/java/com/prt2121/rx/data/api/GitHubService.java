package com.prt2121.rx.data.api;

import com.prt2121.rx.data.api.model.RepositoriesResponse;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Taken from JakeWharton's u2020
 */
public interface GitHubService {

    @GET("/search/repositories")
    Observable<RepositoriesResponse> repositories( //
            @Query("q") SearchQuery query, //
            @Query("sort") Sort sort, //
            @Query("order") Order order);
}