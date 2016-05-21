package br.edu.iff.pooa20152.ssl_suplementos.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.edu.iff.pooa20152.ssl_suplementos.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast t = Toast.makeText(this,"Ola! Bem Vindo a SSL-Suplementos", Toast.LENGTH_LONG);
        t.show();

    }
    public void chamaMenu(View v){
        startActivity(new Intent(this, MenuActivity.class));
        finish();

    }

}

