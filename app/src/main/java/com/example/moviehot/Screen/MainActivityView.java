package com.example.moviehot.Screen;

import com.example.moviehot.Model.Page;

public interface MainActivityView {
    public void onSuccess(Page page);

    public void onFail(String error);

    public void onPending();


    public interface Presenter {
        void getMovie(String KEY, String LANGUAGUE, int PAGE);
    }
}
