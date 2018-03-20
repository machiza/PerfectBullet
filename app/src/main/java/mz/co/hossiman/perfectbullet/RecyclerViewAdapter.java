package mz.co.hossiman.perfectbullet;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import mz.co.hossiman.perfectbullet.model.Categoria;
import mz.co.hossiman.perfectbullet.model.Produto;

/**
 * Created by secreto on 3/4/18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Produto> lstProduto;
    private View parent;
    Dialog myDialog;
    ArrayList<String> categorias;

    public RecyclerViewAdapter(Context mContext, List<Produto> lstProduto) {
        this.mContext = mContext;
        this.lstProduto = lstProduto;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        this.parent = parent;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cards_produtos_stock, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.ivIconProduto.setImageResource(lstProduto.get(position).getThumbnail());
        holder.tvCategoria.setText(lstProduto.get(position).getNome());
        holder.tvMarca.setText("- "+lstProduto.get(position).getMarca().getNome());
        holder.tvQuantidade.setText(lstProduto.get(position).getQuantidade()+"");

        categorias = new ArrayList<>();
        for (Categoria marca : DB.lstCategoria) {
            categorias.add(marca.getNome());
        }

        // Dialog ini
        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_stock);

        initSpinner(myDialog);

        holder.cardviewStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Text Click"+String.valueOf(position),Toast.LENGTH_SHORT).show();
                Spinner spinnerCategoria = myDialog.findViewById(R.id.categoria_edit_id);
                EditText etMarca = myDialog.findViewById(R.id.tv_marca_edit_id);
                EditText etVariedade = myDialog.findViewById(R.id.et_variedade_edit_id);
                Spinner spinnerQuantidade = myDialog.findViewById(R.id.quantidade_edit_id);

                int pos = 0;
                if(lstProduto.get(position).getCategoria().getNome().equalsIgnoreCase("Refrigerantes")) {
                    pos = 0;
                } else if(lstProduto.get(position).getCategoria().getNome().equalsIgnoreCase("Cervejas")) {
                    pos = 1;
                } else {
                    pos = 2;
                }
//
                spinnerCategoria.setSelection(pos);
//                etMarca.setText(lstProduto.get(position).getMarca().getNome());
//                etVariedade.setText(lstProduto.get(position).getNome());
//                spinnerQuantidade.setSelection(lstProduto.get(position).getQuantidade());
//
                myDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstProduto.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvCategoria, tvMarca, tvQuantidade;
        ImageView ivIconProduto;
        RelativeLayout cardviewStock;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvCategoria = (TextView) itemView.findViewById(R.id.categoria_stock_id);
            tvMarca = (TextView) itemView.findViewById(R.id.marca_stock_id);
            tvQuantidade = (TextView) itemView.findViewById(R.id.quantidade_stock_id);
            ivIconProduto = (ImageView) itemView.findViewById(R.id.icon_stock_id);
            cardviewStock = (RelativeLayout) itemView.findViewById(R.id.cardview_stock_id);
        }



    }

    public void initSpinner(Dialog myDialog) {
        Spinner spinner = myDialog.findViewById(R.id.categoria_edit_id);
        Spinner spinner2 = myDialog.findViewById(R.id.quantidade_edit_id);

        if (spinner == null || spinner2 == null) {
            return;
        }

        ArrayList<String> quantidades = new ArrayList<>();
        for (int i = 0; i <= 116; i++) {
            quantidades.add(i+"");
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(myDialog.getContext(),
                android.R.layout.simple_dropdown_item_1line, categorias);

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(myDialog.getContext(),
                android.R.layout.simple_dropdown_item_1line,quantidades);

        spinner.setAdapter(arrayAdapter);
        spinner2.setAdapter(arrayAdapter1);
    }

//    public void setDialog(Dialog myDialog) {
//        Spinner spinnerCategoria = myDialog.findViewById(R.id.categoria_edit_id);
//
//        int pos = categorias.equals()
//
//        spinnerCategoria.setSelection();
//    }

}
