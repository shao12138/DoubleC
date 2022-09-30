package com.ysy.doublec.Pojo;

public class Cell {
    private int id;
    private String name;
    private String kind;
    private String num;
    private String price;
    private String num_now;
    private String capacity;
    private String capacity_now;
    private String voltage;
    private String times;
    private String date;
    private String position;
    private String rent_time;
    

    public Cell() {
    }

    public Cell(int id, String name, String kind, String num, String price, String num_now, String capacity, String capacity_now, String voltage, String rent_time, String times, String date, String position) {
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.num = num;
        this.price = price;
        this.num_now = num_now;
        this.capacity = capacity;
        this.capacity_now = capacity_now;
        this.voltage = voltage;
        this.rent_time = rent_time;
        this.times = times;
        this.date = date;
        this.position = position;
    }

    public String getRent_time() {
        return rent_time;
    }

    public void setRent_time(String rent_time) {
        this.rent_time = rent_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNum_now() {
        return num_now;
    }

    public void setNum_now(String num_now) {
        this.num_now = num_now;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getCapacity_now() {
        return capacity_now;
    }

    public void setCapacity_now(String capacity_now) {
        this.capacity_now = capacity_now;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
