package com.company.entities;

import java.io.Serializable;
import java.time.Period;

public class Periodic implements Serializable
{
    //          - поля -

    // назва
    private String title;
    // вид
    private String type;
    // періодичність видання
    private Period period;
    // ціна
    private Double price;
    // видавництво
    private String publishingHouse;
    // ПІБ головного редактору
    private String fullName;

    //          - конструктори -

    // конструктор за замовчуванням
    public Periodic() {
        this.title = "No title";
        this.type = "No type";
        this.period = Period.of(0, 0, 1);
        this.price = 0.0;
        this.publishingHouse = "No publishing house";
        this.fullName = "No full name";
    }

    // конструктор з параметрами
    public Periodic(String title, String type, Period period, Double price, String publishingHouse, String fullName) {
        this.title = title;
        this.type = type;
        this.period = period;
        this.price = price;
        this.publishingHouse = publishingHouse;
        this.fullName = fullName;
    }

    //          - методи -

    //          - getters -

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public Period getPeriod() {
        return period;
    }

    public Double getPrice() {
        return price;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public String getFullName() {
        return fullName;
    }

    //          - setters

    public void setTitle(String title)
    {
        if(title.isBlank())
        {
            this.title = "No title";
            return;
        }
        this.title = title;
    }

    public void setType(String type)
    {
        if(type.isBlank())
        {
            this.type = "No type";
            return;
        }
        this.type = type;
    }

    public void setPeriod(Period period)
    {
        if(period == null)
        {
            this.period = Period.of(0,0,0);
            return;
        }
        this.period = period;
    }

    public void setPrice(Double price)
    {
        if(price < 0)
        {
            this.price = 0.0;
            return;
        }
        this.price = price;
    }

    public void setPublishingHouse(String publishingHouse)
    {
        if(publishingHouse.isBlank())
        {
            this.publishingHouse = "No publishing house";
            return;
        }
        this.publishingHouse = publishingHouse;
    }

    public void setFullName(String fullName) {
        if(fullName.isBlank())
        {
            this.fullName = "No full name";
            return;
        }
        this.fullName = fullName;
    }

    // @Override toString

    @Override
    public String toString() {
        return "Title: "+title +"\n"+
                "Type: "+type +"\n"+
                "Period: "+period +"\n"+
                "Price: "+price +"\n"+
                "Publishing house: "+publishingHouse +"\n"+
                "Full name: "+fullName +"\n";
    }
}
