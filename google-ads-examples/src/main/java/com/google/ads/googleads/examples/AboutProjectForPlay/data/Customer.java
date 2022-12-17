package com.google.ads.googleads.examples.AboutProjectForPlay.data;

public class Customer {

//Customer with ID %d, descriptive name '%s', currency code '%s', timezone '%s', "
//                            + "tracking URL template '%s' and auto tagging enabled '%s' was retrieved.%n
    private int ID;
    public String name;
    public String code;
    public String timezone;
    public String template;
    public String enable;

    public Customer(int ID, String name, String code, String timezone, String template, String enable) {
        this.ID = ID;
        this.name = name;
        this.code = code;
        this.timezone = timezone;
        this.template = template;
        this.enable = enable;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }
}
