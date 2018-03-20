package mz.co.hossiman.perfectbullet;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import mz.co.hossiman.perfectbullet.model.Produto;

public class StockActivity extends AppCompatActivity {

    List<Produto> lstProduto, lstProdutoRefrigerante, lstProdutoSeca, lstProdutoCerveja;

    RecyclerViewAdapter mAdapter, mAdapterRefrigerante, mAdapterSeca, mAdapterCerveja;
    RecyclerView mRecycler;
    BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        initLst();
        initComponent();
        filtro();
        btnOnClick();

        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setAdapter(mAdapter);


//        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
//            @Override
//            public void onTabSelected(@IdRes int tabId) {
//                if ("All".equalsIgnoreCase(TabMessage.get(tabId,false))) {
//                    mRecycler.setAdapter(mAdapter);
//                } else if ("Refrigerantes".equalsIgnoreCase(TabMessage.get(tabId,false))) {
//                    mRecycler.setAdapter(mAdapterRefrigerante);
//                } else if ("Cervejas".equalsIgnoreCase(TabMessage.get(tabId, false))) {
//                    mRecycler.setAdapter(mAdapterCerveja);
//                } else if ("Secas".equalsIgnoreCase(TabMessage.get(tabId, false))) {
//                    mRecycler.setAdapter(mAdapterSeca);
//                }
//            }
//        });
    }

    private void btnOnClick() {

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                switch (tabId) {

                    case R.id.tab_all: lstProduto: mRecycler.setAdapter(mAdapter); break;
                    case R.id.tab_refrigerantes: mRecycler.setAdapter(mAdapterRefrigerante); break;
                    case R.id.tab_cerveja: mRecycler.setAdapter(mAdapterCerveja); break;
                    case R.id.tab_garafa: mRecycler.setAdapter(mAdapterSeca); break;

                }
            }
        });
    }

    private void filtro() {

        for (Produto produto : lstProduto) {
            if (produto.getCategoria().getNome().equalsIgnoreCase("Refrigerantes")) {
                lstProdutoRefrigerante.add(produto);
            } else if (produto.getCategoria().getNome().equalsIgnoreCase("Cervejas")) {
                lstProdutoCerveja.add(produto);
            } else if (produto.getCategoria().getNome().equalsIgnoreCase("Secas")){
                lstProdutoSeca.add(produto);
            }
        }

    }

    private void initComponent() {

        bottomBar = (BottomBar) findViewById(R.id.menu_bar);
        mAdapter = new RecyclerViewAdapter(this, lstProduto);
        mAdapterRefrigerante = new RecyclerViewAdapter(this, lstProdutoRefrigerante);
        mAdapterSeca = new RecyclerViewAdapter(this, lstProdutoSeca);
        mAdapterCerveja = new RecyclerViewAdapter(this, lstProdutoCerveja);
        mRecycler = (RecyclerView) findViewById(R.id.recyclerview_stock_id);

    }

    private void initLst() {
        lstProduto = DB.lstProduto;
        lstProdutoRefrigerante = new ArrayList<>();
        lstProdutoCerveja = new ArrayList<>();
        lstProdutoSeca = new ArrayList<>();
    }

    private void initSpinner() {

    }
}
