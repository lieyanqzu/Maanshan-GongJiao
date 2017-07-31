package com.flame.gongjiao.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arlib.floatingsearchview.FloatingSearchView;
import com.flame.gongjiao.R;
import com.flame.gongjiao.adapter.LineAdapter;
import com.flame.gongjiao.bean.AndroidDataBean;
import com.flame.gongjiao.bean.LineBean;
import com.flame.gongjiao.bean.StationBean;
import com.flame.gongjiao.bean.VersionBean;
import com.flame.gongjiao.net.AndroidDataNet;
import com.flame.gongjiao.net.LineNet;
import com.flame.gongjiao.net.StationNet;
import com.flame.gongjiao.net.VersionNet;
import com.flame.gongjiao.util.Global;
import com.flame.gongjiao.util.DialogUtil;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.floating_search)
    FloatingSearchView fsv;
    @BindView(R.id.line_list)
    RecyclerView lineList;

    private Boolean loadLinedone = false;
    private Boolean loadStationdone = true;

    private final String LINE_DATA = "linedata.json";
//    private final String STATION_DATA = "stationdata.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        new Thread(new Runnable() {
            @Override
            public void run() {
                initData();
            }
        }).start();
    }

    private void initView() {
        ButterKnife.bind(this);
        DialogUtil.showProcessDia(this);
        fsv.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, String newQuery) {
                if (!oldQuery.equals("") && newQuery.equals("")) {
                    fsv.clearSuggestions();
                } else {
                    fsv.showProgress();

                    //simulates a query call to a data source
                    //with a new query.
                    DataHelper.findSuggestions(getActivity(), newQuery, 5,
                            FIND_SUGGESTION_SIMULATED_DELAY, new DataHelper.OnFindSuggestionsListener() {

                                @Override
                                public void onResults(List<ColorSuggestion> results) {

                                    //this will swap the data and
                                    //render the collapse/expand animations as necessary
                                    fsv.swapSuggestions(results);

                                    //let the users know that the background
                                    //process has completed
                                    fsv.hideProgress();
                                }
                            });
                }
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(this);
        lineList.setLayoutManager(manager);
    }

    private void initData() {
        AndroidDataNet.getAndroidData(new AndroidDataNet.callback() {
            @Override
            public void onResponse(List<AndroidDataBean> data) {
                for (AndroidDataBean bean : data) {
                    if (TextUtils.equals(bean.getCityCode(), Global.CITY_CODE)) {
                        Global.setIp(bean.getIP());
                        Global.setBsPort(bean.getBS_Port());
                        Global.setSocPort(bean.getSocket_Port());
                        initVersion();
                        break;
                    }
                }
            }
        });
    }

    private void initVersion() {
        VersionNet.getVersion(new VersionNet.callback() {
            @Override
            public void onResponse(VersionBean data) {
                int version = Integer.valueOf(data.getVersionNumber());
                SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
                int oldVersion = pref.getInt("version", 0);
                if (version > oldVersion) {
                    SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                    editor.putInt("version", Integer.valueOf(data.getVersionNumber()));
                    editor.apply();
                    initInfo();
                } else {
                    loadLine();
//                    loadStation();
                }
            }
        });
    }

    private void initInfo() {
        LineNet.getLine(new LineNet.callback() {
            @Override
            public void onResponse(LineBean data) {
                saveLine(data);
                loadLine();
            }
        });
//        StationNet.getStation(new StationNet.callback() {
//            @Override
//            public void onResponse(StationBean data) {
//                saveStation(data);
//                loadStation();
//            }
//        });
    }

    private void saveLine(LineBean data) {
        saveData(data, LINE_DATA);
    }

//    private void saveStation(StationBean data) {
//        saveData(data, STATION_DATA);
//    }

    private void saveData(Object data, String name) {
        Gson gson = new Gson();
        FileOutputStream out;
        BufferedWriter writer = null;
        try {
            out = openFileOutput(name, Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(gson.toJson(data));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadLine() {
        try {
            Gson gson = new Gson();
            FileInputStream in = openFileInput(LINE_DATA);
            JsonReader reader = new JsonReader(new InputStreamReader(in));
            LineBean line = gson.fromJson(reader, LineBean.class);
            if (line != null)
                Global.setLine(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        loadLinedone = true;
        timeToDismiss();
    }

//    private void loadStation() {
//        try {
//            Gson gson = new Gson();
//            FileInputStream in = openFileInput(STATION_DATA);
//            JsonReader reader = new JsonReader(new InputStreamReader(in));
//            StationBean station = gson.fromJson(reader, StationBean.class);
//            if (station != null)
//                Global.setStation(station);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        loadStationdone = true;
//        timeToDismiss();
//    }

    private void timeToDismiss() {
        if (loadLinedone && loadStationdone) {
            DialogUtil.dismissProcessDia();
        }
        LineAdapter adapter = new LineAdapter();
        lineList.setAdapter(adapter);
    }
}
