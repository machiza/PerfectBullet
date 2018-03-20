package mz.co.hossiman.perfectbullet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    public void btnTiketsOnClick(View view) {
        Intent clienteIntent = new Intent(AdminActivity.this, ClienteActivity.class);
        startActivity(clienteIntent);
    }

    public void btnStockOnClick(View view) {
        Intent stockIntent = new Intent(AdminActivity.this, StockActivity.class);
        startActivity(stockIntent);
    }

    public void btnAtenderOnClick(View view) {
        Intent mainIntent = new Intent(AdminActivity.this, MainActivity.class);
        startActivity(mainIntent);
    }

    public void btnOperacoesOnClick(View view) {
        Intent operacoesIntent = new Intent(AdminActivity.this, OperacoesActivity.class);
        startActivity(operacoesIntent);
    }
}
