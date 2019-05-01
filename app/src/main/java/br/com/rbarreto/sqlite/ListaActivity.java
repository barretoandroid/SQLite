
package br.com.rbarreto.sqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import br.com.rbarreto.sqlite.database.ControlaBanco;

public class ListaActivity extends AppCompatActivity {
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        ControlaBanco crud = new ControlaBanco(getBaseContext());
        Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[] {"_id", "titulo"};
        int[] idViews = new int[] {R.id.idLivro, R.id.nomeLivro};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(), R.layout.livros_layout,cursor,nomeCampos,idViews, 0);

        lista = findViewById(R.id.listView);
        lista.setAdapter(adaptador);
    }
}
