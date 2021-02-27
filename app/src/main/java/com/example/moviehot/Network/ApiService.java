package com.example.moviehot.Network;

import com.example.moviehot.Model.Page;

import java.util.List;

import dagger.Component;
import dagger.Module;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiService {
    //https://api.themoviedb.org/3/movie/popular?api_key=25f4e34706c1c7811234b0b223403e24&language=en-ES&page=1


    @GET("/3/movie/popular")
    Call<Page> getMovie(@Query("api_key") String api_key, @Query("language") String language,
                              @Query("page") int page);
}
