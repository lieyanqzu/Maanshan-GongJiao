package com.flame.gongjiao.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.flame.gongjiao.R;
import com.flame.gongjiao.bean.LineStationBean;
import com.flame.gongjiao.bean.RunBusBean;
import com.flame.gongjiao.net.BusTimeInfoNet;
import com.flame.gongjiao.net.LineStationNet;
import com.flame.gongjiao.net.RunBusNet;
import com.flame.gongjiao.util.DialogUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.ViewHolder> {

    private List<LineStationBean.StationListBean> list = new ArrayList<>();
    private String lineCode;
    private String sxx;

    public StationAdapter(final String lineCode, final String sxx) {
        this.lineCode = lineCode;
        this.sxx = sxx;
        LineStationNet.getLineStation(lineCode, new LineStationNet.callback() {
            @Override
            public void onResponse(LineStationBean data) {
                for (LineStationBean.StationListBean station : data.getStationList()) {
                    if (TextUtils.equals(station.getSxx(), sxx)) {
                        list.add(station);
                    }
                }
                StationAdapter.this.notifyDataSetChanged();
            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_line_station, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.stationName.setText(list.get(position).getStationName());
        holder.comeTime.setText(getComeTime(String.valueOf(list.get(position).getStationOrder())));
    }

    private String getComeTime(final String zd) {
        return BusTimeInfoNet.getComeTime(lineCode, zd, sxx);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.station_name)
        TextView stationName;
        @BindView(R.id.come_time)
        TextView comeTime;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
