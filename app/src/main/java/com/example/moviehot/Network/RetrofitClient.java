package com.example.moviehot.Network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitClient {

    //https://api.themoviedb.org/3/movie/popular?api_key=25f4e34706c1c7811234b0b223403e24&language=en-ES&page=1

    String BASE_URL = "https://api.themoviedb.org/";

    @Provides
    public Gson createGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-dd HH:mm:ss")
                .create();
    }

    @Provides
    public ApiService retrofit(Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build().create(ApiService.class);
    }

}
