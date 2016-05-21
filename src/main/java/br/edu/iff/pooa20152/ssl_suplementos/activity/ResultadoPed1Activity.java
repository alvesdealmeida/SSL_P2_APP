package br.edu.iff.pooa20152.ssl_suplementos.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.iff.pooa20152.ssl_suplementos.R;

public class ResultadoPed1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_ped1);
        Toast t = Toast.makeText(this, "Pedido Realizado com Sucesso!", Toast.LENGTH_LONG);
        t.show();


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String qtd1 = bundle.getString("qtd1");
        String prod1 = bundle.getString("prod1");
        String qtd2 = bundle.getString("qtd2");
        String prod2 = bundle.getString("prod2");
        String qtd3 = bundle.getString("qtd3");
        String prod3 = bundle.getString("prod3");
        String qtdFinal = bundle.getString("qtdFinal");

        TextView textQTD1 = (TextView) findViewById(R.id.textQTD1);
        TextView txtNomeProd = (TextView) findViewById(R.id.txtNomeProd);

        TextView textQTD2 = (TextView) findViewById(R.id.textQTD2);
        TextView txtNomeProd2 = (TextView) findViewById(R.id.txtNomeProd2);

        TextView textQTD3 = (TextView) findViewById(R.id.textQTD3);
        TextView txtNomeProd3 = (TextView) findViewById(R.id.txtNomeProd3);

        TextView txtQtdFinal = (TextView) findViewById(R.id.txtQtdFinal);

        textQTD1.setText(qtd1);
        txtNomeProd.setText(prod1);

        textQTD2.setText(qtd2);
        txtNomeProd2.setText(prod2);

        textQTD3.setText(qtd3);
        txtNomeProd3.setText(prod3);

        txtQtdFinal.setText(qtdFinal);

    }
    public void retornaMenu(View v) {
        startActivity(new Intent(this, MenuActivity.class));
        finish();


    }
}

