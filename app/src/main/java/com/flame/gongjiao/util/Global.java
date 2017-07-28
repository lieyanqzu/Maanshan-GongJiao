package com.flame.gongjiao.util;

import com.flame.gongjiao.bean.LineBean;
import com.flame.gongjiao.bean.StationBean;

@SuppressWarnings("unused")
public class Global {

    public final static String CITY_CODE = "340500";

    private static String ip;
    private static String bsPort;
    private static String socPort;
    private static LineBean line;
    private static StationBean station;

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        Global.ip = ip;
    }

    public static String getBsPort() {
        return bsPort;
    }

    public static void setBsPort(String bsPort) {
        Global.bsPort = bsPort;
    }

    public static String getSocPort() {
        return socPort;
    }

    public static void setSocPort(String socPort) {
        Global.socPort = socPort;
    }

    public static LineBean getLine() {
        return line;
    }

    public static void setLine(LineBean line) {
        Global.line = line;
    }

    public static StationBean getStation() {
        return station;
    }

    public static void setStation(StationBean station) {
        Global.station = station;
    }

    public static String getBsAddress() {
        return "http://" + ip + ":" + bsPort;
    }

    public static String getSocAddress() {
        return "http://" + ip + ":" + socPort;
    }

}
