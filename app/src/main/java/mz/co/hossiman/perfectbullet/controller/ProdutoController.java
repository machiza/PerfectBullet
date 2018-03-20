package mz.co.hossiman.perfectbullet.controller;

import java.util.ArrayList;
import java.util.List;

import mz.co.hossiman.perfectbullet.DB;
import mz.co.hossiman.perfectbullet.model.Produto;

/**
 * Created by secreto on 3/8/18.
 */

public class ProdutoController {

    private List<Produto> lstProduto;

    public ProdutoController() {
//        lstProduto = DB.lstProduto;
    }

    void save(Produto produto) {
        lstProduto.add(produto);
    }

    List<Produto> getLstProduto() {
        return lstProduto;
    }


}
