package com.flame.gongjiao.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.flame.gongjiao.R;
import com.flame.gongjiao.adapter.StationAdapter;
import com.flame.gongjiao.bean.LineStationBean;
import com.flame.gongjiao.net.BusTimeInfoNet;
import com.flame.gongjiao.net.LineStationNet;
import com.flame.gongjiao.util.DialogUtil;

public class LineActivity extends AppCompatActivity {

    @BindView(R.id.activity_line)
    CoordinatorLayout coordinator;
    @BindView(R.id.app_bar)
    AppBarLayout appbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsing;
    @BindView(R.id.line_info)
    TextView lineInfo;
    @BindView(R.id.line_name_title)
    TextView lineNameTitle;
    @BindView(R.id.line_fab)
    FloatingActionButton fab;
    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;
    @BindView(R.id.line_station_list)
    RecyclerView lineStationList;

    private String lineName;
    private String lineCode;
    private String sxx = "0";
    private StationAdapter adapter;

    public static void StartUp(Context context, View transition, String lineCode, String lineName) {
        DialogUtil.showProcessDia(context);
        Intent intent = new Intent(context, LineActivity.class);
        intent.putExtra("lineName", lineCode);
        intent.putExtra("lineCode", lineName);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                (Activity) context, transition, "Title"
        );
        ActivityCompat.startActivity(context, intent, options.toBundle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        Bundle bundle = getIntent().getExtras();
        lineCode = bundle.getString("lineCode", "");
        lineName = bundle.getString("lineName", "");
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter = new StationAdapter(lineCode, sxx);
        lineStationList.setAdapter(adapter);
    }

    private void initView() {
        ButterKnife.bind(this);
        ViewCompat.setTransitionName(lineNameTitle, "Title");

        lineNameTitle.setText(lineName);
        if (lineName.length() > 5) {
            lineNameTitle.setTextSize(36);
        }

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsing.setTitle(lineName);
        collapsing.setExpandedTitleColor(Color.TRANSPARENT);
        collapsing.setScrimAnimationDuration(100);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sxx = TextUtils.equals(sxx, "0") ? "1" : "0";
                initInfo();
                adapter = new StationAdapter(lineCode, sxx);
                lineStationList.setAdapter(adapter);
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(this);
        lineStationList.setLayoutManager(manager);
        initInfo();
    }

    private void initInfo() {
        LineStationNet.getLineStation(lineCode, new LineStationNet.callback() {
            @Override
            public void onResponse(LineStationBean data) {
                StringBuilder sb = new StringBuilder();
                LineStationBean.LineListBean item = null;
                for (LineStationBean.LineListBean line : data.getLineList()) {
                    if (TextUtils.equals(line.getSxx(), sxx)) {
                        item = line;
                        break;
                    }
                }
                if (item == null) return;
                sb.append("运行区间：")
                        .append(item.getBeginStation())
                        .append("——>>")
                        .append(item.getEndStation())
                        .append("\n运营时长：")
                        .append(BusTimeInfoNet.getRunBusTime(lineCode, sxx))
                        .append("\n下班发车时间：")
                        .append(BusTimeInfoNet.getNextBusTime(lineCode, sxx));
                lineInfo.setText(sb.toString());
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        DialogUtil.dismissProcessDia();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DialogUtil.dismissProcessDia();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
