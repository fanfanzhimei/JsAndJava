package com.zhi.domain;

/**
 * Created by Administrator on 2016/11/9.
 */
public class Contact {
    private int id;
    private String name;
    private int amount;
    private String phone;

    public Contact(int id, String name, int amount, String phone){
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}