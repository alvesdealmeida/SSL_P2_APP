package br.edu.iff.pooa20152.ssl_suplementos.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.edu.iff.pooa20152.ssl_suplementos.R;

public class PedidoActivity extends AppCompatActivity {
    private EditText textQTD1;
    private EditText textQTD2;
    private EditText textQTD3;
    private Button btCalcular;
    private TextView txtQtdFinal;
    private double qtd1;
    private double qtd2;
    private double qtd3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        Button btGerar = (Button) findViewById(R.id.btGerar);
        btGerar.setOnClickListener(oncli);

        textQTD1 = (EditText) findViewById(R.id.textQTD1);
        textQTD2 = (EditText) findViewById(R.id.textQTD2);
        textQTD3 = (EditText) findViewById(R.id.textQTD3);
        btCalcular = (Button) findViewById(R.id.btCalcular);
        txtQtdFinal = (TextView) findViewById(R.id.txtQtdFinal);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                qtd1 = Double.parseDouble(textQTD1.getText().toString());
                qtd2 = Double.parseDouble(textQTD2.getText().toString());
                qtd3 = Double.parseDouble(textQTD3.getText().toString());

                Double Qtde = calcularQuantidade(qtd1, qtd2, qtd3);
                txtQtdFinal.setText(Qtde.toString());
            }
        });

    }
    private double calcularQuantidade(double n1, double n2, double n3) {
        double qtdFinal = (n1 + n2 + n3);
        return  qtdFinal;
    }
    private View.OnClickListener oncli = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(PedidoActivity.this, ResultadoPed1Activity.class);
            EditText textQTD1 = (EditText) findViewById(R.id.textQTD1);
            EditText txtNomeProd = (EditText) findViewById(R.id.txtNomeProd);
            EditText textQTD2 = (EditText) findViewById(R.id.textQTD2);
            EditText txtNomeProd2 = (EditText) findViewById(R.id.txtNomeProd2);
            EditText textQTD3 = (EditText) findViewById(R.id.textQTD3);
            EditText txtNomeProd3 = (EditText) findViewById(R.id.txtNomeProd3);
            TextView txtQtdFinal = (TextView) findViewById(R.id.txtQtdFinal);

            String qtd1 = "";
            qtd1 = textQTD1.getText().toString();

            String prod1 ="";
            prod1 = txtNomeProd.getText().toString();

            String qtd2 ="";
            qtd2 = textQTD2.getText().toString();

            String prod2 ="";
            prod2 = txtNomeProd2.getText().toString();

            String qtd3 ="";
            qtd3 = textQTD3.getText().toString();

            String prod3 ="";
            prod3 = txtNomeProd3.getText().toString();

            String qtdFinal ="";
            qtdFinal = txtQtdFinal.getText().toString();



            Bundle bundle = new Bundle();
            bundle.putString("qtd1", qtd1);
            bundle.putString("prod1",prod1);
            bundle.putString("qtd2",qtd2);
            bundle.putString("prod2",prod2);
            bundle.putString("qtd3",qtd3);
            bundle.putString("prod3",prod3);
            bundle.putString("qtdFinal",qtdFinal);

            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }
    };

}


