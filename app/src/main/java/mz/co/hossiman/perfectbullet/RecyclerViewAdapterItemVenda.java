package mz.co.hossiman.perfectbullet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mz.co.hossiman.perfectbullet.model.Produto;

/**
 * Created by secreto on 3/13/18.
 */

public class RecyclerViewAdapterItemVenda extends RecyclerView.Adapter<RecyclerViewAdapterItemVenda.MyViewHolder> {

    private Context mContext;
    private List<Produto> lstProduto;
    private float total = 0;

    public RecyclerViewAdapterItemVenda(Context mContext, List<Produto> lstProduto) {
        this.mContext = mContext;
        this.lstProduto = lstProduto;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.cards_item_venda, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        total += lstProduto.get(position).getPreco() * lstProduto.get(position).getQuantidade();

        holder.tvDescricao.setText(lstProduto.get(position).getNome());
        holder.tvPreco.setText(lstProduto.get(position).getPreco()+"");
        holder.tvQuantidade.setText(lstProduto.get(position).getQuantidade()+"");
        holder.tvSubtotal.setText((lstProduto.get(position).getPreco() * lstProduto.get(position).getQuantidade())+"");

        DB.totalPagar = total;

    }

    @Override
    public int getItemCount() {
        return lstProduto.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvDescricao, tvPreco, tvQuantidade, tvSubtotal;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvDescricao = (TextView) itemView.findViewById(R.id.tvDescricaoItemVendaId);
            tvPreco = (TextView) itemView.findViewById(R.id.tvPrecoItemVendaId);
            tvQuantidade = (TextView) itemView.findViewById(R.id.tvQuantItemVendaId);
            tvSubtotal = (TextView) itemView.findViewById(R.id.tvSubtotalItemVendaId);
        }
    }
}
