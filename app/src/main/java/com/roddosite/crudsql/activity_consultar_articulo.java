package com.roddosite.crudsql;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.health.SystemHealthManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.roddosite.crudsql.utilidades.Utilidades;

public class activity_consultar_articulo extends AppCompatActivity {
    EditText campoId, campoDescripcion, campoPrecio;

    ConexionSQLiteHelper conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_articulo);

        conn = new ConexionSQLiteHelper(getApplicationContext(),"bd_articulos", null,1);

        campoId = (EditText) findViewById(R.id.consulta_id);
        campoDescripcion = (EditText) findViewById(R.id.consulta_descripcion);
        campoPrecio = (EditText) findViewById(R.id.consulta_precio);

    }


    public void onClick(View view) {

        if(!campoId.getText().toString().equals("") || !campoPrecio.getText().toString().equals("") || !campoPrecio.getText().toString().equals("")){
            switch (view.getId()){
                case R.id.Buscar_consulta:
                    consultar();
                    break;
                case R.id.consulta_update:
                    actualizarArticulo();
                    break;
                case R.id.consulta_btnEliminar:
                    eliminarArticulo();
                    break;
            }
        }else
            Toast.makeText(this,"Debe llenar los campos",Toast.LENGTH_SHORT).show();

    }

    private void eliminarArticulo() {
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {campoId.getText().toString()};

        db.delete(Utilidades.TABLA_ARTICULO,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Eliminado",Toast.LENGTH_SHORT).show();
        limpiar();
        db.close();
    }

    private void actualizarArticulo() {
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {campoId.getText().toString()};
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_DESCRIPCION,campoDescripcion.getText().toString());
        values.put(Utilidades.CAMPO_PRECIO,campoPrecio.getText().toString());

        db.update(Utilidades.TABLA_ARTICULO,values,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Actualizado",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void consultar() {
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {campoId.getText().toString()};
        String[] campos = {Utilidades.CAMPO_DESCRIPCION,Utilidades.CAMPO_PRECIO};

        try{
            Cursor cursor = db.query(Utilidades.TABLA_ARTICULO,campos,Utilidades.CAMPO_ID+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            campoDescripcion.setText(cursor.getString(0));
            campoPrecio.setText(cursor.getString(1));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_SHORT).show();
            System.out.println("Error   "+e.getMessage());
            limpiar();
        }




    }

    private void limpiar() {
        campoDescripcion.setText("");
        campoPrecio.setText("");
        campoId.setText("");
    }


}
