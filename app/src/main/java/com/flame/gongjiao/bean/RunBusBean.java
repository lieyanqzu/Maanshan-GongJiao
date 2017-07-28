package com.flame.gongjiao.bean;

@SuppressWarnings("unused")
public class RunBusBean {
    /**
     * busCode : 16002
     * lat : 31.719897
     * lineCode : 8
     * lon : 118.528482
     * passStation : 6
     * sxx : 0
     */

    private int busCode;
    private String lat;
    private int lineCode;
    private String lon;
    private int passStation;
    private int sxx;

    public int getBusCode() {
        return busCode;
    }

    public void setBusCode(int busCode) {
        this.busCode = busCode;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public int getLineCode() {
        return lineCode;
    }

    public void setLineCode(int lineCode) {
        this.lineCode = lineCode;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public int getPassStation() {
        return passStation;
    }

    public void setPassStation(int passStation) {
        this.passStation = passStation;
    }

    public int getSxx() {
        return sxx;
    }

    public void setSxx(int sxx) {
        this.sxx = sxx;
    }
}
