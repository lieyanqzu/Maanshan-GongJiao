package com.flame.gongjiao.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;

import java.util.List;

@SuppressWarnings("unused")
public class LineBean {
    private List<LineListBean> lineList;

    public List<LineListBean> getLineList() {
        return lineList;
    }

    public void setLineList(List<LineListBean> lineList) {
        this.lineList = lineList;
    }

    public static class LineListBean implements SearchSuggestion, Parcelable {
        /**
         * beginStation :
         * beginTime :
         * busCode :
         * endStation :
         * endTime :
         * lat :
         * lineCode : 1
         * lineName : 1路
         * lon :
         * maxOrder : 0
         * minOrder : 0
         * pos : 0
         * staDis :
         * stationCode :
         * stationName :
         * stationOrder : 0
         * sxx :
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


        @Override
        public String getBody() {
            return getLineName();
        }

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.beginStation);
            dest.writeString(this.beginTime);
            dest.writeString(this.busCode);
            dest.writeString(this.endStation);
            dest.writeString(this.endTime);
            dest.writeString(this.lat);
            dest.writeString(this.lineCode);
            dest.writeString(this.lineName);
            dest.writeString(this.lon);
            dest.writeInt(this.maxOrder);
            dest.writeInt(this.minOrder);
            dest.writeInt(this.pos);
            dest.writeString(this.staDis);
            dest.writeString(this.stationCode);
            dest.writeString(this.stationName);
            dest.writeInt(this.stationOrder);
            dest.writeString(this.sxx);
            dest.writeString(this.upDown);
            dest.writeString(this.upDownName);
        }

        public LineListBean() {
        }

        protected LineListBean(Parcel in) {
            this.beginStation = in.readString();
            this.beginTime = in.readString();
            this.busCode = in.readString();
            this.endStation = in.readString();
            this.endTime = in.readString();
            this.lat = in.readString();
            this.lineCode = in.readString();
            this.lineName = in.readString();
            this.lon = in.readString();
            this.maxOrder = in.readInt();
            this.minOrder = in.readInt();
            this.pos = in.readInt();
            this.staDis = in.readString();
            this.stationCode = in.readString();
            this.stationName = in.readString();
            this.stationOrder = in.readInt();
            this.sxx = in.readString();
            this.upDown = in.readString();
            this.upDownName = in.readString();
        }

        public static final Parcelable.Creator<LineListBean> CREATOR = new Parcelable.Creator<LineListBean>() {
            @Override
            public LineListBean createFromParcel(Parcel source) {
                return new LineListBean(source);
            }

            @Override
            public LineListBean[] newArray(int size) {
                return new LineListBean[size];
            }
        };
    }
}
