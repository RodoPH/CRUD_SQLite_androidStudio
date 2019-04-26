package com.roddosite.crudsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_articulos", null, 1);

    }

    public void onClick(View view) {
        Intent intent = null;

        switch (view.getId()) {
            case R.id.main_agregar:
                intent = new Intent(MainActivity.this, RegistroUsuarioActivity.class);
                break;
            case R.id.consultar:
                intent = new Intent(MainActivity.this, activity_consultar_articulo.class);
                break;

        }
        if (intent != null) {
            startActivity(intent);
        }
    }

}
