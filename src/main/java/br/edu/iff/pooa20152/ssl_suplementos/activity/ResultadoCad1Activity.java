package br.edu.iff.pooa20152.ssl_suplementos.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.iff.pooa20152.ssl_suplementos.R;

public class ResultadoCad1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_cad1);

        Toast t = Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG);
        t.show();

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String txt = bundle.getString("txt");
        String end = bundle.getString("end");
        String tel = bundle.getString("tel");
        String emi = bundle.getString("emi");

        TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
        TextView endResultado = (TextView) findViewById(R.id.endResultado);
        TextView telResultado = (TextView) findViewById(R.id.telResultado);
        TextView emResultado = (TextView) findViewById(R.id.emResultado);

        txtResultado.setText(txt);
        endResultado.setText(end);
        telResultado.setText(tel);
        emResultado.setText(emi);

    }

    public void voltaMenu(View v) {
        startActivity(new Intent(this, MenuActivity.class));
        finish();


    }


}
