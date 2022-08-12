package com.example.when_where_whatv3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener, View.OnClickListener {

//    private URI GsonConvertorFactory;

    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    ProgressDialog dialog;
    Button b1,b2,b3,b4,b5,b6,b7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);
        dialog.setTitle("News loading!");
        dialog.show();

        b1 = (Button) findViewById(R.id.btn1);
        b1.setOnClickListener(this);

        b2 = (Button) findViewById(R.id.btn2);
        b2.setOnClickListener(this);

        b3 = (Button) findViewById(R.id.btn3);
        b3.setOnClickListener(this);

        b4 = (Button) findViewById(R.id.btn4);
        b4.setOnClickListener(this);

        b5 = (Button) findViewById(R.id.btn5);
        b5.setOnClickListener(this);

        b6 = (Button) findViewById(R.id.btn6);
        b6.setOnClickListener(this);

        b7 = (Button) findViewById(R.id.btn7);
        b7.setOnClickListener(this);

//        b1.findViewById(R.id.btn1);
//        b1.setOnClickListener(this);
//
//        b2.findViewById(R.id.btn2);
//        b2.setOnClickListener(this);
//
//        b3.findViewById(R.id.btn3);
//        b3.setOnClickListener(this);
//
//        b4.findViewById(R.id.btn4);
//        b4.setOnClickListener(this);
//
//        b5.findViewById(R.id.btn5);
//        b5.setOnClickListener(this);
//
//        b6.findViewById(R.id.btn6);
//        b6.setOnClickListener(this);
//
//        b7.findViewById(R.id.btn7);
//        b7.setOnClickListener(this);


        RequestCall requestCall = new RequestCall(this);
        requestCall.getNewsHeadlines(listener, "general", null);


    }

    private final DataListener<ApiResponse> listener = new DataListener<ApiResponse>() {
        @Override
        public void onFetchData(List<Headlines> lst, String message) {
            displayNews(lst);
            dialog.dismiss();


        }

        @Override
        public void onError(String message) {

        }
    };

    private void displayNews(List<Headlines> lst) {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        customAdapter = new CustomAdapter(this, lst, this);
        recyclerView.setAdapter(customAdapter);


    }

    @Override
    public void newsClicked(Headlines headlines) {
        startActivity(new Intent(MainActivity.this , detailedActivity.class).putExtra("data" , headlines));

    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String category = button.getText().toString();
//        String category = "entertainment";
        dialog.setTitle("News loading of " + category);
        dialog.show();
        RequestCall call = new RequestCall(this);
        call.getNewsHeadlines(listener , category, null);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_layout, menu);
//        MenuItem item = menu.findItem(R.id.spinner);
//        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
////        SpinnerAdapter adapter;
//        List<String> spinnerArray =  new ArrayList<String>();
//        spinnerArray.add("item1");
//        spinnerArray.add("item2");
//
//        spinner.setAdapter(spinnerArray); // set the adapter to provide layout of rows and content
//        spinner.setOnItemSelectedListener(onItemSelectedListener); // set the listener, to perform actions based on item selection


}