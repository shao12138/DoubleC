package com.ysy.doublec.Pojo;

public class Cell {
    private int id;
    private String name;
    private String kind;
    private Integer num;
    private Integer price;
    private Integer num_now;
    private Integer capacity;
    private Integer capacity_now;
    private Integer valtage;
    private Integer times;
    private Integer date;
    private String position;
    private String rent_time;
    private String targetName;

    public Cell() {
    }

    public Cell(int id, String name, String kind, Integer num, Integer price, Integer num_now, Integer capacity, Integer capacity_now, Integer valtage, Integer times, Integer date, String position, String rent_time, String targetName) {
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.num = num;
        this.price = price;
        this.num_now = num_now;
        this.capacity = capacity;
        this.capacity_now = capacity_now;
        this.valtage = valtage;
        this.times = times;
        this.date = date;
        this.position = position;
        this.rent_time = rent_time;
        this.targetName = targetName;
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum_now() {
        return num_now;
    }

    public void setNum_now(Integer num_now) {
        this.num_now = num_now;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCapacity_now() {
        return capacity_now;
    }

    public void setCapacity_now(Integer capacity_now) {
        this.capacity_now = capacity_now;
    }

    public Integer getValtage() {
        return valtage;
    }

    public void setValtage(Integer valtage) {
        this.valtage = valtage;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRent_time() {
        return rent_time;
    }

    public void setRent_time(String rent_time) {
        this.rent_time = rent_time;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }
}
