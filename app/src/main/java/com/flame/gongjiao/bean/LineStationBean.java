package com.flame.gongjiao.bean;

import java.util.List;

@SuppressWarnings("unused")
public class LineStationBean {
    private List<LineListBean> lineList;
    private List<StationListBean> stationList;
    private List<BusTimeListBean> busTimeList;

    public List<LineListBean> getLineList() {
        return lineList;
    }

    public void setLineList(List<LineListBean> lineList) {
        this.lineList = lineList;
    }

    public List<StationListBean> getStationList() {
        return stationList;
    }

    public void setStationList(List<StationListBean> stationList) {
        this.stationList = stationList;
    }

    public List<BusTimeListBean> getBusTimeList() {
        return busTimeList;
    }

    public void setBusTimeList(List<BusTimeListBean> busTimeList) {
        this.busTimeList = busTimeList;
    }

    public static class LineListBean {
        /**
         * beginStation : 同舟路（快捷驾校）
         * beginTime :
         * busCode :
         * endStation : 朱然文化公园
         * endTime :
         * lat :
         * lineCode : 8
         * lineName : 8路
         * lon :
         * maxOrder : 26
         * minOrder : 1
         * pos : 0
         * staDis :
         * stationCode :
         * stationName :
         * stationOrder : 0
         * sxx : 0
         * upDown :
         * upDownName :
         */

        private String beginStation;
        private String beginTime;
        private String busCode;
        private String endStation;
        private String endTime;
        private String lat;
        private String lineCode;
        private String lineName;
        private String lon;
        private int maxOrder;
        private int minOrder;
        private int pos;
        private String staDis;
        private String stationCode;
        private String stationName;
        private int stationOrder;
        private String sxx;
        private String upDown;
        private String upDownName;

        public String getBeginStation() {
            return beginStation;
        }

        public void setBeginStation(String beginStation) {
            this.beginStation = beginStation;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getBusCode() {
            return busCode;
        }

        public void setBusCode(String busCode) {
            this.busCode = busCode;
        }

        public String getEndStation() {
            return endStation;
        }

        public void setEndStation(String endStation) {
            this.endStation = endStation;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLineCode() {
            return lineCode;
        }

        public void setLineCode(String lineCode) {
            this.lineCode = lineCode;
        }

        public String getLineName() {
            return lineName;
        }

        public void setLineName(String lineName) {
            this.lineName = lineName;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public int getMaxOrder() {
            return maxOrder;
        }

        public void setMaxOrder(int maxOrder) {
            this.maxOrder = maxOrder;
        }

        public int getMinOrder() {
            return minOrder;
        }

        public void setMinOrder(int minOrder) {
            this.minOrder = minOrder;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public String getStaDis() {
            return staDis;
        }

        public void setStaDis(String staDis) {
            this.staDis = staDis;
        }

        public String getStationCode() {
            return stationCode;
        }

        public void setStationCode(String stationCode) {
            this.stationCode = stationCode;
        }

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public int getStationOrder() {
            return stationOrder;
        }

        public void setStationOrder(int stationOrder) {
            this.stationOrder = stationOrder;
        }

        public String getSxx() {
            return sxx;
        }

        public void setSxx(String sxx) {
            this.sxx = sxx;
        }

        public String getUpDown() {
            return upDown;
        }

        public void setUpDown(String upDown) {
            this.upDown = upDown;
        }

        public String getUpDownName() {
            return upDownName;
        }

        public void setUpDownName(String upDownName) {
            this.upDownName = upDownName;
        }
    }

    public static class StationListBean {
        /**
         * beginStation :
         * beginTime :
         * busCode :
         * endStation :
         * endTime :
         * lat : 31.720353333333332
         * lineCode : 8
         * lineName : 8路
         * lon : 118.554415
         * maxOrder : 0
         * minOrder : 0
         * pos : 0
         * staDis : 789.58
         * stationCode :
         * stationName : 同舟路（快捷驾校）
         * stationOrder : 1
         * sxx : 0
         * upDown :
         * upDownName :
         */

        private String beginStation;
        private String beginTime;
        private String busCode;
        private String endStation;
        private String endTime;
        private String lat;
        private String lineCode;
        private String lineName;
        private String lon;
        private int maxOrder;
        private int minOrder;
        private int pos;
        private String staDis;
        private String stationCode;
        private String stationName;
        private int stationOrder;
        private String sxx;
        private String upDown;
        private String upDownName;

        public String getBeginStation() {
            return beginStation;
        }

        public void setBeginStation(String beginStation) {
            this.beginStation = beginStation;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getBusCode() {
            return busCode;
        }

        public void setBusCode(String busCode) {
            this.busCode = busCode;
        }

        public String getEndStation() {
            return endStation;
        }

        public void setEndStation(String endStation) {
            this.endStation = endStation;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLineCode() {
            return lineCode;
        }

        public void setLineCode(String lineCode) {
            this.lineCode = lineCode;
        }

        public String getLineName() {
            return lineName;
        }

        public void setLineName(String lineName) {
            this.lineName = lineName;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public int getMaxOrder() {
            return maxOrder;
        }

        public void setMaxOrder(int maxOrder) {
            this.maxOrder = maxOrder;
        }

        public int getMinOrder() {
            return minOrder;
        }

        public void setMinOrder(int minOrder) {
            this.minOrder = minOrder;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public String getStaDis() {
            return staDis;
        }

        public void setStaDis(String staDis) {
            this.staDis = staDis;
        }

        public String getStationCode() {
            return stationCode;
        }

        public void setStationCode(String stationCode) {
            this.stationCode = stationCode;
        }

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public int getStationOrder() {
            return stationOrder;
        }

        public void setStationOrder(int stationOrder) {
            this.stationOrder = stationOrder;
        }

        public String getSxx() {
            return sxx;
        }

        public void setSxx(String sxx) {
            this.sxx = sxx;
        }

        public String getUpDown() {
            return upDown;
        }

        public void setUpDown(String upDown) {
            this.upDown = upDown;
        }

        public String getUpDownName() {
            return upDownName;
        }

        public void setUpDownName(String upDownName) {
            this.upDownName = upDownName;
        }
    }

    public static class BusTimeListBean {
        /**
         * beginStation :
         * beginTime : 0600
         * busCode :
         * endStation :
         * endTime : 1930
         * lat :
         * lineCode :
         * lineName :
         * lon :
         * maxOrder : 0
         * minOrder : 0
         * pos : 0
         * staDis :
         * stationCode :
         * stationName :
         * stationOrder : 0
         * sxx : 0
         * upDown :
         * upDownName :
         */

        private String beginStation;
        private String beginTime;
        private String busCode;
        private String endStation;
        private String endTime;
        private String lat;
        private String lineCode;
        private String lineName;
        private String lon;
        private int maxOrder;
        private int minOrder;
        private int pos;
        private String staDis;
        private String stationCode;
        private String stationName;
        private int stationOrder;
        private String sxx;
        private String upDown;
        private String upDownName;

        public String getBeginStation() {
            return beginStation;
        }

        public void setBeginStation(String beginStation) {
            this.beginStation = beginStation;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getBusCode() {
            return busCode;
        }

        public void setBusCode(String busCode) {
            this.busCode = busCode;
        }

        public String getEndStation() {
            return endStation;
        }

        public void setEndStation(String endStation) {
            this.endStation = endStation;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLineCode() {
            return lineCode;
        }

        public void setLineCode(String lineCode) {
            this.lineCode = lineCode;
        }

        public String getLineName() {
            return lineName;
        }

        public void setLineName(String lineName) {
            this.lineName = lineName;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public int getMaxOrder() {
            return maxOrder;
        }

        public void setMaxOrder(int maxOrder) {
            this.maxOrder = maxOrder;
        }

        public int getMinOrder() {
            return minOrder;
        }

        public void setMinOrder(int minOrder) {
            this.minOrder = minOrder;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public String getStaDis() {
            return staDis;
        }

        public void setStaDis(String staDis) {
            this.staDis = staDis;
        }

        public String getStationCode() {
            return stationCode;
        }

        public void setStationCode(String stationCode) {
            this.stationCode = stationCode;
        }

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public int getStationOrder() {
            return stationOrder;
        }

        public void setStationOrder(int stationOrder) {
            this.stationOrder = stationOrder;
        }

        public String getSxx() {
            return sxx;
        }

        public void setSxx(String sxx) {
            this.sxx = sxx;
        }

        public String getUpDown() {
            return upDown;
        }

        public void setUpDown(String upDown) {
            this.upDown = upDown;
        }

        public String getUpDownName() {
            return upDownName;
        }

        public void setUpDownName(String upDownName) {
            this.upDownName = upDownName;
        }
    }
}
