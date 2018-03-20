package mz.co.hossiman.perfectbullet;

import java.util.ArrayList;
import java.util.List;

import mz.co.hossiman.perfectbullet.model.Categoria;
import mz.co.hossiman.perfectbullet.model.Cliente;
import mz.co.hossiman.perfectbullet.model.Fornecedor;
import mz.co.hossiman.perfectbullet.model.Funcao;
import mz.co.hossiman.perfectbullet.model.Marca;
import mz.co.hossiman.perfectbullet.model.Produto;
import mz.co.hossiman.perfectbullet.model.SelectCount;
import mz.co.hossiman.perfectbullet.model.Utilizador;

/**
 * Created by secreto on 3/8/18.
 */

public class DB {

    public static List<Produto> lstProduto = new ArrayList<>();
    public static List<Categoria> lstCategoria = new ArrayList<>();
    public static List<Marca> lstMarca = new ArrayList<>();
    public static List<Fornecedor> lstFornecedor = new ArrayList<>();
    public static List<Funcao> lstFuncao = new ArrayList<>();
    public static List<Utilizador> lstUtilizador = new ArrayList<>();
    public static List<Cliente> lstCliente = new ArrayList<>();
    public static List<SelectCount> lstSelectCount = new ArrayList<>();
    public static List<String> lstTipo = new ArrayList<>();
    public static SelectCount[] listaConta = new SelectCount[lstProduto.size()];
    public static float totalPagar = 0;

    static {
        initCategoria();
        initMarca();
        initTipo();
        initFornecedor();
        initFuncao();
        initUtilizador();
        initProduto();
    }

    public static void initCategoria() {
        lstCategoria.add(new Categoria("Refrigerantes"));
        lstCategoria.add(new Categoria("Cervejas"));
        lstCategoria.add(new Categoria("Secas"));
    }

    public static void initMarca() {
        lstMarca.add(new Marca("Montemor"));
        lstMarca.add(new Marca("Ceres"));
        lstMarca.add(new Marca("Schweppes"));
        lstMarca.add(new Marca("Coca-Cola"));
        lstMarca.add(new Marca("Sprite"));
        lstMarca.add(new Marca("Red Bull"));
        lstMarca.add(new Marca("2M"));
        lstMarca.add(new Marca("Laurentina"));
        lstMarca.add(new Marca("Manica"));
        lstMarca.add(new Marca("Heineken"));
        lstMarca.add(new Marca("Super Bock"));
        lstMarca.add(new Marca("Olmeca"));
        lstMarca.add(new Marca("Tango"));
        lstMarca.add(new Marca("Absolut"));
        lstMarca.add(new Marca("Bombay"));
        lstMarca.add(new Marca("Tanqueray"));
        lstMarca.add(new Marca("Hendrick's"));
        lstMarca.add(new Marca("John Walker"));
    }

    public static void initTipo() {
        lstTipo.add("Garafa");
        lstTipo.add("Shot");
    }

    public static void initFornecedor() {
        lstFornecedor.add(new Fornecedor("Machiza","machiza@gmail.com",847777777,"Maputo"));
    }

    public static void initFuncao() {
        lstFuncao.add(new Funcao("Admin","Admistrador do sistemas"));
        lstFuncao.add(new Funcao("Staff","Saff, apenas para venda de produtos"));
    }

    public static void initUtilizador() {
        lstUtilizador.add(new Utilizador("Manuel Gomes",846262005,"manuelgomes@gmail.com","Manuel Gomes",lstFuncao.get(0)));
    }

    public static void initProduto() {
        lstProduto.add(new Produto("Agua",lstCategoria.get(0),lstMarca.get(0),lstTipo.get(0),100,20,48,R.drawable.agua_sem_gas,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("Sumo",lstCategoria.get(0),lstMarca.get(1),lstTipo.get(0),100,20,48,R.drawable.ceres,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("Ginger Ale",lstCategoria.get(0),lstMarca.get(2),lstTipo.get(0),100,20,48,R.drawable.ginger_ale,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("Dry Lemon",lstCategoria.get(0),lstMarca.get(2),lstTipo.get(0),100,20,48,R.drawable.dry_lemon,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("Agua Tonica",lstCategoria.get(0),lstMarca.get(2),lstTipo.get(0),100,20,48,R.drawable.schweppes_wonic_water,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("Coca-Cola",lstCategoria.get(0),lstMarca.get(3),lstTipo.get(0),100,20,48,R.drawable.coca_cola,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("Sprite",lstCategoria.get(0),lstMarca.get(4),lstTipo.get(0),100,20,48,R.drawable.sprite,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("Red Bull",lstCategoria.get(0),lstMarca.get(5),lstTipo.get(0),100,20,48,R.drawable.redbull,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("2M",lstCategoria.get(1),lstMarca.get(6),lstTipo.get(0),150,50,48,R.drawable.doism,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("Preta",lstCategoria.get(1),lstMarca.get(7),lstTipo.get(0),150,50,48,R.drawable.laurentinalata,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("Manica",lstCategoria.get(1),lstMarca.get(8),lstTipo.get(0),150,50,48,R.drawable.manicalata,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("Heineken",lstCategoria.get(1),lstMarca.get(9),lstTipo.get(0),150,50,48,R.drawable.heinekenlata,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("Super Bock",lstCategoria.get(1),lstMarca.get(10),lstTipo.get(0),150,50,48,R.drawable.superbocklata,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("Tequila Blanco",lstCategoria.get(2),lstMarca.get(11),lstTipo.get(0),4500,20,48,R.drawable.tequila,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("Chocolate Tequila",lstCategoria.get(2),lstMarca.get(11),lstTipo.get(0),4500,20,48,R.drawable.olmeca_dark_chocolate_tequila,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("Sour Apple",lstCategoria.get(2),lstMarca.get(12),lstTipo.get(0),4500,20,48,R.drawable.tang,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("Absolut",lstCategoria.get(2),lstMarca.get(13),lstTipo.get(0),3500,20,48,R.drawable.absolut,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("Sapphire",lstCategoria.get(2),lstMarca.get(14),lstTipo.get(0),4000,20,48,R.drawable.bombay,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("Tanqueray",lstCategoria.get(2),lstMarca.get(15),lstTipo.get(0),3500,20,48,R.drawable.tanqueray,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("Hendrick's",lstCategoria.get(2),lstMarca.get(16),lstTipo.get(0),4500,20,48,R.drawable.hendricks,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("Red Label",lstCategoria.get(2),lstMarca.get(17),lstTipo.get(0),3500,750,48,R.drawable.jw_red_label,lstFornecedor.get(0),lstUtilizador.get(0)));
        lstProduto.add(new Produto("Black Label",lstCategoria.get(2),lstMarca.get(17),lstTipo.get(0),4500,850,48,R.drawable.jw_black_label,lstFornecedor.get(0),lstUtilizador.get(0)));
    }

}

//            lstProduto.add(new Produto("Agua","Refrigerantes","Montemor",100,20,48,R.drawable.agua_sem_gas,"Maray","Manuel Gomes"));
//            lstProduto.add(new Produto("Sumo",lstCategoria.get(0),lstMarca.get(1),200,100,10,R.drawable.ceres,"machiza1"));
//            lstProduto.add(new Produto("Refrigerante","Schweppes","Ginger Ale",48,R.drawable.ginger_ale,"machiza1"));
//            lstProduto.add(new Produto("Refrigerante","Schweppes","Dry Lemon",48,R.drawable.dry_lemon,"machiza1"));
//            lstProduto.add(new Produto("Refrigerante","Schweppes","Wonic Water",24,R.drawable.schweppes_wonic_water,"machiza1"));
//            lstProduto.add(new Produto("Refrigerante","Coca-Cola","Coca-Cola",92,R.drawable.coca_cola,"machiza1"));
//            lstProduto.add(new Produto("Refrigerante","Coca-Cola","Sprite",24,R.drawable.sprite,"machiza1"));
//            lstProduto.add(new Produto("Refrigerante","Red Bull","Red Bull",60,R.drawable.redbull,"machiza1"));
//            lstProduto.add(new Produto("Cerveja","2M","2M",72,R.drawable.doism,"machiza1"));
//            lstProduto.add(new Produto("Cerveja","Laurentina","Preta",72,R.drawable.laurentinalata,"machiza1"));
//            lstProduto.add(new Produto("Cerveja","Manica","Manica",72,R.drawable.manicalata,"machiza1"));
//            lstProduto.add(new Produto("Cerveja","Heineken","Heineken",72,R.drawable.heinekenlata,"machiza1"));
//            lstProduto.add(new Produto("Cerveja","Super Bock","Super Bock",72,R.drawable.superbocklata,"machiza1"));
//            lstProduto.add(new Produto("Cerveja","Super Bock","Super Bock",72,R.drawable.superbocklata,"machiza1"));
//            lstProduto.add(new Produto("Seca","Olmeca","Tequila Blanco",6,R.drawable.tequila,"machiza1"));
//            lstProduto.add(new Produto("Seca","Olmeca","Chocolate Tequila",6,R.drawable.olmeca_dark_chocolate_tequila,"machiza1"));
//            lstProduto.add(new Produto("Seca","Tango","Sour Apple",6,R.drawable.tang,"machiza1"));
//            lstProduto.add(new Produto("Seca","Absolut","Vodka",6,R.drawable.absolut,"machiza1"));
//            lstProduto.add(new Produto("Seca","Bombay","Sapphire",6,R.drawable.bombay,"machiza1"));
//            lstProduto.add(new Produto("Seca","Tanqueray","Gin",6,R.drawable.tanqueray,"machiza1"));
//            lstProduto.add(new Produto("Seca","Hendrick's","Gin",6,R.drawable.hendricks,"machiza1"));
//            lstProduto.add(new Produto("Seca","John Walker","Whisky",8,R.drawable.jw_red_label,"machiza1"));
//            lstProduto.add(new Produto("Seca","John Walker","Whisky",4,R.drawable.jw_black_label,"machiza1"));












