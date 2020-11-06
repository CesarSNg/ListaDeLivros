package com.example.listadelivros;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class VisualizaLivro_MainActivity extends AppCompatActivity {

    TextView txtLivros;
    ImageView imgLivros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visualiza_livro_layout);

        txtLivros = findViewById(R.id.mtxtLivro);
        imgLivros = findViewById(R.id.mimgLivro);

        Intent intent = getIntent();

        String nLivro = intent.getStringExtra("nomeLivro");
        int mLivro = intent.getIntExtra("imagemLivro",0);

        txtLivros.setText(nLivro);
        imgLivros.setImageResource(mLivro);
    }
}