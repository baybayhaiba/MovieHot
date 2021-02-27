package com.example.moviehot.Screen;

import android.util.Log;

import com.example.moviehot.Model.Page;
import com.example.moviehot.Network.DaggerRetrofit;
import com.example.moviehot.Network.Retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityPresenter implements MainActivityView.Presenter {

    private MainActivityView view;
    private Retrofit retrofit;

    public MainActivityPresenter(MainActivityView view) {
        this.view = view;
        this.retrofit = DaggerRetrofit.create();
    }

    @Override
    public void getMovie(String KEY, String LANGUAGUE, int PAGE) {
        view.onPending();
        retrofit.service().getMovie(KEY, LANGUAGUE, PAGE)
                .enqueue(new Callback<Page>() {
                    @Override
                    public void onResponse(Call<Page> call, Response<Page> response) {
                        view.onSuccess(response.body());
                    }

                    @Override
                    public void onFailure(Call<Page> call, Throwable t) {
                        view.onFail(t.getMessage());
                    }
                });
    }
}
