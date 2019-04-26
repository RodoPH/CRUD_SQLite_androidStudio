package com.roddosite.crudsql;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.roddosite.crudsql.utilidades.Utilidades;

public class RegistroUsuarioActivity extends AppCompatActivity {
    EditText campoId, campoDescripcion, campoPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        campoId = (EditText) findViewById(R.id.id_articulo);
        campoDescripcion = (EditText) findViewById(R.id.des_articulo);
        campoPrecio = (EditText) findViewById(R.id.precio_articulo);
    }

    public void onClick(View view) {
        if(!campoId.getText().toString().equals("") && !campoDescripcion.getText().toString().equals("") && !campoPrecio.getText().toString().equals("")){
            registrarArticulos();
        }else{
            Toast.makeText(getApplicationContext(),"Debe llenar los campos requeridos.",Toast.LENGTH_SHORT).show();
        }

    }


    public void registrarArticulos() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_articulos", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID, campoId.getText().toString());
        values.put(Utilidades.CAMPO_DESCRIPCION, campoDescripcion.getText().toString());
        values.put(Utilidades.CAMPO_PRECIO, campoPrecio.getText().toString());

        Long idResultado = db.insert(Utilidades.TABLA_ARTICULO, Utilidades.CAMPO_ID, values);

        Toast.makeText(getApplicationContext(), "Id registro: " + idResultado, Toast.LENGTH_SHORT).show();
        db.close();
        limpiarCampos();
        finish();
    }

    private void limpiarCampos() {
        campoId.setText("");
        campoPrecio.setText("");
        campoDescripcion.setText("");
    }

}
