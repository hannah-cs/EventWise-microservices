package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String eventName;
    private Date eventDate;
    private Integer vendorId;
    private Integer clientId;

    public Event() {
    }

    public Event(String eventName, Date eventDate, Integer vendorId, Integer clientId) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.vendorId = vendorId;
        this.clientId = clientId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString(){
        return "Event Name: " + eventName
                + ", date: " + eventDate
                + ", client ID: " + clientId
                + ", vendor ID: " + vendorId;
    }

}
