package br.edu.iff.pooa20152.ssl_suplementos.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import br.edu.iff.pooa20152.ssl_suplementos.R;

public class ProdAcsWActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod_acs_w);

        Toast t = Toast.makeText(this,"Carregando Página SSL", Toast.LENGTH_LONG);
        t.show();


        WebView wa= (WebView) findViewById(R.id.pagSSL);
        WebSettings wsa = wa.getSettings();
        wsa.setJavaScriptEnabled(true);
        wsa.setSupportZoom(false);

        wa.loadUrl("http://sslsuplementoseace.wix.com/sslsuplementos");
    }
}
