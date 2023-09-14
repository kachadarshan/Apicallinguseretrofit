package com.qubitsolutionlab.demo_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    Adapter adapter;
    List<ResponseObject> alluser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.main_recyc);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofitinstance.getinstance().api.getuser().enqueue(new Callback<List<ResponseObject>>() {
            @Override
            public void onResponse(Call<List<ResponseObject>> call, Response<List<ResponseObject>> response) {
                alluser = response.body();
                recyclerView.setAdapter(new Adapter(alluser));

            }

            @Override
            public void onFailure(Call<List<ResponseObject>> call, Throwable t) {
                Log.d("api", t.getLocalizedMessage());
            }
        });


    }


}