package com.example.minimo2dsaexample;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    List<Element> listDatos;
    RecyclerView recycler;
    RecyclerView.Adapter mAdapter;
    private ProgressBar progressBar;


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://do.diba.cat/api/dataset/museus/format/json/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    API api = retrofit.create((API.class));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.my_recycler_view);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setHasFixedSize(true);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        Call<Museums> call = api.museumsInfo(0,40);
        call.enqueue(new Callback<Museums>() {
            @Override
            public void onResponse(Call<Museums> call, Response<Museums> response) {
                if (response.isSuccessful()) {
                    Museums museums = response.body();
                    listDatos = museums.getElements();
                    mAdapter = new MyAdapter(listDatos, MainActivity.this);
                    recycler.setAdapter(mAdapter);
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<Museums> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "No s'ha rebut la informació correctament.", Toast.LENGTH_SHORT);
                toast1.show();
            }

        });

    }
}