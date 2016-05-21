package br.edu.iff.pooa20152.ssl_suplementos.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import br.edu.iff.pooa20152.ssl_suplementos.R;

public class ProNacWActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_nac_w);
        Toast t = Toast.makeText(this,"Carregando Página SSL", Toast.LENGTH_LONG);
        t.show();

        WebView wv= (WebView) findViewById(R.id.paginaSSl);
        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setSupportZoom(false);

        wv.loadUrl("http://sslsuplementoseace.wix.com/sslsuplementos");
    }

}
