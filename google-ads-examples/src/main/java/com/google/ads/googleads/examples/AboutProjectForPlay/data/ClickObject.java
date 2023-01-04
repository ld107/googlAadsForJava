package com.google.ads.googleads.examples.AboutProjectForPlay.data;

public class ClickObject {
   public String id;
   public String app_id;
    public  int datetime;
    public String uuid;
    public String count_uuid;
    public  int count_num;
    public  int btime;
    public String app_name;
    public String region;
    public String region_id;

    public ClickObject(String id, String app_id, int datetime, String uuid, String count_uuid, int count_num, int btime, String app_name, String region, String region_id, String region_name) {
        this.id = id;
        this.app_id = app_id;
        this.datetime = datetime;
        this.uuid = uuid;
        this.count_uuid = count_uuid;
        this.count_num = count_num;
        this.btime = btime;
        this.app_name = app_name;
        this.region = region;
        this.region_id = region_id;
        this.region_name = region_name;
    }

    public String region_name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public int getDatetime() {
        return datetime;
    }

    public void setDatetime(int datetime) {
        this.datetime = datetime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCount_uuid() {
        return count_uuid;
    }

    public void setCount_uuid(String count_uuid) {
        this.count_uuid = count_uuid;
    }

    public int getCount_num() {
        return count_num;
    }

    public void setCount_num(int count_num) {
        this.count_num = count_num;
    }

    public int getBtime() {
        return btime;
    }

    public void setBtime(int btime) {
        this.btime = btime;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion_id() {
        return region_id;
    }

    public void setRegion_id(String region_id) {
        this.region_id = region_id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }
}
