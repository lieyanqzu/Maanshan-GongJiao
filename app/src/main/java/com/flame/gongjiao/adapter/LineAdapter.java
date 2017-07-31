package com.flame.gongjiao.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.flame.gongjiao.R;
import com.flame.gongjiao.activity.LineActivity;
import com.flame.gongjiao.bean.LineBean;
import com.flame.gongjiao.util.Global;

import java.lang.ref.WeakReference;
import java.util.List;

public class LineAdapter extends RecyclerView.Adapter<LineAdapter.ViewHolder> {

    private List<LineBean.LineListBean> list = Global.getLine().getLineList();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_line, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.lineName.setText(list.get(position).getLineName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.line_name)
        TextView lineName;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.line_card)
        void startLinePage(View v) {
            int position = this.getAdapterPosition();
            LineActivity.StartUp(v.getContext(), lineName,
                    list.get(position).getLineName(), list.get(position).getLineCode());
        }
    }
}
