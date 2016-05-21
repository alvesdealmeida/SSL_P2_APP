package br.edu.iff.pooa20152.ssl_suplementos.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.edu.iff.pooa20152.ssl_suplementos.R;

public class ProdutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);
    }


    public void prodNac(View v){
        startActivity(new Intent(this, ProNacWActivity.class));

    }
    public void prodImp(View v){
        startActivity(new Intent(this, ProdImWActivity.class));


    }
    public void prodAces(View v){
        startActivity(new Intent(this,ProdAcsWActivity.class));
    }

}
