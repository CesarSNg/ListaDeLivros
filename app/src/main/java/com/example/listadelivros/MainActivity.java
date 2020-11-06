package com.example.listadelivros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String nomeLivros[] = {"AGDCjan", "AGDCfev", "AGDCmar", "AGDCabr",
            "AGDCmay", "AGDCjun", "AGDCjul", "AGDCago", "AGDCset", "AGDCout",
            "AGDCnov", "AGDCdez", "O cortico", "memorias Póstumas", "Vidas Secas",
            "Capitaes da areia", "Hora da estrela"};

    int imgLivros[] = {R.drawable.jan, R.drawable.fev,
            R.drawable.mar, R.drawable.abr, R.drawable.mai,
            R.drawable.jun, R.drawable.jul, R.drawable.ago,
            R.drawable.set, R.drawable.out, R.drawable.nov,
            R.drawable.dez, R.drawable.cortico, R.drawable.memorias,
            R.drawable.vida, R.drawable.capitaes, R.drawable.hora};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listaLivros);
        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),VisualizaLivro_MainActivity.class);
                intent.putExtra("nomeLivro",nomeLivros[i]);
                intent.putExtra("imagemLivro",imgLivros[i]);

                startActivity(intent);
            }
        });
    }
    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imgLivros.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView txtNomeLivro;
            ImageView imagemLivro;

            View carregaView = getLayoutInflater().inflate(R.layout.modelo_lista_livros, null);

            txtNomeLivro = carregaView.findViewById(R.id.txtListaLivro);
            imagemLivro = carregaView.findViewById(R.id.imgListaLivro);

            txtNomeLivro.setText(nomeLivros[i]);
            imagemLivro.setImageResource(imgLivros[i]);

            return carregaView;
        }
    }
}