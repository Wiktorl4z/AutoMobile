package com.auto.l4z.automobile.test;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.auto.l4z.automobile.CustomerAdapter;
import com.auto.l4z.automobile.HttpConnector;
import com.auto.l4z.automobile.R;
import com.auto.l4z.automobile.pojo.Car;
import com.auto.l4z.automobile.pojo.MyWebService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    private static final String CLASS_TAG = "TestActivity";
    public static View.OnClickListener myOnClickListener;
    private MyWebService service;
    static List<Car> items;
    private static RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private static ArrayList<Car> data;
    private Button buttonChecker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_layout);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        service = HttpConnector.getService(MyWebService.class);

        buttonChecker = findViewById(R.id.search_button);
        buttonChecker.setOnClickListener(v -> {
            try {
                service.getData().enqueue(new Callback<List<Car>>() {
                    @Override
                    public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                        items = response.body();

                        adapter = new CustomerAdapter(items);
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<List<Car>> call, Throwable t) {
                        Log.d(CLASS_TAG, t.getLocalizedMessage());
                    }
                });
            } catch (Exception e) {
                Log.d(CLASS_TAG, e.toString());
            }
        });
    }
}