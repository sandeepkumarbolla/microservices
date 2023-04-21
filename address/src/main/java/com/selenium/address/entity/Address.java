package com.selenium.address.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    //id,lane1 , lane2, state, zip, employee_id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "lane1")
    private String lane1;
    @Column(name = "lane2")
    private String lane2;
    @Column(name = "state")
    private String state;
    @Column(name = "zip")
    private long zip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLane1() {
        return lane1;
    }

    public void setLane1(String lane1) {
        this.lane1 = lane1;
    }

    public String getLane2() {
        return lane2;
    }

    public void setLane2(String lane2) {
        this.lane2 = lane2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }

    public Address(int id, String lane1, String lane2, String state, long zip) {
        this.id = id;
        this.lane1 = lane1;
        this.lane2 = lane2;
        this.state = state;
        this.zip = zip;
    }

    public Address() {
    }
}
