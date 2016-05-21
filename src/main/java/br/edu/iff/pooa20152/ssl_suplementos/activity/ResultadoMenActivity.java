package br.edu.iff.pooa20152.ssl_suplementos.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.iff.pooa20152.ssl_suplementos.R;

public class ResultadoMenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_men);

        Toast t = Toast.makeText(this, "Mensagem enviada.Obrigado!", Toast.LENGTH_LONG);
        t.show();


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String nom = bundle.getString("nom");
        String emi = bundle.getString("emi");
        String ass = bundle.getString("ass");
        String mss = bundle.getString("mss");

        TextView eNome = (TextView) findViewById(R.id.eNome);
        TextView eEMail = (TextView) findViewById(R.id.eEmail);
        TextView eAssunto = (TextView) findViewById(R.id.eAssunto);
        TextView eMss = (TextView) findViewById(R.id.eMss);

        eNome.setText(nom);
        eEMail.setText(emi);
        eAssunto.setText(ass);
        eMss.setText(mss);

       // Intent sendIntent = new Intent();
       // sendIntent.setAction(Intent.ACTION_SEND);
       // sendIntent.putExtra(Intent.EXTRA_TEXT, "TESTE DO APLICATIVO SSL");
       // sendIntent.setType("text/plain");
        //sendIntent.setPackage("com.whatsapp");
       // startActivity(Intent.createChooser(sendIntent, ""));
    }
    public void bckMenu(View v) {
        startActivity(new Intent(this, MenuActivity.class));
        finish();



    }
}
