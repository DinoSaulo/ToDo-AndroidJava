package com.example.todoapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Button click;
    public static TextView data;
    String bil = "bilada";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button) findViewById(R.id.button);
        data = (TextView) findViewById(R.id.fetcheddata);

        fetchData process = new fetchData();
        process.execute();

        String todos[][] = process.getToDo2();

        click.setOnClickListener( new View.OnClickListener(){
           @Override
           public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, SearchActivity.class);
                intent.putExtra("string", bil);
                startActivity(intent);
                finish();
           }
        });
    }


}
