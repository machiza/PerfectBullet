package mz.co.hossiman.perfectbullet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import mz.co.hossiman.perfectbullet.model.Utilizador;

public class WelcomeActivity extends AppCompatActivity {

    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void btnEntrarOnClick(View view) {

        scanQRCode();

    }

    private void scanQRCode() {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Camera Scan");
        integrator.setCameraId(0);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if (result != null) {

            if (result.getContents() != null) {
                alert(result.getContents());
                if (verifica(result.getContents())) {
                    Intent intentAdmin = new Intent(WelcomeActivity.this, AdminActivity.class);
                    startActivity(intentAdmin);
                } 
            } else {
                alert("Scan Cancelado");
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private boolean verifica(String password) {

        for (Utilizador u : DB.lstUtilizador) {
            if (u.getSenha().equalsIgnoreCase(password)) {
                return true;
            }
        }

        return false;

    }

    private void alert(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
