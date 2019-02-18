package com.example.todoapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;



public class SearchActivity extends AppCompatActivity {

    public static TextView findedTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        findedTodo = (TextView) findViewById(R.id.searchedTitle);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String title = bundle.getString("title");

        findedTodo.setText(title);

        /* Devido ao tempo não consegui implementar o algorítimo para buscar a To_do pelo seu título, mas faria isto da seguinte forma
           Como armazenei todos os dados da API em uma matriz, passaria esta matriz para esta activity juntamente com o título buscado
           então na activiti varreria toda a segunda coluna da matriz e caso encontrasse algum titulo igual ao buscado armazenaria ele em uma lista
           ao final exibiria todos os TODOs encontrados na TextView findedTodo, caso não encontrasse nenhuma similar repassaria uma notificação de que não foi encontrado nenhuma to_do para o usuário.
        */
    }

}
