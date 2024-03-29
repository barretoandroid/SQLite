package br.com.rbarreto.sqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ControlaBanco {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public ControlaBanco(Context context) {
        banco = new CriaBanco(context);
    }

    public String insereDado(String titulo, String autor, String editora){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("titulo", titulo);
        valores.put("autor", autor);
        valores.put("editora", editora);

        resultado = db.insert("livro", null, valores);
        db.close();

        if (resultado == -1){
            return "Erro ao inserir dado";
        }
        else {
            return "Dado inserido com sucesso";
        }

    }

    public Cursor carregaDados(){
        Cursor cursor;
        String [] campos = {"_id", "titulo"};
        db = banco.getReadableDatabase();
        cursor = db.query("livro", campos, null, null, null, null, null);

        if (cursor !=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
