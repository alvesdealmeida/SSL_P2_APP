package br.edu.iff.pooa20152.ssl_suplementos.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import br.edu.iff.pooa20152.ssl_suplementos.R;

public class CadastrarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

        Button btEnviar = (Button) findViewById(R.id.btEnviar);
        btEnviar.setOnClickListener(oncli);
    }
    private View.OnClickListener oncli = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(CadastrarActivity.this, ResultadoMenActivity.class);

            EditText editNome = (EditText) findViewById(R.id.editNome);
            EditText editEmail = (EditText) findViewById(R.id.editEmail);
            EditText editAssunto = (EditText) findViewById(R.id.editAssunto);
            EditText editMss = (EditText) findViewById(R.id.editMss);

            String nom = "";
            nom = editNome.getText().toString();

            String emi ="";
            emi = editEmail.getText().toString();

            String ass="";
            ass = editAssunto.getText().toString();


            String mss="";
            mss = editMss.getText().toString();


            Bundle bundle = new Bundle();

            bundle.putString("nom", nom);
            bundle.putString("emi",emi);
            bundle.putString("ass",ass);
            bundle.putString("mss",mss);

            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }
    };

}
