package br.edu.iff.pooa20152.ssl_suplementos.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

import br.edu.iff.pooa20152.ssl_suplementos.R;
import br.edu.iff.pooa20152.ssl_suplementos.domain.Cliente;
import br.edu.iff.pooa20152.ssl_suplementos.domain.ClienteService;
import br.edu.iff.pooa20152.ssl_suplementos.helper.RestFullHelper;

public class CadastroActivity extends AppCompatActivity {

    private EditText edCodigoCliente;
    private EditText edNome;
    private EditText edEndereco;
    private EditText edTelefone;
    private EditText edEmail;

    private final String TAG = "MAIN";

    private Button btConfirmar;
    private Button btMostrar;
    private Button btCancelar;
    private Button btLimpar;
    private String durl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

        edCodigoCliente = (EditText) findViewById(R.id.edCodigoCliente);
        edNome = (EditText) findViewById(R.id.edNome);
        edEndereco = (EditText) findViewById(R.id.edEndereco);
        edTelefone = (EditText) findViewById(R.id.edTelefone);
        edEmail = (EditText) findViewById(R.id.edEmail);
        durl = getString(R.string.URL);

        btLimpar = (Button) findViewById(R.id.btLimpar);
        btLimpar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                limpar();
            }
        });

        btMostrar = (Button) findViewById(R.id.btMostrar);
        btMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filtro = edCodigoCliente.getText().toString();
                if (!filtro.equalsIgnoreCase("")) {
                    getInformationtoAPI();
                }
            }
        });

        btConfirmar = (Button) findViewById(R.id.btConfirmar);
        btConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edCodigoCliente.getText().toString()))
                    postInformationtoAPI();
                else
                    putInformationtoAPI();
            }
        });

        btCancelar = (Button) findViewById(R.id.btCancelar);
        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletarInformationtoAPI();
            }
        });
    }

    private void limpar() {
        edCodigoCliente.setText("");
        edNome.setText("");
        edEndereco.setText("");
        edTelefone.setText("");
        edEmail.setText("");
    }

    private void deletarInformationtoAPI() {

        Log.i(TAG, "Deletar ORDER");

        JSONObject params = null;

        ClienteTask bgtDel = new ClienteTask(
                durl + "/clientes",
                edCodigoCliente.getText().toString(),
                RestFullHelper.DELETAR, params);
        bgtDel.execute();
        limpar();
    }

    private void getInformationtoAPI() {

        JSONObject params = null;

        ClienteTask bgtGet = new ClienteTask(
                durl + "/clientes",
                edCodigoCliente.getText().toString(),
                RestFullHelper.GET, params);

        bgtGet.execute();
    }

    private void postInformationtoAPI() {

        Log.d(TAG, "POSTING ORDER");

        JSONObject params = new JSONObject();

        try {
            params.put("nome", edNome.getText().toString());
            params.put("endereco", edEndereco.getText().toString());
            params.put("telefone", edTelefone.getText().toString());
            params.put("email", edEmail.getText().toString());

        } catch (JSONException e) {

            e.printStackTrace();
        }

        ClienteTask bgtPost = new ClienteTask(
                durl + "/clientes", null, RestFullHelper.POST, params);
        bgtPost.execute();

    }

    private void putInformationtoAPI() {

        Log.i(TAG, "PUT ORDER");

        JSONObject params = new JSONObject();

        try {
            params.put("id", edCodigoCliente.getText().toString());
            params.put("nome", edNome.getText().toString());
            params.put("endereco", edEndereco.getText().toString());
            params.put("telefone", edTelefone.getText().toString());
            params.put("email", edEmail.getText().toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ClienteTask bgtPut = new ClienteTask(
                durl + "/clientes", edCodigoCliente.getText().toString(),
                RestFullHelper.PUT, params);
        bgtPut.execute();
        limpar();

    }

    private Context getContext() {

        return this;
    }

    private void alert(String s) {

        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }


    public class ClienteTask extends AsyncTask<String, String, Cliente> {

        String url = null;
        String method = null;
        String id = null;
        JSONObject params1 = null;

        ProgressDialog dialog;

        public ClienteTask(String url, String id, String method, JSONObject params) {
            this.url = url;
            this.method = method;
            this.params1 = params;
            this.id = id;

        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(CadastroActivity.this);
            dialog.show();
        }

        @Override
        protected void onPostExecute(Cliente jsonObject) {

            if (jsonObject != null)
                edCodigoCliente.setText(jsonObject.getId().toString());
                edNome.setText(jsonObject.getNome());
                edEndereco.setText(jsonObject.getEndereco());
                edTelefone.setText(jsonObject.getTelefone());
                edEmail.setText(jsonObject.getEmail());

            dialog.dismiss();
        }

        @Override
        protected Cliente doInBackground(String... params) {

            ClienteService clienteService = new ClienteService(url, id, method, params1);

            Cliente cliente = clienteService.execute();

            return cliente;

        }
    }
}
