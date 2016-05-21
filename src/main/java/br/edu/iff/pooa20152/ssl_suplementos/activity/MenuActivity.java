package br.edu.iff.pooa20152.ssl_suplementos.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.edu.iff.pooa20152.ssl_suplementos.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void telaCadastro(View v){
        startActivity(new Intent(this, CadastroActivity.class));


    }
    public void telaCadastro2(View v){
        startActivity(new Intent(this, CadastrarActivity.class));
    }


    public void telaProduto(View v){
        startActivity(new Intent(this, ProdutoActivity.class));



    }
    public void telaPedido(View v){
        startActivity(new Intent(this, PedidoActivity.class));

    }
    public void rtnPolitica(View v){
        startActivity(new Intent(this, PoliticaActivity.class));
    }

}
