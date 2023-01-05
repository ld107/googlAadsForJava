package com.google.ads.googleads.examples.AboutProjectForPlay.data;

public class ConversionData {
//    "事件id","地区","日期","事件uuid","事件出现次数","点击次数","btime",
//                "小时","分钟","包版本","包名称","转化后日期","天","转化小时","转化分钟"
    public String region;
    public String date;
    public String num;

    public ConversionData(String region, String date, String num) {
        this.region = region;
        this.date = date;
        this.num = num;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
