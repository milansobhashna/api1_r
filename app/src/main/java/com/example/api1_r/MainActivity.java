package com.example.api1_r;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    Context con = this;
    private RecyclerView recyclerView;
    private ArrayList<AndroidVersion> data;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(con));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface request = retrofit.create(RequestInterface.class);

        Call<List<AndroidVersion>> call = request.getJSON();

        call.enqueue(new Callback<List<AndroidVersion>>() {
            @Override
            public void onResponse(Call<List<AndroidVersion>> call, Response<List<AndroidVersion>> response) {
                Log.e("ok", response.body().toString());
                List<AndroidVersion> LatLngData = response.body();
                //Log.v(TAG, "LOGS" + LatLngData.size());
                ArrayList<AndroidVersion> list = new ArrayList<AndroidVersion>();
                for (int i = 0; i < LatLngData.size(); i++) {
                    String userId = LatLngData.get(i).getUserId();
                    String id = LatLngData.get(i).getId();
                    String title = LatLngData.get(i).getTitle();
                    String body = LatLngData.get(i).getBody();

                    list.add(new AndroidVersion(userId, id, title, body));
                }
                Log.d("chk", String.valueOf(list));
                DataAdapter dataAdapter=new DataAdapter(con,list);
                recyclerView.setAdapter(dataAdapter);

            }

            @Override
            public void onFailure(Call<List<AndroidVersion>> call, Throwable t) {

            }


        });
    }
}
