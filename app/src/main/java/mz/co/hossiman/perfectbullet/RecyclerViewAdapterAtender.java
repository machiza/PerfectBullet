package mz.co.hossiman.perfectbullet;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nex3z.notificationbadge.NotificationBadge;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import mz.co.hossiman.perfectbullet.model.Produto;
import mz.co.hossiman.perfectbullet.model.SelectCount;

/**
 * Created by secreto on 3/5/18.
 */

public class RecyclerViewAdapterAtender extends RecyclerView.Adapter<RecyclerViewAdapterAtender.MyViewHolder> {

    private Context mContext;
    private List<Produto> lstProduto;
    private View parent, b;


    public RecyclerViewAdapterAtender(Context mContext, List<Produto> lstProduto, View b) {
        this.mContext = mContext;
        this.lstProduto = lstProduto;
        this.b = b;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cards_produtos_atender,parent,false);
        this.parent = parent;

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.ivAtender.setImageResource(lstProduto.get(position).getThumbnail());
        holder.tvAtender.setText(lstProduto.get(position).getNome());

        for (SelectCount sc : DB.lstSelectCount) {
            if (lstProduto.get(position).getThumbnail() == sc.getThumbial()) {
                holder.mBadge.setNumber(sc.getCount());
                holder.count = sc.getCount();
            }
        }

//        if (DB.lstSelectCount.get(position).getCount() != 0) {
//            holder.count += DB.lstSelectCount.get(position).getCount();
//        }



//        BottomBar bottomBar = parent.findViewById(R.id.bottomBar);
//        View oldTab = bottomBar.getTabWithId(R.id.tab_limpar);
//        oldTab.setVisibility(View.VISIBLE);

        holder.cards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.count += 1;
                DB.lstSelectCount.get(position).setCount(holder.count);
                holder.mBadge.setNumber(DB.lstSelectCount.get(position).getCount());
                b.setVisibility(View.VISIBLE);
            }
        });

//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DB.lstSelectCount.clear();
//                holder.mBadge.setNumber(0);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return lstProduto.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivAtender;
        TextView tvAtender;
        RelativeLayout cards;
        NotificationBadge mBadge;
        Context context;
        private int count = 0;

        public MyViewHolder(View itemView) {
            super(itemView);

            ivAtender = (ImageView) itemView.findViewById(R.id.iv_atender_id);
            tvAtender = (TextView) itemView.findViewById(R.id.tv_variedade_id);
            cards = (RelativeLayout) itemView.findViewById(R.id.cardas_atender_id);
            mBadge = (NotificationBadge) itemView.findViewById(R.id.badge);
            context = mContext.getApplicationContext();
        }
    }
}
