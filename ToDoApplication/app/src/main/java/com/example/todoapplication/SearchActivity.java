package com.example.todoapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class SearchActivity extends AppCompatActivity {

    TextView data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    //data2 = (TextView) findViewById(R.id.fetcheddata2);

    fetchData process2 = new fetchData();
    //process2.execute();
    //todos
}
