package mz.co.hossiman.perfectbullet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import mz.co.hossiman.perfectbullet.model.Utilizador;

public class OperacoesActivity extends AppCompatActivity {

    EditText edtNome, edtTelemovel, edtEmail;
    ImageView ivQRCode;
    Button btnGravar;

    ImageView ivBackUserId;

    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacoes);

        initComponent();
        clickButton();
    }

    private void clickButton() {
        ivBackUserId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ivQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanQRCode();
            }
        });

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }

    private void salvar() {
        String nome = edtNome.getText().toString();
        int telemovel = Integer.parseInt(edtTelemovel.getText().toString());
        String email = edtEmail.getText().toString();

        if (!TextUtils.isEmpty(nome) && !TextUtils.isEmpty(telemovel+"") && !TextUtils.isEmpty(password)) {
            DB.lstUtilizador.add(new Utilizador(nome,telemovel,email,password,DB.lstFuncao.get(1)));
            reset();
            Toast.makeText(getApplicationContext(), "Success full...", Toast.LENGTH_SHORT).show();
        }
    }

    private void reset() {
        edtNome.setText("");
        edtTelemovel.setText("");
        edtEmail.setText("");
        password = "";
    }

    private void scanQRCode() {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Camera Scan");
        integrator.setCameraId(0);
        integrator.initiateScan();
    }

    private void initComponent() {
        edtNome = (EditText) findViewById(R.id.edtNomeUserId);
        edtTelemovel = (EditText) findViewById(R.id.edtTelemovelUserId);
        edtEmail = (EditText) findViewById(R.id.edtEmailUserId);
        ivQRCode = (ImageView) findViewById(R.id.ivQRCode);
        btnGravar = (Button) findViewById(R.id.btnGravarUserId);
        ivBackUserId = (ImageView) findViewById(R.id.ivBackUserId);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if (result != null) {

            if (result.getContents() != null) {
                alert(result.getContents());
                password = result.getContents();
            } else {
                alert("Scan Cancelado");
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }

    private void alert(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
