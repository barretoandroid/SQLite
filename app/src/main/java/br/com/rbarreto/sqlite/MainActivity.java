package br.com.rbarreto.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.com.rbarreto.sqlite.database.ControlaBanco;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insere(View view){
        ControlaBanco crud = new ControlaBanco(getBaseContext());
        EditText edTitulo = findViewById(R.id.txtNome);
        EditText edAutor = findViewById(R.id.txtAutor);
        EditText edEditora = findViewById(R.id.txtEditora);
        TextView tvResultado = findViewById(R.id.tvResultado);

        String titulo = edTitulo.getText().toString();
        String autor = edAutor.getText().toString();
        String editora = edEditora.getText().toString();

        String resultado = crud.insereDado(titulo, autor, editora);
        tvResultado.setText(resultado);

        Intent intent = new Intent(this, ListaActivity.class);
        startActivity(intent);
    }

}
