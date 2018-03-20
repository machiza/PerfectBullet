package mz.co.hossiman.perfectbullet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import mz.co.hossiman.perfectbullet.model.Cliente;

public class ClienteActivity extends AppCompatActivity {

    ImageView ivQRCode;
    EditText edtSaldo;
    Button btnConfrimar;

    String nome = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        initComponentes();
        btnClick();
    }

    private void btnClick() {

        ivQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanQRCode();
            }
        });

        btnConfrimar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                verifica();
                reset();

            }
        });

    }

    private void reset() {
        nome = "";
        edtSaldo.setText("");
    }

    private void verifica() {
        for (Cliente c : DB.lstCliente) {

            if (c.getNome().equalsIgnoreCase(nome)) {
                c.deposito(Float.parseFloat(edtSaldo.getText().toString()));
                alert("Deposito: "+nome+" "+c.getSaldo());
                return;
            }

        }

        addClient();
    }

    private void addClient() {
        float saldo = Float.parseFloat(edtSaldo.getText().toString());
        DB.lstCliente.add(new Cliente(nome,saldo));
        alert(nome+" "+saldo);
    }

    private void scanQRCode() {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Camera Scan");
        integrator.setCameraId(0);
        integrator.initiateScan();
    }

    private void initComponentes() {

        ivQRCode = (ImageView) findViewById(R.id.ivQRCodeClienteId);
        edtSaldo = (EditText) findViewById(R.id.edtSaldoClienteId);
        btnConfrimar = (Button) findViewById(R.id.btnConfirmarClienteId);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if (result != null) {

            if (result.getContents() != null) {

                nome = result.getContents();

            } else {
                alert("Scan Cancelado");
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void alert(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
