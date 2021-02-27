package com.example.moviehot.Screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.moviehot.Adapter.AdapterMovie;
import com.example.moviehot.Model.Page;
import com.example.moviehot.Network.DaggerRetrofit;
import com.example.moviehot.Network.Retrofit;
import com.example.moviehot.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    public static final String KEY = "25f4e34706c1c7811234b0b223403e24";
    public static final String LANGUAGUE = "en-ES";
    public static final int PAGE = 1;

    private MainActivityPresenter presenter;

    private AdapterMovie adapterMovie;
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainActivityPresenter(this);
        initUI();
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recycleview);
        adapterMovie = new AdapterMovie(this);
        progressDialog = new ProgressDialog(this);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapterMovie);
        presenter.getMovie(KEY, LANGUAGUE, PAGE);
    }

    @Override
    public void onSuccess(Page page) {
        adapterMovie.setMovies(page);
        progressDialog.dismiss();
    }

    @Override
    public void onFail(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        progressDialog.dismiss();
    }

    @Override
    public void onPending() {
        progressDialog.setTitle("Waiting ....");
        progressDialog.setMessage("App is downloading....");
        progressDialog.setCancelable(true);
        progressDialog.show();
    }
}