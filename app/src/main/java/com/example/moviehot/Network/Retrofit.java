package com.example.moviehot.Network;

import dagger.Component;

@Component(modules = RetrofitClient.class)
public interface Retrofit {
    ApiService service();
}
