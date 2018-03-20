package mz.co.hossiman.perfectbullet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import mz.co.hossiman.perfectbullet.model.Cliente;
import mz.co.hossiman.perfectbullet.model.Produto;
import mz.co.hossiman.perfectbullet.model.SelectCount;

public class ItemVendaActivity extends AppCompatActivity {

    List<Produto> lstProduto;
    float totalPagar = 0;

    TextView tvTotalPagar;
    BottomBar bbItemVenda;
    RecyclerView mRecycler;
    RecyclerViewAdapterItemVenda mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_venda);

        initComponent();
        setDefaultValue();
        btnOnClick();

    }

    private void btnOnClick() {

        bbItemVenda.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {

                switch (tabId) {
                    case R.id.tab_confirmar:
                        scanQRCode();
                        break;
                }

            }
        });

    }

    private void scanQRCode() {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Camera Scan");
        integrator.setCameraId(0);
        integrator.initiateScan();
    }

    private void confirmarPagamento() {
        int i = 0;
        for (SelectCount sc : DB.lstSelectCount) {
            if (sc.getCount() != 0) {
                int quantidadeNova = DB.lstProduto.get(i).getQuantidade() - sc.getCount();
                DB.lstProduto.get(i).setQuantidade(quantidadeNova);
            }
            i++;
        }
        DB.lstSelectCount.clear();
        lstProduto.clear();
        Intent IntentMain = new Intent(ItemVendaActivity.this, MainActivity.class);
        startActivity(IntentMain);
        finish();
    }

    private void setDefaultValue() {

        int i = 0, j=0;
        for (SelectCount sc : DB.lstSelectCount) {
            if (sc.getCount() != 0) {
                lstProduto.add(new Produto(DB.lstProduto.get(i).getNome(),DB.lstProduto.get(i).getCategoria(),
                        DB.lstProduto.get(i).getMarca(),DB.lstProduto.get(i).getTipo(),DB.lstProduto.get(i).getPreco(),
                        DB.lstProduto.get(i).getValorCompra(),DB.lstProduto.get(i).getQuantidade(),DB.lstProduto.get(i).getThumbnail(),
                        DB.lstProduto.get(i).getFornecedor(),DB.lstProduto.get(i).getUtilizador()));
                lstProduto.get(j).setQuantidade(sc.getCount());
                totalPagar += lstProduto.get(j).getPreco() * lstProduto.get(j).getQuantidade();
                j++;
            }
            i++;
        }

        tvTotalPagar.setText(totalPagar+"");

        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setAdapter(mAdapter);

        bbItemVenda.setDefaultTab(R.id.tab_actualizar);

    }

    private void initComponent() {

        lstProduto = new ArrayList<>();
        tvTotalPagar = (TextView) findViewById(R.id.tvTotalPagarId);
        mRecycler = (RecyclerView) findViewById(R.id.recyclerview_item_venda_id);
        mAdapter = new RecyclerViewAdapterItemVenda(this,lstProduto);
        bbItemVenda = (BottomBar) findViewById(R.id.bb_item_venda_id);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if (result != null) {

            if (result.getContents() != null) {

                int i = 0;
                int pos = -1;
                for (Cliente c : DB.lstCliente) {

                    if (c.getNome().equalsIgnoreCase(result.getContents())) {

                        pos = i;

                    }

                }

                if (pos > -1) {
                    float saldo = DB.lstCliente.get(pos).getSaldo();
                    if (saldo >= totalPagar) {
                        DB.lstCliente.get(i).debitarPagamento(totalPagar);
                        confirmarPagamento();
                    } else {
                        alert("Saldo Insuficiente: Tens:"+saldo+" Para Pagar: "+totalPagar);
                    }
                } else {
                    alert("Cliente Nao Existe");
                }

            }

        } else {

            super.onActivityResult(requestCode, resultCode, data);

        }
    }

    private void alert(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    private void resetLst() {
        for (SelectCount sc : DB.lstSelectCount) {
            sc.setCount(0);
        }
    }

    @Override
    public void onBackPressed() {
        resetLst();
        super.onBackPressed();
    }
}
