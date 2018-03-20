package mz.co.hossiman.perfectbullet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import mz.co.hossiman.perfectbullet.model.Cliente;
import mz.co.hossiman.perfectbullet.model.Produto;
import mz.co.hossiman.perfectbullet.model.SelectCount;

public class MainActivity extends AppCompatActivity {

    List<Produto> lstProduto, lstProdutos, lstProdutoRefrigerante, lstProdutoSeca, lstProdutoCerveja;
    RecyclerViewAdapterAtender mAdapter, mAdapterRefrigerante, mAdapterCerveja, mAdapterSeca;
    RecyclerView mRecycler;
    BottomBar bottomBar, bottomBar1;
    View b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();

        initComponent();

        filtro();

        createAdapter();

        btnOnClick();

    }

    private void initList() {
        lstProduto = DB.lstProduto;
        lstProdutos= new ArrayList<>();
        lstProdutoRefrigerante = new ArrayList<>();
        lstProdutoCerveja = new ArrayList<>();
        lstProdutoSeca = new ArrayList<>();
    }

    private void initComponent() {
        b = findViewById(R.id.tab_limpar);
        bottomBar = (BottomBar) findViewById(R.id.bottomBar2);
        bottomBar1 = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar1.setDefaultTab(R.id.tab_limpar);
    }

    public void filtro() {

        for (Produto produto : lstProduto) {
            DB.lstSelectCount.add(new SelectCount(produto.getThumbnail(),0));
            if (produto.getCategoria().getNome().equalsIgnoreCase("All")) {
                lstProduto.add(produto);
            }else if (produto.getCategoria().getNome().equalsIgnoreCase("Refrigerantes")) {
                lstProdutoRefrigerante.add(produto);
            }else if (produto.getCategoria().getNome().equalsIgnoreCase("Cervejas")) {
                lstProdutoCerveja.add(produto);
            }else if (produto.getCategoria().getNome().equalsIgnoreCase("Secas")) {
                lstProdutoSeca.add(produto);
            }
        }
    }

    private void createAdapter() {
        mAdapter = new RecyclerViewAdapterAtender(this, lstProduto, b);
        mAdapterRefrigerante = new RecyclerViewAdapterAtender(this, lstProdutoRefrigerante, b);
        mAdapterSeca = new RecyclerViewAdapterAtender(this, lstProdutoSeca, b);
        mAdapterCerveja = new RecyclerViewAdapterAtender(this, lstProdutoCerveja, b);
        mRecycler = (RecyclerView) findViewById(R.id.recyclerview_atender_id);
        mRecycler.setLayoutManager(new GridLayoutManager(this, 3));
        mRecycler.setAdapter(mAdapter);
    }

    private void btnOnClick() {

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                switch (tabId) {
                    case R.id.tab_all: mRecycler.setAdapter(mAdapter); break;
                    case R.id.tab_refrigerantes: mRecycler.setAdapter(mAdapterRefrigerante); break;
                    case R.id.tab_cerveja: mRecycler.setAdapter(mAdapterCerveja); break;
                    case R.id.tab_garafa: mRecycler.setAdapter(mAdapterSeca); break;
                }
            }
        });

//        View oldTab = bottomBar1.getTabWithId(R.id.tab_limpar);
//        if(oldTab != null)
//            oldTab.setVisibility(View.INVISIBLE);
//
//        bottomBar1.setDefaultTab(R.id.tab_limpar);
//            if (DB.lstSelectCount == null) {
//                oldTab.setVisibility(View.GONE);
//            }
        b.setVisibility(View.GONE);
        bottomBar1.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                bottomBarClick(tabId);
            }
        });

        bottomBar1.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(int tabId) {
                bottomBarClick(tabId);
            }
        });

    }

    private void bottomBarClick(int tabId) {

        switch (tabId) {

            case R.id.tab_pesquisa_cliente:
                scanQRCode();
                break;

            case R.id.tab_pagamento:
                Intent intentItemVenda = new Intent(MainActivity.this, ItemVendaActivity.class);
                startActivity(intentItemVenda);
                break;

            case R.id.tab_limpar:
                resetLst();
                switch (bottomBar.getCurrentTabId()) {
                    case R.id.tab_all: mRecycler.setAdapter(mAdapter); break;
                    case R.id.tab_refrigerantes: mRecycler.setAdapter(mAdapterRefrigerante); break;
                    case R.id.tab_cerveja: mRecycler.setAdapter(mAdapterCerveja); break;
                    case R.id.tab_garafa: mRecycler.setAdapter(mAdapterSeca); break;
                }
                b.setVisibility(View.GONE);
                break;

            case R.id.tab_sair:
                DB.lstSelectCount.clear();
                Intent intentAdmin = new Intent(MainActivity.this, AdminActivity.class);
                startActivity(intentAdmin);
                break;

        }

    }

    private void resetLst() {
        for (SelectCount sc : DB.lstSelectCount) {
            sc.setCount(0);
        }
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

            int i = 0;
            for (Cliente c : DB.lstCliente) {

                if (c.getNome().equalsIgnoreCase(result.getContents())) {

                    alert(c.getNome()+" "+c.getSaldo());

                }

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
        DB.lstSelectCount.clear();
    }
}
